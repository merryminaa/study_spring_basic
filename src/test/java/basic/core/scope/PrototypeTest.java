package basic.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void SingletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            PrototypeBean.class);

        PrototypeBean prototype1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototype2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototype1 = " + prototype1);
        System.out.println("prototype2 = " + prototype2);
        assertThat(prototype1).isNotSameAs(prototype2);

        ac.close();
    }


    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() { // 의존관계 주입 후 실행
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void close() { // 빈 종료시 호출
            System.out.println("PrototypeBean.destroy");
        }
    }




}
