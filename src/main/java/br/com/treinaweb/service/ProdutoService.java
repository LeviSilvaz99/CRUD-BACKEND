package br.com.treinaweb.service;

import br.com.treinaweb.model.Produto;
import br.com.treinaweb.repository.ProdutoRepository;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;
import static io.vavr.collection.List.ofAll;

public class ProdutoService {

    @Inject
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return (List<Produto>) ofAll(repository.findAll());
    }

    @Transactional
    public Produto save(Produto produto) {
        return repository.save(produto);
    }
    @Transactional
    public void remove(Long id) {
        repository.remove(findBy(id));
    }
    @Transactional
    public Produto update(Produto produto) {
        return repository.save(produto);
    }

    public Produto findBy(Long produtoId) {
        return repository.findBy(produtoId);
    }
}
