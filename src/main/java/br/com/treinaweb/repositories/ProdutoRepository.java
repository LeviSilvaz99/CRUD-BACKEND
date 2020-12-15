/*package br.com.treinaweb.repositories;

import br.com.treinaweb.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProdutoRepository {
    private final static HashMap<Integer, Produto> produtos = new HashMap<>();

    public List<Produto> GetAll(){
        return new ArrayList<Produto>(produtos.values());
    }

    public Produto Get(final int id) {
        return produtos.get(id);
    }

    public void Add(final Produto produto) {
        if(produto.getId() == 0 )
            produto.setId(generateId(produtos.size() + 1));
        produtos.put(produto.getId(), produto);
    }

    public void Edit(final Produto produto) {
        produtos.remove(produto.getId());
        produtos.put(produto.getId(), produto);
    }

    public void Delete(final int id) {
        produtos.remove(id);
    }

    private int generateId(final int possible)
    {
        if(produtos.containsKey(possible))
            return generateId(possible + 1);
        return possible;
    }
}*/