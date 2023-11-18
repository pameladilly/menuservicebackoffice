package br.com.pameladilly;

import br.com.pameladilly.DTO.MenuDTO;
import br.com.pameladilly.DTO.MenuDTOResponse;
import br.com.pameladilly.service.MenuService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Menu;
import model.Product;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import repository.MenuRepository;
import repository.ProductRepository;

import java.util.Optional;

@Path("/api")
@Transactional
public class MenuController {


    @Inject
    MenuRepository repository;

    @Inject
    ProductRepository productRepository;

    @Inject
    MenuService service;

    @POST
    @Path("/menu")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Menu save(MenuDTO menuDTO) {


        return service.save(menuDTO);
    }

    @GET
    @Path("/menu/{idMenu}")
    @Produces(MediaType.APPLICATION_JSON)
    public Menu get(@PathParam("idMenu") String idMenu){

        return service.findById(idMenu);

    }

    @GET
    @Path("/getmenu/{idMenu}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenu(@PathParam("idMenu") String idMenu){

        return Response.ok(service.getMenu(idMenu)).build() ;

    }
}
