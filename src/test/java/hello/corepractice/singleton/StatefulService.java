package hello.corepractice.singleton;

public class StatefulService {

  //  private int price;      // 상태를 유지하는 필드, 10000에서 20000으로 다시 변경된다. 공유필드이기때문에 그래서 공유필드 자체를 삭제해준다.

    public int order(String name,int price){   // 공유필드 문제를 해결하면서 주문금액을 가져오기위해서는 리턴자체를 주문금액으로 가져온다.
        System.out.println("name = " + name + "price = " + price);
      //  this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
