package com.formation.mycommerce.dao.interfaz;

import java.util.List;

public interface CategoryDao <ID,T>{
    Long createCategory(T object);

    T findCategoryById(ID id);

    List<T> findAllCategory();

    Boolean updateCategory(T object);

    Boolean removeCategory(ID id);
}
