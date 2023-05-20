package data.dao.impl;

import data.dao.ProductDAO;
import data.entity.ProductEntity;
import data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // DI라는 의존성 주입이라는 개념이 필요
    // 기본적인 Spring Boot 체제는 singleton을 기반으로 진행이 됨
    // 때문에 Repository가 필요할 때마다 객체를 생성하는 것이 아닌
    // bean으로 하나 띄워놓고 객체를 여러곳에서 같이 혼용으로 사용하게 되는 방식

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
