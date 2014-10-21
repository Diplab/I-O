import java.io.*;
import java.util.zip.*;

public class Gzip {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(
				new FileReader("test.txt"));
		//OutputStream 包裝成 GZIPOutputStream 
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(
						new FileOutputStream("test.txt.gz")));
		System.out.println("Writing file");
		
		int c;
		while((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
		System.out.println("Reading file");
		//InputStream 包裝成 GZIPInputStream
		BufferedReader in2 = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(
						new FileInputStream("test.txt.gz"))));
		String s;
		while((s = in2.readLine()) != null)
			System.out.println(s);	
	}
}
