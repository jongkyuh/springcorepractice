package hello.corepractice.singleton;

public class SingletonService {

    // 클래스 레벨로 하나만 만들게 하고 절대 다른곳에서 못만들게 한다.
    // getInstance() 메소드를 통해서 생선된 객체 오직 1개만 가져올 수 있다.

    //  SingletonService로 static 가져온다.
    private static final SingletonService instance = new SingletonService();

    private SingletonService(){
        // 생성자를 private로 만들어서 다른곳에서 객체를 만들지 못하도록 한다.
    }

    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
