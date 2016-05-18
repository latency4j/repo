package latency4jexamples.directapi.helloworld;


import org.latency4j.LatencyMonitor;
import org.latency4j.MonitorFactoryStaticHandle;

public class HelloWorld
{
	public static void main(final String[] args) throws Exception
	{
		LatencyMonitor monitor = MonitorFactoryStaticHandle.getMonitor("HelloWorld");

		for (int i=0;i<10;i++) 
		{
			monitor.taskStarted();
			Thread.sleep(100); // pretend to do something
			System.out.println("Saying Hello at index ("+i+") -;)");			
			monitor.taskCompleted();
		}
	}
}