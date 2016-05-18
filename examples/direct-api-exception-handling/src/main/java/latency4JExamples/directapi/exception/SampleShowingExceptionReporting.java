/*
	Copyright (c) 2010 Obix Labs Limited
	Redistribution and use in source and binary forms, 
	with or without modification, are permitted provided 
	that the following conditions are met:

	*	Redistribution of source code must retain the above 
		copyright notice, this list of conditions and the 
		following disclaimer.
	
	*	Redistribution in binary form must reproduce the 
		above copyright notice, this list of conditions 
		and the following disclaimer in the documentation 
		and/or other materials provided with the distribution.
		
	*	Neither the name of Obix Labs Limited nor the
		names of its contributors may be used to endorse or 
		promote products derived from this software without 
		specific prior written permission.

	
	THIS SOFTWARE IS PROVIDED "AS IS," WITHOUT A WARRANTY OF 
	ANY KIND. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS 
	AND WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, 
	FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, 
	ARE HEREBY EXCLUDED. OBIX LABS LIMITED ("Obix Labs") AND ITS 
	LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE 
	AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR 
	ITS DERIVATIVES. IN NO EVENT WILL Obix Labs OR ITS LICENSORS BE 
	LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT, 
	INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE 
	DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF 
	LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS 
	SOFTWARE, EVEN IF Obix Labs HAS BEEN ADVISED OF THE POSSIBILITY OF 
	SUCH DAMAGES.
 */
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