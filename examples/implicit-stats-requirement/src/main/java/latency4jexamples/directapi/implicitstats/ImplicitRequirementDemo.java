package latency4jexamples.directapi.implicitstats;

import org.latency4j.LatencyMonitor;
import org.latency4j.MonitorFactoryStaticHandle;

public class ImplicitRequirementDemo
{
	public static void main(final String[] args) throws InterruptedException
	{
		//get a monitor for an unconfigured/undeclared category
		LatencyMonitor monitor = 
			MonitorFactoryStaticHandle.getMonitor("MonitoredOperation");
		
		for (int i=0;i<55;i++)
		{
			monitor.taskStarted();
			
			if (i>=50)
				Thread.sleep(i * 10);
			else Thread.sleep(1);
			
			monitor.taskCompleted();
		}
	}
}