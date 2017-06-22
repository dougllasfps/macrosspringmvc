package org.dougllas.mvcp.repository;

import org.dougllas.mvcp.model.Refeicao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Criado por dougllas.sousa em 22/06/2017.
 */

@Repository
public interface RefeicaoRepository extends CrudRepository<Refeicao, Integer> {

}