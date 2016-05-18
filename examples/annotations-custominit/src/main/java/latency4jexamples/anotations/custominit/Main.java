package latency4jexamples.anotations.custominit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(final String[] args) throws InterruptedException
	{
		ClassPathXmlApplicationContext springContext=null;
		try 
		{
			springContext = 
					new ClassPathXmlApplicationContext("spring-beans.xml");

			HelloWorldService demoService = 
					(HelloWorldService) springContext.getBean("helloWorldService");
		
			for (int i=0;i<10;i++)
				demoService.sayHello();
		} 
		finally 
		{
			if (springContext!=null) 
				springContext.close();
		}	
	}
}
