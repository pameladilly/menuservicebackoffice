package model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Product extends PanacheEntity{

    private String name;
    private Boolean active;
    private String href;
    private Integer position;


//    @Getter
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id")
//    private List<Menu> menuList;

//    public Product() {
//        this.menuList = new ArrayList<>();
//    }

}
