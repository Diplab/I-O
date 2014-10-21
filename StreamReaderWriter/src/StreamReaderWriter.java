import java.io.*;

public class StreamReaderWriter {
    public static void main(String[] args) {
        try { 
            FileInputStream fileInputStream = new FileInputStream("test.txt"); 
            // 為FileInputStream加上字元處理功能
            InputStreamReader inputStreamReader =  new InputStreamReader(fileInputStream); 

            FileOutputStream fileOutputStream = new FileOutputStream("backup_" + "test.txt"); 
            // 為FileOutputStream加上字元處理功能
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream); 

            int i = 0; 
            // 以字元方式顯示檔案內容 
            while((i = inputStreamReader.read()) != -1) { 
                System.out.print((char) i); 
                outputStreamWriter.write(i); 
            } 
            System.out.println(); 

            inputStreamReader.close(); 
            outputStreamWriter.close(); 
        } 
        catch(ArrayIndexOutOfBoundsException e) { 
            System.out.println("沒有指定檔案");
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
} 