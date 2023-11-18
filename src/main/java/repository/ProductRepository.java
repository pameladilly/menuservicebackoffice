package repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Product;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}
