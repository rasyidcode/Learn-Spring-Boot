package com.rasyidcode.springcontexteclipse;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rasyidcode.springcontexteclipse.config.AppConfig;
import com.rasyidcode.springcontexteclipse.services.ProductDeliveryService;

public class App {

	/**
	 * Configuration could be an XML or Annotations Class
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try (var context = new AnnotationConfigApplicationContext(Config.class)) {
//			// get by Type
////			MyBean b1 = context.getBean(MyBean.class);
////			MyBean b2 = context.getBean(MyBean.class);
////			MyBean b3 = context.getBean(MyBean.class);
//
//			// get by Method Name
////			MyBean b1 = context.getBean("myBean", MyBean.class);
////			MyBean b2 = context.getBean("myBean2", MyBean.class);
////			MyBean b3 = context.getBean("myBean", MyBean.class);
//
//			// get by Bean Name
//			MyBean b1 = context.getBean("mybean1", MyBean.class);
//			MyBean b2 = context.getBean("mybean2", MyBean.class);
//			MyBean b3 = context.getBean("mybean2", MyBean.class);
//
//			System.out.println(b1.getText());
//			System.out.println(b2.getText());
//			System.out.println(b3.getText());
//		}

		// using the default bean with @Primary annotation
//		try (var context = new AnnotationConfigApplicationContext(Config.class)) {
//			MyBean b1 = context.getBean(MyBean.class);
//			MyBean b2 = context.getBean(MyBean.class);
//			System.out.println(b1.getText());
//			System.out.println(b2.getText());
//		} catch (BeansException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// using the method name
//		try (var context2 = new AnnotationConfigApplicationContext(Config2.class)) {
//			MyBean b1 = context2.getBean("myBean", MyBean.class);
//			MyBean b2 = context2.getBean("myBean2", MyBean.class);
//			System.out.println(b1.getText());
//			System.out.println(b2.getText());
//		} catch (BeansException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// using the bean name
//		try (var context3 = new AnnotationConfigApplicationContext(Config3.class)) {
//			MyBean b1 = context3.getBean("mybean1", MyBean.class);
//			MyBean b2 = context3.getBean("mybean2", MyBean.class);
//			System.out.println(b1.getText());
//			System.out.println(b2.getText());
//		} catch (BeansException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		AnotherBean anotherBean = new AnotherBean();
//		System.out.println(anotherBean.getMessage());

//		try (var context = new AnnotationConfigApplicationContext(Config4.class)) {
//			AnotherBean b1 = context.getBean(AnotherBean.class);
//			System.out.println(b1.getMessage());
//		} catch (BeansException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			ProductDeliveryService service = context.getBean(ProductDeliveryService.class);
			service.addSomeProducts();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
