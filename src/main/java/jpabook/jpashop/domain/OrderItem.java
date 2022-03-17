package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
@TableGenerator(
        name = "ORDER_ITEM_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "ORDER_ITEM_SEQ", allocationSize = 1
)
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_SEQ_GENERATOR")
    private Long id;

    @ManyToOne
    private Order order_id;
    @ManyToOne
    private Item item_id;

    private int orderPrice;
    private int count;
}
