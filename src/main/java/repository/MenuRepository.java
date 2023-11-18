package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Menu;

@ApplicationScoped
public class MenuRepository implements PanacheRepository<Menu> {
}
