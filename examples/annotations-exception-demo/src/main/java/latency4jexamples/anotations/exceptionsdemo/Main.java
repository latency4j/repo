package latency4jexamples.anotations.exceptionsdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(final String[] args)
	{
		ClassPathXmlApplicationContext springContext=null;
		try 
		{
			springContext = 
					new ClassPathXmlApplicationContext("spring-beans.xml");
		
			AnnotatedService demoService = 
					(AnnotatedService) springContext.getBean("annotatedService");
		
			for (int i = 0;i<10;i++)
			{
				try
				{
					demoService.triggerAnException(i);
				} 
				catch (Exception exce) {}
			}
		}
		finally
		{
			if (springContext!=null) 
				springContext.close();
		}		
	}
}