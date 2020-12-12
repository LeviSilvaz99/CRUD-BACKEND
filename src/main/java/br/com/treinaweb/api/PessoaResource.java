package br.com.treinaweb.api;

import br.com.treinaweb.model.Produto;
import br.com.treinaweb.repositories.ProdutoRepository;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/produtos")
public class PessoaResource {
    private ProdutoRepository _repositorio = new ProdutoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> get() {
        return _repositorio.GetAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto getById(@PathParam("id") int id) {
        return _repositorio.Get(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Produto produto)
    {
        try{
            _repositorio.Add(produto);
            return Response.status(Response.Status.CREATED).entity(produto).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, Produto produto)
    {
        Produto p = _repositorio.Get(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            produto.setId(id);
            _repositorio.Edit(produto);
            return Response.status(Response.Status.OK).entity(produto).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id)
    {
        Produto p = _repositorio.Get(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            _repositorio.Delete(id);
            return Response.status(Response.Status.OK).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }
}

