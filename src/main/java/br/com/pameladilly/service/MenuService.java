package br.com.pameladilly.service;

import br.com.pameladilly.DTO.MenuDTO;
import br.com.pameladilly.DTO.MenuDTOResponse;
import br.com.pameladilly.DTO.ProductDTO;
import com.google.errorprone.annotations.InlineMe;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import model.Menu;
import model.Product;
import repository.MenuRepository;
import repository.ProductRepository;

import java.util.ArrayList;

@ApplicationScoped
public class MenuService {

    @Inject
    MenuRepository repository;

    @Inject
    ProductRepository productRepository;


    @Inject
    ProductService productService;


    public Menu findById(String idMenu){


        return repository.findByIdOptional(Long.parseLong(idMenu))
                .orElseThrow(() -> new NotFoundException("Menu not found"));

    }

    public Menu save(MenuDTO menuDTO){

        Menu menu = new Menu();

        menuDTO.getProducts().forEach( id -> {
            Product product =
                    productRepository.findByIdOptional(id).orElseThrow( () -> new BadRequestException("Product not found"));

            menu.addProduct( product);
        });

        menu.setName(menuDTO.getName());
        menu.setActive(menuDTO.getActive());
        menu.persist();

        return menu;
    }

    public MenuDTOResponse getMenu(String idMenu){
        Menu menu = findById(idMenu);

        MenuDTOResponse dto = MenuDTOResponse.builder().build();
        dto.setName(menu.getName());
        dto.setProducts(new ArrayList<>());
        menu.getProduct().stream().filter(Product::getActive).forEach(product ->
                 dto.getProducts().add( ProductDTO.builder().href(product.getHref()).position(product.getPosition()).name(product.getName()).build())
        );

        return dto;
    }



}
