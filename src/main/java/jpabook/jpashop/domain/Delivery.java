package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery  extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address address;
    private DeliverStatus status;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

}
