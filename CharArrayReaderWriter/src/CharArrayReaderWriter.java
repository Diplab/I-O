import java.io.*;
import java.util.*;

public class CharArrayReaderWriter {
    public static void main(String[] args) {
        try { 
            File file = new File("test.txt"); 
            BufferedReader bufInputReader =  new BufferedReader(  new FileReader(file)); 

            // �N�ɮ�Ū�J�r���}�C 
            CharArrayWriter charArrayWriter =  new CharArrayWriter(); 
            char[] array = new char[1]; 
            while(bufInputReader.read(array) != -1) {
                charArrayWriter.write(array); 
            }

            charArrayWriter.close(); 
            bufInputReader.close(); 

            // ��ܦr���}�C���e 
            array = charArrayWriter.toCharArray(); 
            for(int i = 0; i < array.length; i++) 
                System.out.print(array[i] + " "); 
            System.out.println(); 

            // ���ϥΪ̿�J��m�P�r���ק�r���}�C���e 
            Scanner scanner = new Scanner(System.in);

            System.out.print("��J�ק��m�G"); 
            int pos = scanner.nextInt(); 
            System.out.print("��J�ק�r���G"); 
            char ch = scanner.next().charAt(0); 
            array[pos-1] = ch; 

            // �N�r���}�C���e�s�^�ɮ� 
            CharArrayReader charArrayReader =  new CharArrayReader(array); 
            BufferedWriter bufWriter = new BufferedWriter(  new FileWriter(file)); 
            char[] tmp = new char[1]; 
            while(charArrayReader.read(tmp) != -1) {
                bufWriter.write(tmp); 
            }

            charArrayReader.close();
            bufWriter.flush(); 
            bufWriter.close(); 
        } 
        catch(ArrayIndexOutOfBoundsException e) { 
            System.out.println("�S�����w�ɮ�");
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
}