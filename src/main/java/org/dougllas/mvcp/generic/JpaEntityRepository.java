package org.dougllas.mvcp.generic;

import org.dougllas.mvcp.model.PersistentEntity;
import org.dougllas.mvcp.tools.QueryCreator;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Criado por dougllas.sousa em 24/05/2017.
 */

@Service
public class JpaEntityRepository implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public <T> List<T> findAll(Class<T> clazz){
        return entityManager.createQuery("from ".concat(clazz.getSimpleName())).getResultList();
    }

    public <T extends PersistentEntity> T findById(Class<T> clazz, Serializable id){
        return entityManager.find(clazz, id);
    }

    public <T extends PersistentEntity> T save(T entity){
        if(entity.getId() == null){
           entityManager.persist(entity);
        }else{
            return entityManager.merge(entity);
        }
        return entity;
    }

    public <T extends PersistentEntity> void delete(T entity){
        if(entity.getId() ==  null){
            return;
        }

        entity = entityManager.merge(entity);
        entityManager.remove(entity);
    }

    public <T extends PersistentEntity> void saveAll(Collection<T> entities){
        if(CollectionUtils.isEmpty(entities)){
            return;
        }
        entities.stream().forEach( e -> save(e) );
    }

    public <T extends PersistentEntity> void deleteAll(Collection<T> entities){
        if(CollectionUtils.isEmpty(entities)){
            return;
        }
        entities.stream().forEach( e -> delete(e) );
    }

    public int executeUpdate(String queryS, Map<String, Object> params){
        Query query = entityManager.createQuery(queryS);
        addQueryParams(query,params);
        return query.executeUpdate();
    }

    public <T> List<T> queryForList(QueryCreator queryCreator){
        return queryForList(queryCreator.query(), queryCreator.params());
    }

    public <T> T queryForOne(QueryCreator queryCreator){
        return queryForOne(queryCreator.query(), queryCreator.params());
    }

    public <T> List<T> queryForList(String queryS){
        return queryForList(queryS, (Object) null);
    }

    public <T> List<T> queryForList(String queryS, Map<String, Object> params){
        Query query = entityManager.createQuery(queryS);
        addQueryParams(query, params);
        return query.getResultList();
    }

    public <T> List<T> queryForList(String queryS, Object... params){
        Query query = entityManager.createQuery(queryS);
        addQueryParams(query, params);
        return query.getResultList();
    }

    public <T> T queryForOne(String queryS){
        return queryForOne(queryS, null);
    }

    public <T> T queryForOne(String queryS, Map<String, Object> params){
        Query query = entityManager.createQuery(queryS);
        addQueryParams(query,params);
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> sqlQueryForList(String queryS){
        return sqlQueryForList(queryS, null);
    }

    public <T> List<T> sqlQueryForList(String queryS, Map<String, Object> params){
        Query query = entityManager.createNativeQuery(queryS);
        addQueryParams(query, params);
        return query.getResultList();
    }

    public <T> T sqlQueryForOne(String queryS){
        return sqlQueryForOne(queryS, null);
    }

    public <T> T sqlQueryForOne(String queryS, Map<String, Object> params){
        Query query = entityManager.createNativeQuery(queryS);
        addQueryParams(query,params);
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void addQueryParams(Query query, Map<String, Object> params) {
        if(query != null && params != null){
            for (String param : params.keySet()) {
                Object value = params.get(param);
                query.setParameter(param, value);
            }
        }
    }

    public static void addQueryParams(Query query, Object... params) {
        if(query != null && params != null){
            int position = 1;
            for (Object param : params) {
                query.setParameter(position++, param);
            }
        }
    }

    public CriteriaBuilder getCriteriaBuilder(){
        return entityManager.getCriteriaBuilder();
    }

    public QueryCreator generateExampleQuery(PersistentEntity entity, String entityAlias, boolean enableLike ) {
        Class entityClass = entity.getClass();

        if(entityAlias == null)
            entityAlias = "obj";

        QueryCreator sb = new QueryCreator();
        sb.append("select " + entityAlias + " from ");
        sb.append(entityClass.getSimpleName() + " " + entityAlias + " ");

        sb.append( " where 1 = 1 ");

        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field f : fields) {

            f.setAccessible(true);
            String fieldName = f.getName();

            boolean isSerialVersionUID = fieldName.equalsIgnoreCase("serialVersionUID");
            boolean isTransient = f.isAnnotationPresent(Transient.class);
            boolean isOneToMany = f.isAnnotationPresent(OneToMany.class);
            boolean isEmbedded = f.isAnnotationPresent(Embedded.class);
            if(isSerialVersionUID || isTransient || isOneToMany || isEmbedded){
                continue;
            }
            Object value = null;

            try {
                value = f.get(entity);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

            if(value == null){
                continue;
            }

            if(value instanceof PersistentEntity && ( entity == null || entity.getId() == null)){
                continue;
            }

            boolean isString = f.getType().equals(String.class);

            if(isString){

                if(enableLike){
                    sb.append(" and upper(" + entityAlias + "." + fieldName + ") like upper(:" + fieldName + ") ");
                    value = "%" + value.toString() + "%";
                }else{
                    sb.append(" and " + entityAlias + "." + fieldName + " =:" + fieldName);
                }


            }else{
                sb.append(" and " + entityAlias + "." + fieldName + " =:" + fieldName);
            }

            sb.addParam(fieldName, value);
        }

        return sb;
    }
}