package com.example.demo.data.repository;

import com.example.demo.data.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// JpaRepository<repository가 사용할 entity, id값의 datatype>
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    // JpaRepository에선 기본적인 기능은 제공해줌

    // 주제

    List<ProductEntity> findByProductName(String name);
    List<ProductEntity> queryByProductName(String name);

    boolean existsByProductName(String name);
    long countByProductName(String name);
    void deleteByProductId(String id);
    long removeByProductId(String id);

    List<ProductEntity> findFirst5ByProductName(String name);
    List<ProductEntity> findTop3ByProductName(String name);

    // 정렬과 페이징

    //List<ProductEntity> findByNameContainingOrderByStockAsc(String name);
    //List<ProductEntity> findByNameContainingOrderByStockDesc(String name);

    //List<ProductEntity> findByNameContainingOrderByPriceAscStockDesc(String name);

    // 매개변수를 활용한 정렬
    //List<ProductEntity> findByNameContaining(String name, Sort sort);

    // 페이징 처리
    //List<ProductEntity> findByPriceGreaterThan(String name, Pageable pageable);

    // 조건자

    ProductEntity findByProductIdIs(String id);
    ProductEntity findByProductIdEquals(String id);

    List<ProductEntity> findByProductIdNot(String id);
    List<ProductEntity> findByProductIdIsNot(String id);

    List<ProductEntity> findByProductStockIsNull();
    List<ProductEntity> findByProductStockIsNotNull();

    List<ProductEntity> findTopByProductIdAndProductName(String id, String name);
    List<ProductEntity> findByProductPriceGreaterThan(int price);
    List<ProductEntity> findByProductNameContaining(String name);

    // @Query
    @Query("select p from ProductEntity p where  p.productPrice > 2000")
    List<ProductEntity> findByPriceBasis();

    @Query(value = "select p from ProductEntity p where  p.productPrice > 2000", nativeQuery = true)
    List<ProductEntity> findByPriceBasisNativeQuery();

    @Query("select p from ProductEntity p where  p.productPrice > ?1")
    List<ProductEntity> findByPriceWithParameter(int price);

    @Query("select p from ProductEntity p where  p.productPrice > :price")
    List<ProductEntity> findByPriceWithParameterNaming(int price);

    @Query("select p from ProductEntity p where  p.productPrice > :pri")
    List<ProductEntity> findByPriceWithParameterNaming2(@Param("pri") int price);

    @Query(value = "select p from ProductEntity p where productPrice > :price",
            countQuery = "select count(*) from ProductEntity where price > ?1",
            nativeQuery = true)
    List<ProductEntity> findByPriceWithParameterPaging(int price, Pageable pageable);

}
