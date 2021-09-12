package com.spring.hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        {
            AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
            PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
            System.out.println("find prototype1");
            PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
            System.out.println("find prototype2");

            System.out.println("prototypeBean1 = " + prototypeBean1);
            System.out.println("prototypeBean2 = " + prototypeBean2);

            Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

            ac.close();
        }
    }

    @Scope("prototype") //default값이라 없어도 된다
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            //출력이 안된다! 왜냐면 만들고 스프링컨테이너에서 조회할때 생성이 되고 관리하지 않아서!
            System.out.println("PrototypeBean.destroy");
        }
    }

}
