package br.com.treinaweb.repository;

import br.com.treinaweb.model.Produto;
import org.apache.deltaspike.data.api.FullEntityRepository;

import org.apache.deltaspike.data.api.Repository;




@Repository

public interface ProdutoRepository extends FullEntityRepository<Produto, Long> {
    Produto findById(long id);
}
