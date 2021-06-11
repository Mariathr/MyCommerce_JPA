package com.formation.mycommerce.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Category  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

   // @OneToMany(targetEntity=Products.class, mappedBy="category")
   // private List<Products> productsList = new ArrayList();

    public Category() {
    }

    public Category(Long id) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public List<Products> getProductsList() {
    //    return productsList;
   // }

   // public void setProductsList(List<Products> productsList) {
   //     this.productsList = productsList;
   // }
}
