package latency4JExamples.directapi.exception;

import org.latency4j.LatencyMonitor;
import org.latency4j.MonitorFactoryStaticHandle;

public class SampleShowingExceptionIgnore
{
	public static void main(final String[] args)
	{
		LatencyMonitor monitor = MonitorFactoryStaticHandle.getMonitor("categoryWithoutExceptionReporting");
		
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
