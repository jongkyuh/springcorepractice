package hello.corepractice.order;

import hello.corepractice.member.Member;

public interface OrderService {

    Order createOrder(Long memberId,String itemName,int itemPrice);
}
