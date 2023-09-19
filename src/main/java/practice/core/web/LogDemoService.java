package practice.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import practice.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService { // 서비스 계층
    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
