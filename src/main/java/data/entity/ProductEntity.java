package data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    // db 에는 한 테이블당 하나의 pk가 필요함
    // 그걸 이제 @Id를 통해 의미를 부여해줌
    @Id
    String productId;
    String productName;
    String productPrice;
    String productStock;
}
