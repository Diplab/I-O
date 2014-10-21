import java.io.*;

public class StreamReaderWriter {
    public static void main(String[] args) {
        try { 
            FileInputStream fileInputStream = new FileInputStream("test.txt"); 
            // ��FileInputStream�[�W�r���B�z�\��
            InputStreamReader inputStreamReader =  new InputStreamReader(fileInputStream); 

            FileOutputStream fileOutputStream = new FileOutputStream("backup_" + "test.txt"); 
            // ��FileOutputStream�[�W�r���B�z�\��
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream); 

            int i = 0; 
            // �H�r���覡����ɮפ��e 
            while((i = inputStreamReader.read()) != -1) { 
                System.out.print((char) i); 
                outputStreamWriter.write(i); 
            } 
            System.out.println(); 

            inputStreamReader.close(); 
            outputStreamWriter.close(); 
        } 
        catch(ArrayIndexOutOfBoundsException e) { 
            System.out.println("�S�����w�ɮ�");
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
} 