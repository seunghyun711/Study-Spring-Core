package practice.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import practice.core.member.Member;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        // 1. @Autoeired(required = false)
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("noBean1 = " + member);
        }

        // 2. null 호출
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("noBean2 = " + member);
        }

        // 3. Optional.empty 호출
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("noBean3 = " + member);
        }
    }
}
