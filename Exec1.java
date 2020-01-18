import java.io.*;
import java.util.Scanner;

public class Exec1
{
	final static String CMD = System.getProperty("user.dir") + File.separator + "main1";

	public static void main(String[] args) throws Throwable
	{
		System.out.println(CMD);
		Runtime r = Runtime.getRuntime();
		Process p = r.exec(CMD);
		WriterRunnable wr = new WriterRunnable(p);
		ReaderRunnable rr = new ReaderRunnable(p);
		Thread t1 = new Thread(wr);
		Thread t2 = new Thread(rr);
		t1.start();
		t2.start();

		int i = p.waitFor();
		
	}
	static class WriterRunnable implements Runnable
	{
		private Process p;

		public WriterRunnable(Process p)
		{
			this.p = p;
		}

		public void run()
		{
			OutputStream os = p.getOutputStream();
			InputStream is = p.getInputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			boolean isRunning = true;
			Scanner sc = new Scanner(System.in);
			
			while(isRunning)
			{
				System.out.println("Please enter in a character to send to the C program.");
				String s = sc.next();

				if(s != null && s.trim().length() > 0)
				{
					char c = s.charAt(0);
					try
					{
						bw.write(c);
						bw.flush();
					}
					catch(IOException io)
					{

					}
				}
			}
		}
	}

	static class ReaderRunnable implements Runnable
	{
		private Process p;

		public ReaderRunnable(Process p)
		{
			this.p = p;
		}

		public void run()
		{
			try
			{
				InputStream is = p.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String line = null;
				
				while((line = br.readLine()) != null)
				{
					System.out.println("Received line: " + line + " from C.");
					if(line.equals("MAGIC"))
					{
						System.exit(0);
					}
				}
			}
			catch(IOException io)
			{
				io.printStackTrace();
			}
		}
	}
}
