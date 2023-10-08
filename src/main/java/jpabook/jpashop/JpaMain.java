package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hello");

        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();
        tx.begin();
        //code
        try{
//            //Member findMem= em.find(Member.class,2L); 쿼리 생성
//            //Member findMem2 = em.find(Member.class,2L); 쿼리 생성X(1차 캐시에서 가져옴)
//            Member member=new Member();
//            member.setId(2L);
//            member.setName("helloA");
//
//            em.persist(member);
//
//            em.find(Member.class,2L);
            Order order=new Order();
            order.addOrderItem(new OrderItem());

            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
