package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ORDERS") //order by 예약어로 걸려있어서 안되는 DB가 있을 수 있어서
public class Order  extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;
//    @Column(name="MEMBER_ID")
//    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //order 저장 시, 같이 저장됨
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    //양방향을 위해 추가된 코드
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) //내 주인은 OrderItem의 order column이다.
    private List<OrderItem> orderItems=new ArrayList<>();
    private LocalDateTime orderDate; //DB에서는 보통 order_date로 씀

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //편의 메소드
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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
