package br.com.treinaweb.api;

import br.com.treinaweb.model.Produto;
import br.com.treinaweb.service.ProdutoService;



import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.*;
import static javax.ws.rs.core.Response.Status.CONFLICT;


@Path("/produtos")
@Produces(APPLICATION_JSON)
public class ProdutoResource {




    //Usando a API Java para Serviços da Web RESTful (JAX-RS),
    // é possível usar o objeto UriInfo para acessar cabeçalhos de pedido. O objeto UriInfo fornece métodos para permitir localizar ou construir informações de URI de um pedido.
    //CDI
    @Context
    private UriInfo uriInfo;


    @Inject
    private ProdutoService service;


    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    //@Produces(MediaType.APPLICATION_JSON)
    public Produto listProdutoById(@PathParam("id") long id) {
        return service.findById(id);
    }

    @POST
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid Produto produto) {
        return created(uriInfo.getAbsolutePathBuilder().path(service.save(produto).getId().toString()).build()).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Produto produto) {
        if (!id.equals(produto.getId())) {
            return status(CONFLICT).build();
        }
        service.update(produto);
        return noContent().build();
    }


    @DELETE
    @Path("/{id}")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id) {
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
