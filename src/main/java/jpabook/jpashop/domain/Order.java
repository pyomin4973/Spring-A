package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ORDERS") //order by 예약어로 걸려있어서 안되는 DB가 있을 수 있어서
public class Order {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;
    @Column(name="MEMBER_ID")
    private Long memberId;
    private LocalDateTime orderDate; //DB에서는 보통 order_date로 씀

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
