package jpabook.jpashop.domain;


import javax.persistence.*;

@Entity
@TableGenerator(
        name = "ITEM_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "ITEM_SEQ", allocationSize = 1
)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ_GENERATOR")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
