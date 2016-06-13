package latency4jexamples.directapi.custominit;

import org.latency4j.LatencyMonitor;
import org.latency4j.processing.AsynchronousLatencyMonitorFactory;

public class FactoryCustomInitializationDemo
{
	public static void main(final String[] args) throws InterruptedException
	{
		//create a monitor factory with the custom config 
		AsynchronousLatencyMonitorFactory monitorFactory = 
			new AsynchronousLatencyMonitorFactory();
		monitorFactory.setConfigurationPath("CLASSPATH:/custom-cfg.xml");
		monitorFactory.init();
				
		LatencyMonitor monitor = 
			monitorFactory.getMonitor("SampleTask");
		for (int i=0;i<10;i++) 
		{
			monitor.taskStarted();
			Thread.sleep(100); // pretend to do something
			System.out.println("Performing Task ("+i+")");
			monitor.taskCompleted();
		}
	}
}
