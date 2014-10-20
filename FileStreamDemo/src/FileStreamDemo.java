import java.io.*; 
 
public class FileStreamDemo {
    public static void main(String[] args) {
        try { 
            byte[] buffer = new byte[1024]; 

            // �ӷ��ɮ�
            FileInputStream fileInputStream = new FileInputStream(new File("FileDemo.java")); 
            // �ت��ɮ�
            FileOutputStream fileOutputStream = new FileOutputStream(new File("FileDemo.txt")); 

            // available()�i���o��Ū������ƪ���
            System.out.println("�ƻs�ɮסG" + fileInputStream.available() + "�줸��"); 
            
            while(true) { 
                if(fileInputStream.available() < 1024) { 
                    // �Ѿl����Ƥ�1024�줸�դ�
                    // �@�줸�@�줸Ū�X�A�g�J�ت��ɮ�
                    int remain = -1; 
                    while((remain = fileInputStream.read())
                                           != -1) {
                        fileOutputStream.write(remain); 
                    }
                    break; 
                } 
                else { 
                    // �q�ӷ��ɮ�Ū����Ʀܽw�İ� 
                    fileInputStream.read(buffer); 
                    // �N�}�C��Ƽg�J�ت��ɮ� 
                    fileOutputStream.write(buffer); 
                } 
            } 

            // ������y 
            fileInputStream.close(); 
            fileOutputStream.close(); 

            System.out.println("�ƻs����"); 
        } 
        catch(ArrayIndexOutOfBoundsException e) { 
            System.out.println("using: java FileStreamDemo src des"); 
            e.printStackTrace(); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
} 
