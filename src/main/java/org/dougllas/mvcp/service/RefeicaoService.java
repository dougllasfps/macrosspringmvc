package org.dougllas.mvcp.service;

import org.dougllas.mvcp.repository.RefeicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Criado por dougllas.sousa em 22/06/2017.
 */

@Service
public class RefeicaoService implements Serializable {

    @Autowired
    private RefeicaoRepository refeicaoRepository;
}