import java.util.Scanner;
public class HeartBeatTest
{
	public static void main(String[] args) throws Throwable
	{
		HeartBeat r = new HeartBeat();
		Thread t = new Thread(r);
		t.start();
		
		Scanner sc = new Scanner(System.in);
		do
		{
			String s;
			System.out.println("<<<Press any key to stop the heartbeat");
			s = sc.next();
			r.stop();
			System.exit(0);
		}
		while(true);

		

	}
}