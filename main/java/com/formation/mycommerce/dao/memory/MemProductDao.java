package com.formation.mycommerce.dao.memory;
import com.formation.mycommerce.dao.exception.UnknownProductException;
import com.formation.mycommerce.dao.interfaz.ProductDao;
import com.formation.mycommerce.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemProductDao implements ProductDao<Long, Product> {
    private static List<Product> productList = new ArrayList();
    private static Long idSequence = 1L;

    public MemProductDao() {
    }

    @Override
    public Long createProducts(Product product) {
        Long var1 = idSequence;
        idSequence = idSequence + 1L;
        product.setId(var1);
        productList.add(product);
        return var1;
    }

    @Override
    public Product findProductsById(Long aLong) {
        int index = getProductIndexById(aLong);
        if (index > -1) {
            Product product = (Product) productList.get(index);
            return product;
        } else {
            throw new UnknownProductException(aLong);
        }
    }

    @Override
    public List<Product> findAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    @Override
    public Boolean updateProducts(Product product) {
        int index = getProductIndexById(product.getId());
        if (index > -1) {
            productList.set(index, product);
        } else {
            // throw new UnknownProductException(product.getId());
        }
        return true;
    }

    @Override
    public Boolean removeProducts(Long aLong) {
        int index = getProductIndexById(aLong);
        if (index > -1) {
            productList.remove(index);
        } else {
            throw new UnknownProductException(aLong);
        }
        return true;
    }

    public void removeProduct(Product product) {
        removeProducts(product.getId());
    }
    private static int getProductIndexById(Long id) {
        for(int i = 0; i < productList.size(); ++i) {
            Product product = (Product) productList.get(i);
            if (product.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
