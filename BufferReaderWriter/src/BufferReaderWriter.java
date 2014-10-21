import java.io.*;
import java.util.*;

public class BufferReaderWriter {
	public static void main(String[] args)  throws IOException{
		File file = new File("note.txt");
		Date date = new Date();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		pw.printf("%tF %<tT", date);
		
		pw.close();
		bw.close();
		fw.close();
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = "#";
		while((str= br.readLine()) != null)
			System.out.print(str);
		br.close();
		fr.close();	
	}
}
