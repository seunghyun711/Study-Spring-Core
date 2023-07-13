package practice.core.singleton;

public class SingletonService {

    // 1. static 영역에 객체를 1개만 생성한다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 지정하여 객체 인스턴스가 필요한 경우 이 메서드를 통해서만 조회하도록 한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private으로 지정하여 외부에서 new키워드로 객체 생성하는 것을 막는다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 호출");
    }
}
