package org.dougllas.mvcp.generic;

import org.dougllas.mvcp.model.PersistentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */

@Service
public  abstract class PersistentEntityService<T  extends PersistentEntity> implements Serializable {

    @Autowired
    private JpaEntityRepository jpaEntityRepository;

    private Class<T> persistentClass;

    public PersistentEntityService() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Transactional
    public void save(T entity){
        jpaEntityRepository.save(entity);
    }

    @Transactional
    public void delete(T entity){
        jpaEntityRepository.delete(entity);
    }

    @Transactional(readOnly = true)
    public T findById(Serializable id){
        return jpaEntityRepository.findById(persistentClass, id);
    }

    @Transactional(readOnly = true)
    public List<T> findAll(){
        return jpaEntityRepository.findAll(persistentClass);
    }

    public JpaEntityRepository getJpaEntityRepository() {
        return jpaEntityRepository;
    }
}
