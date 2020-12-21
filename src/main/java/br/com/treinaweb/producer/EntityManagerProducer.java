package br.com.treinaweb.producer;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class EntityManagerProducer {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    //Entity manager vai inserir, atualizar e deletar uma entidade
    public EntityManager producerEntityManager() {
        return entityManager;
    }



}