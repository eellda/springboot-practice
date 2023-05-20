package data.repository;

import data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<repository가 사용할 entity, id값의 datatype>
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    // JpaRepository에선 기본적인 기능은 제공해줌
}
