package practice.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototypeTest1 {

    @Test
    void singletonClientUsePrototype(){ // 싱글톤 빈에서 프로토타입 빈 사용 테스트
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);
    }

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    // JSR-330 Provider를 사용하여 싱글톤 빈과 프로토타입 빈을 함께 사용
    static class ClientBean{
        @Autowired
        private Provider<PrototypeBean> provider;

        public int logic(){
            PrototypeBean prototypeBean = provider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    // ObjectProvider를 사용하여 싱글톤 빈과 프로토타입 빈을 함께 사용
//    static class ClientBean{
//        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeBeanProvider;
//
//        public int logic(){
//            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
//            prototypeBean.addCount();
//            int count = prototypeBean.getCount();
//            return count;
//        }
//    }

    // 싱글톤 빈이 프로토타입 빈을 사용할 때 마다 스프링 컨테이너에 요청하는 방법
//    static class ClientBean{
//        @Autowired
//        private ApplicationContext ac;
//
//        public int logic(){
//            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
//            prototypeBean.addCount();
//            int count = prototypeBean.getCount();
//            return count;
//        }
//    }

//    @Scope("singleton") // 싱글톤 빈 스코프
//    static class ClientBean {
//        private final PrototypeBean prototypeBean;
//
//        @Autowired
//        public ClientBean(PrototypeBean prototypeBean) {// PrototypeBean 의존관계 주입
//            this.prototypeBean = prototypeBean;
//        }
//
//        public int logic(){
//            prototypeBean.addCount();
//            int count = prototypeBean.count;
//            return count;
//        }
//    }

    @Scope("prototype") // 프로토타입 빈 스코프
    static class PrototypeBean{
        private int count = 0;

        public void addCount() {
            count += 1;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}
