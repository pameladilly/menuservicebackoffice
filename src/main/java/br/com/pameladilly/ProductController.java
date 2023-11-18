package br.com.pameladilly;


import br.com.pameladilly.DTO.ProductDTO;
import br.com.pameladilly.service.ProductService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Product;
import org.jboss.resteasy.util.NoContent;
import repository.ProductRepository;

@Path("/api/product")
@Transactional
public class ProductController {

    @Inject
    ProductRepository repository;

    @Inject
    ProductService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Product product) {


        return Response.ok(service.save(product)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") String productId) {

        if (service.delete(Long.parseLong(productId)))
            return Response.ok().build();
        else
            return Response.noContent().build();

    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") String productId){

        try {
            return Response.ok(service.findById(Long.parseLong(productId))).build();
        }catch(Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }


}
