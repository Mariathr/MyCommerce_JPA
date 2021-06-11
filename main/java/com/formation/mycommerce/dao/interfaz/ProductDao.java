package com.formation.mycommerce.dao.interfaz;

import java.util.List;

public interface ProductDao<ID,T> {
    Long createProducts(T object);

    T findProductsById(ID id);

    List<T> findAllProducts();

    Boolean updateProducts(T object);

    Boolean removeProducts(ID id);
}
