package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@TableGenerator(
        name = "ORDER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "ORDER_SEQ", allocationSize = 1
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    private Long id;

    @ManyToOne//이부분 맞나?
    private Member member;

    private LocalDateTime orderDate;
    private OrderStatus status;
}
