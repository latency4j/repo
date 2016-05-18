package latency4jexamples.anotations.exceptionsdemo;

import org.latency4j.MonitoredByLatency4J;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotatedService 
{
	private static Logger logger = 
		LoggerFactory.getLogger(AnnotatedService.class);
	
	@MonitoredByLatency4J("annotatedOperation")
	public void triggerAnException(final int i)
	{ 
		sleep(i);				
		throw new RuntimeException("no error occured!");
	}
	
	private void sleep(final int i)
	{
		try{
			Thread.sleep(100l + i);
		} catch (Throwable t) {
			logger.error("sleep interrupted", t);
		}
	}
}