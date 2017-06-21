package org.dougllas.mvcp.repository;

import org.dougllas.mvcp.model.Alimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Criado por dougllas.sousa em 21/06/2017.
 */

@Repository
public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {

}