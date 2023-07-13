package practice.core.singleton;

public class StatefulService {
    private int price; // 상태가 유지되는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 문제가 발생하는 코드
    }

    public int getPrice(){
        return price;
    }
}
