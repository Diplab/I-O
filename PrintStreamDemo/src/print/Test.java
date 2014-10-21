package print;
import java.io.*;

public class Test { 
    public static void main(String[] args) throws IOException { 
        FileOutputStream file = new FileOutputStream(new File("test.txt")); 
        file.write(123); 
        file.close(); 
    } 
} 