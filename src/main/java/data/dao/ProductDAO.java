package data.dao;

import data.entity.ProductEntity;

public interface ProductDAO {
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId);
}
