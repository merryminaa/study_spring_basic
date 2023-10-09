package basic.core.singleton;

import static org.junit.jupiter.api.Assertions.*;

import basic.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //threadA: A 사용자가 1000원 주문
        int userA = statefulService1.order("userA", 10000);

        //threadB: B 사용자가 2000원 주문
        int userB = statefulService2.order("userB", 20000);

        //threadA: 사용자A의 주문금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userA);

        Assertions.assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig  {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}