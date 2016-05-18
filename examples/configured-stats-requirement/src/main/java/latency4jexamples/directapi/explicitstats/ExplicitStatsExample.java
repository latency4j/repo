package latency4jexamples.directapi.explicitstats;

import org.latency4j.LatencyMonitor;
import org.latency4j.MonitorFactoryStaticHandle;

public class ExplicitStatsExample
{
	private static final String EXAMPLE_CATEGORY = "statsExampleTask";
	private static final int NUMBER_OF_ITERATIONS = 10;
	private static final long WAIT_INTERVAL = 100;
	
	public static void main(final String[] args) throws InterruptedException
	{			
		//get a monitor from the factory
		LatencyMonitor monitor = MonitorFactoryStaticHandle.getMonitor(EXAMPLE_CATEGORY);
						
		for (int i=0;i<=NUMBER_OF_ITERATIONS;i++)
		{
			monitor.taskStarted();
			Thread.sleep(i * WAIT_INTERVAL);
			monitor.taskCompleted();
		}		
	}
}