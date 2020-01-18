import java.io.*;

public class Exec
{
	final static String CMD = System.getProperty("user.dir") + File.separator + "main Hello";

	public static void main(String[] args) throws Throwable
	{
		System.out.println(CMD);
		Runtime r = Runtime.getRuntime();
		Process p = r.exec(CMD);
		InputStream is = p.getInputStream();
		int i = p.waitFor();
		if(i != 0)
		{
			System.err.println("Expected 0");
			System.exit(1);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		StringBuilder builder = new StringBuilder();
		
		while((line = br.readLine()) != null)
		{
			builder.append(line);
		}

		int returnCode = p.exitValue();

		if(returnCode != 0)
		{
			System.err.println("Expected 0");
			System.exit(2);
		}
		System.out.println(builder.toString());
	}
}