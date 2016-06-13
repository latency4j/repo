package latency4JExamples.directapi.exception;

import org.latency4j.LatencyMonitor;
import org.latency4j.MonitorFactoryStaticHandle;

public class SampleShowingExceptionReporting
{
	public static void main(final String[] args) throws InterruptedException
	{
		LatencyMonitor monitor = MonitorFactoryStaticHandle.getMonitor("categoryWithExceptionReporting");
		
		for (int i=0;i<100;i++)
		{
			monitor.taskStarted();
			try{
				throw new Exception("Test Exception. Loop index = " + i);
			}catch (Exception exce){
				monitor.taskErrored(exce);
			}			
		}	
	}
}
