package br.com.treinaweb.service;

import br.com.treinaweb.model.Produto;
import br.com.treinaweb.repository.ProdutoRepository;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import static io.vavr.collection.List.ofAll;

public class ProdutoService {

    @Inject
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return ofAll(repository.findAll()).toJavaList();
    }

    public Produto findById(Long produtoId) {
        return repository.findBy(produtoId);
    }

    //Transactiona demarca transações aniadas para outras camadas.
    @Transactional
    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    @Transactional
    public Produto update(Produto produto) {
        return repository.save(produto);
    }

    @Transactional
    public void remove(Long id) {
        repository.remove(findById(id));
    }




}
