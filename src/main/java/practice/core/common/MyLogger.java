package practice.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
// 프록시 설정
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // request 스코프 - HTTP 요청 당 하나씩 빈이 생성되며 HTTP 요청이 끝나는 시점에 소멸된다.
public class MyLogger { // 로그를 출력하기 위한 클래스
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) { // 해당 빈이 생성되는 시점에는 알 수 없기 때문에 setter로 외부에서 입력받음
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init(){ // 초기화 메서드
        uuid = UUID.randomUUID().toString(); // uuid를 생성하여 저장한다.
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close(){ // 소멸 메서드
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}
