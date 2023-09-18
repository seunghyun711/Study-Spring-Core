package practice.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.core.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController { // 로거가 작동하는지 확인하는 테스트용 컨트롤러
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) { // HttpServletRequest를 통해 요청 URL(http://localhost:8080/log-demo)을 받는다.
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL); // requestURL 값을 myLogger에 저장

        myLogger.log("controller test"); // 로그를 남긴다.
        logDemoService.logic("testId");
        return "OK";
    }
}
