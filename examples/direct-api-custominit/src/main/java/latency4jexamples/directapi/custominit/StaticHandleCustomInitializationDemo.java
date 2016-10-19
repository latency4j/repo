
package latency4jexamples.directapi.custominit;

import java.io.IOException;
import java.io.InputStream;

import org.latency4j.LatencyMonitor;
import org.latency4j.MonitorFactoryStaticHandle;
import org.latency4j.util.ClasspathResourceUtils;

public class StaticHandleCustomInitializationDemo
{
	public static void main(final String[] args) throws InterruptedException, IOException
	{
		InputStream configurationStream = 
			ClasspathResourceUtils.openStreamToResource(
					"CLASSPATH:/custom-cfg.xml",
					StaticHandleCustomInitializationDemo.class);
		
		MonitorFactoryStaticHandle.initializeFrom(configurationStream);
		
		LatencyMonitor monitor = 
			MonitorFactoryStaticHandle.getMonitor("SampleTask");
	
		for (int i=0;i<10;i++) 
		{		
			monitor.taskStarted();
			Thread.sleep(100); // pretend to do something
			System.out.println("Performing Task ("+i+")");
			monitor.taskCompleted();
		}
	}
}
