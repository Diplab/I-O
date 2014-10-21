package print;
import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream(new File("test2.txt")));

        printStream.println(123);
        printStream.close();
    }
} 