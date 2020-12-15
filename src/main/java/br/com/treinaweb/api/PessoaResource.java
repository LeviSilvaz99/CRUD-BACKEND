package br.com.treinaweb.api;

import br.com.treinaweb.model.Produto;
import br.com.treinaweb.service.ProdutoService;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.CONFLICT;
import static jakarta.ws.rs.core.Response.*;

@Path("/produtos")
@Produces(APPLICATION_JSON)
public class PessoaResource {


    @Resource
    @Context
    private UriInfo uriInfo;

    @Inject
    private ProdutoService service;


    @GET
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

    @POST
    public Response save(@Valid Produto produto) {
        return created(uriInfo.getAbsolutePathBuilder().path(service.save(produto).getId().toString()).build()).build();
    }
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") @Min(value = 1, message = "O valor do id deve ser no mínimo 1.") Long id, Produto produto) {
        if (!id.equals(produto.getId())) {
            return status(CONFLICT).build();
        }
        service.update(produto);
        return noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") @Min(value = 1, message = "O valor do id deve ser no mínimo 1")  Long id) {
        service.remove(id);
        return noContent().build();
    }
}


    /*TREINAWEB

    //private ProdutoRepository _repositorio = new ProdutoRepository();

    //@Inject
    //private PessoaService service;

    @GET
    //@Produces(APPLICATION_JSON)
    public List<Produto> get() {
        return _repositorio.GetAll();
    }

    @GET
    @Path("{id}")
    //@Produces(APPLICATION_JSON)
    public Produto getById(@PathParam("id") int id) {
        return _repositorio.Get(id);
    }

    @POST
    //@Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
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
    //@Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
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
    //@Produces(APPLICATION_JSON)
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
    }*/
