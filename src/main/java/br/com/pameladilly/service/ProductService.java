package br.com.pameladilly.service;

import br.com.pameladilly.DTO.ProductDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import model.Product;
import repository.ProductRepository;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository repository;

    public Product productDTOToProduct(ProductDTO productDTO){

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setHref(productDTO.getHref());
        product.setPosition(productDTO.getPosition());
        //product.setActive(productDTO.ge);

        return product;
    }

    public Product save(Product product){

        //Product product = productDTOToProduct(productDTO);
        product.persist();

        return product;

    }

    public Boolean delete(Long productId){

        return repository.deleteById(productId);

    }

    public Product findById(Long productId){
        return repository.findByIdOptional(productId).orElseThrow( () -> new NotFoundException("Not found"));
    }
}
