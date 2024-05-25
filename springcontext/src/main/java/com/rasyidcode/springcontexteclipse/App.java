package com.rasyidcode.springcontexteclipse;

import com.rasyidcode.springcontexteclipse.beans.AnotherBean;
import com.rasyidcode.springcontexteclipse.config.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
//        var context = new AnnotationConfigApplicationContext(AppConfig.class);
//        MyBean myBean = context.getBean(MyBean.class);
//        MyBean myBean2 = context.getBean(MyBean.class);

//        var context = new AnnotationConfigApplicationContext(AppConfig2.class);
//        MyBean myBean = context.getBean(MyBean.class);
//        MyBean myBean2 = context.getBean(MyBean.class);

//        var context = new AnnotationConfigApplicationContext(AppConfig3.class);
//        MyBean myBean = context.getBean("myBean", MyBean.class);
//        MyBean myBean2 = context.getBean("myBean2", MyBean.class);

//        var context = new AnnotationConfigApplicationContext(AppConfig4.class);
//        MyBean myBean = context.getBean("mybean1", MyBean.class);
//        MyBean myBean2 = context.getBean("mybean2", MyBean.class);

//        System.out.println(myBean.getMessage());
//        System.out.println(myBean2.getMessage());

        try (var context = new AnnotationConfigApplicationContext(Config.class)) {
            AnotherBean anotherBean = context.getBean(AnotherBean.class);
            System.out.println(anotherBean.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
