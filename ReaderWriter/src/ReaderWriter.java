import java.io.File;
import java.io.*;

public class ReaderWriter {

	public static void main(String[] args) throws IOException{
		File file = new File("note.txt");
		String note = "���ѬO�P���G";
		FileWriter fw = new FileWriter(file);
		fw.write(note);
		fw.close();
		
		FileReader fr = new FileReader(file);
		int i = 0;
		while((i = fr.read()) != -1)//Ū�J��-1�N��Ū��
			System.out.print((char)i);
		fr.close();	
	}
}
