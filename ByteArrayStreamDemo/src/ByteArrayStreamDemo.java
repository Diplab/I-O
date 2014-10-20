import java.io.*;
import java.util.*;

public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        try { 
            File file = new File("test.txt"); 
            BufferedInputStream bufferedInputStream = new BufferedInputStream( new FileInputStream(file)); 
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream(); 

            byte[] bytes = new byte[1];             

            // �N�ɮפ��e�g�J�줸�}�C��y
            while(bufferedInputStream.read(bytes) != -1) {
                arrayOutputStream.write(bytes);
            }
            arrayOutputStream.close(); 
            bufferedInputStream.close(); 

            // �H�r���覡��ܦ줸�}�C���e 
            bytes = arrayOutputStream.toByteArray(); 
            for(int i = 0; i < bytes.length; i++) {
                System.out.print((char) bytes[i]);
            }
            System.out.println(); 

            // ���ϥΪ̿�J��m�P�r���ק�줸�}�C���e 
            Scanner scanner = new Scanner(System.in);

            System.out.print("��J�ק��m�G"); 
            int pos = scanner.nextInt();
            System.out.print("��J�ק�r���G"); 
            // �ק�}�C���������r��
            bytes[pos-1] = (byte) scanner.next().charAt(0);

            // �N�줸�}�C���e�s�^�ɮ� 
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes); 
            BufferedOutputStream bufOutputStream = new BufferedOutputStream( new FileOutputStream(file)); 
            byte[] tmp = new byte[1]; 
            while(byteArrayInputStream.read(tmp) != -1) 
                bufOutputStream.write(tmp); 
            byteArrayInputStream.close(); 
            bufOutputStream.flush(); 
            bufOutputStream.close(); 
        } 
        catch(ArrayIndexOutOfBoundsException e) { 
            System.out.println("�Ы��w�ɮצW��");
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
} 