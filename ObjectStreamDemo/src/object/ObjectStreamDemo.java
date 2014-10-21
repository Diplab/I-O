package object;

import java.io.*;
import java.util.*;

public class ObjectStreamDemo {
    public static void main(String[] args) {
        User[] users = {new User("cater", 101),
                        new User("justin", 102)}; 
        // �g�J�s��
        writeObjectsToFile(users, args[0]);

        try {
            // Ū���ɮ׸��
            users = readObjectsFromFile(args[0]);
            // ���Ū�^������
            for(User user : users) {
                System.out.printf("%s\t%d%n", user.getName(), user.getNumber());
            }
            System.out.println();

            users = new User[2];
            users[0] = new User("momor", 103);
            users[1] = new User("becky", 104);

            // ���[�s������ɮ�
            appendObjectsToFile(users, args[0]);

            // Ū���ɮ׸��
            users = readObjectsFromFile(args[0]);
            // ���Ū�^������
            for(User user : users) {
                System.out.printf("%s\t%d%n", user.getName(), user.getNumber());
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("�S�����w�ɦW");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // �N���w������g�J�ܫ��w���ɮ�
    public static void writeObjectsToFile(
                         Object[] objs, String filename) { 
        File file = new File(filename);

        try { 
            ObjectOutputStream objOutputStream = 
                new ObjectOutputStream(
                      new FileOutputStream(file)); 
            for(Object obj : objs) {
                // �N����g�J�ɮ�
                objOutputStream.writeObject(obj); 
            }
            // ������y
            objOutputStream.close(); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        }
    }

    // �N���w�ɮפ���������Ū�^
    public static User[] readObjectsFromFile(
                             String filename) 
                               throws FileNotFoundException {
        File file = new File(filename); 

        // �p�G�ɮפ��s�b�N��X�ҥ~
        if(!file.exists()) 
            throw new FileNotFoundException(); 

        // �ϥ�List���x�sŪ�^������
        List<User> list = new ArrayList<User>();

        try {
            FileInputStream fileInputStream = 
                new FileInputStream(file);
            ObjectInputStream objInputStream = 
                new ObjectInputStream(fileInputStream); 

            while(fileInputStream.available() > 0) {
                list.add((User) objInputStream.readObject());
            }
            objInputStream.close(); 
        } 
        catch(ClassNotFoundException e) { 
            e.printStackTrace(); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        }

        User[] users = new User[list.size()];
        return list.toArray(users);
    }

    // �N������[�ܫ��w���ɮפ���
    public static void appendObjectsToFile(
                           Object[] objs, String filename) 
                               throws FileNotFoundException {

        File file = new File(filename); 

        // �p�G�ɮפ��s�b�h��X�ҥ~
        if(!file.exists()) 
             throw new FileNotFoundException(); 

        try {
            // ���[�Ҧ�
            ObjectOutputStream objOutputStream = 
               new ObjectOutputStream(
                  new FileOutputStream(file, true)) { 
                    // �p�G�n���[������ɮ׫�
                    // �������s�w�q�o�Ӥ�k
                    protected void writeStreamHeader() 
                                     throws IOException {} 
               };  

            for(Object obj : objs) {
                // �N����g�J�ɮ�
                objOutputStream.writeObject(obj); 
            }
            objOutputStream.close(); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
}