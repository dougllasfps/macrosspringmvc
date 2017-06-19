package org.dougllas.mvcp.service;

import org.dougllas.mvcp.generic.PersistentEntityService;
import org.dougllas.mvcp.model.Alimento;
import org.dougllas.mvcp.tools.QueryCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */

@Service
public class AlimentoService extends PersistentEntityService<Alimento> {

    @Transactional(readOnly = true)
    public List<Alimento> filter(Alimento alimento){
        if("".equals(alimento.getDescricao())){
            alimento.setDescricao(null);
        }
        QueryCreator queryCreator = getJpaEntityRepository().generateExampleQuery(alimento, "a", true);
        return getJpaEntityRepository().queryForList(queryCreator);
    }

}