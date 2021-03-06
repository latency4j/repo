package latency4jexamples.aop.helloworld;

import org.latency4j.MonitoredByLatency4J;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldService 
{
	private static Logger logger = 
		LoggerFactory.getLogger(HelloWorldService.class);
	
	@MonitoredByLatency4J("HelloWorld")
	public void sayHello()
	{
		try{
			Thread.sleep(100); //artificial delay
			logger.info("Aloha -;)");
		} catch (Throwable t)
		{logger.error("error occured",t);}
	}
}