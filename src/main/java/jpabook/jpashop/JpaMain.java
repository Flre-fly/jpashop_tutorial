package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //코드 추가
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //멤버생성
            Member member = new Member();
            member.setName("홍길동");
            member.setCity("city1");
            member.setStreet("strres1");
            member.setZipcode("zipcode1");
            em.persist(member);
            //item생성
            Item item = new Item();
            item.setName("item1");
            item.setPrice(10000);
            item.setStockQuantity(20);
            em.persist(item);
            //order생성
            Order order = new Order();
            order.setOrderDate(LocalDateTime.now());
            order.setStatus(OrderStatus.ORDER);
            order.setMember(member);
            em.persist(order);
            //order_item생성
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setOrderPrice(10000);
            orderItem.setItem(item);
            em.persist(orderItem);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        em.close();
        emf.close();

    }
}
