import java.io.*;
import java.util.*;

public class RandomAccess {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Justin", 90), 
                new Student("Lisa", 95), 
                new Student("Tom", 88), 
                new Student("Alice", 84)}; 

        try {
            File file = new File("test.txt");
            // �إ�RandomAccessFile��ҨåHŪ�g�Ҧ��}���ɮ�
            RandomAccessFile randomAccessFile =  new RandomAccessFile(file, "rw"); 

            for(int i = 0; i < students.length; i++) { 
              // �ϥι�����write��k�g�J���
              randomAccessFile.writeChars(students[i].getName());
              randomAccessFile.writeInt(students[i].getScore()); 
            }

            Scanner scanner = new Scanner(System.in);

            System.out.print("Ū���ĴX����ơH"); 

            int num = scanner.nextInt(); 

            // �ϥ�seek()��k�ާ@�s����m
            randomAccessFile.seek((num-1) * Student.size()); 
            Student student = new Student(); 

            // �ϥι�����read��kŪ�X���
            student.setName(readName(randomAccessFile));
            student.setScore(randomAccessFile.readInt());

            System.out.println("�m�W�G" + student.getName());
            System.out.println("���ơG" + student.getScore());

            // �]�w�����ɮ�
            randomAccessFile.close(); 
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("�Ы��w�ɮצW��");
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        }
    }

    private static String readName(RandomAccessFile randomAccessfile)
                               throws IOException { 
        char[] name = new char[15]; 

        for(int i = 0; i < name.length; i++) 
            name[i] = randomAccessfile.readChar(); 

        // �N�Ŧr�����N���ťզr���öǦ^
        return new String(name).replace('\0', ' '); 
    } 
} 