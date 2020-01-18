import java.awt.Toolkit;

public class HeartBeat implements Runnable
{
	private boolean isRunning;

	public void run()
	{
		isRunning = true;
		while(isRunning)
		{
		    Toolkit.getDefaultToolkit().beep();     
			try
			{
				Thread.currentThread().sleep(1 * 1000);
			}
			catch(InterruptedException ie)
			{
				System.err.println("Received an unexpected exception: " + ie.getMessage());
			}
		}
		System.out.println("Stopped.");
	}

	public void stop()
	{
		isRunning = false;
		System.out.println("Stopping...");
	}
}