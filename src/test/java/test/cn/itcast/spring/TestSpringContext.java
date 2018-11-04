/**
 * 
 */
package test.cn.itcast.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringContext {
	
	private ApplicationContext act;
	
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
	}
	
	@Test
	public void testSpring(){
		String[] names = act.getBeanDefinitionNames();
		
		for (String string : names) {
			System.out.println(string);
		}
		
	}

}
