package practice.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    private String url; // 접속할 서버의 url

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception { // 의존관계 주입이 끝나면 호출 -> 초기화
        System.out.println("NetworkClient.afterPropertiesSet()");
        connect();
        call("초기화 메시지");
    }

    @Override
    public void destroy() throws Exception { // 빈이 종료될 때 호출 -> 소멸
        System.out.println("NetworkClient.destroy()");
        disconnect();
    }


}
