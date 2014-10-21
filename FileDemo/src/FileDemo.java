import java.io.*;
public class FileDemo {

    public static void main(String[] args) throws IOException{
        File dir = new File("txt");
        File file = new File(dir, "note.txt");
        if(!dir.exists()){
            System.out.print(dir.getName() + "�ؿ��O�_�إߦ��\?");
            System.out.println(dir.mkdirs());
        }
        else
            System.out.print(dir.getName() + "�ؿ��w�s�b");

        if(!file.exists()){
            System.out.print(file.getName() + "�ɮ׬O�_�إߦ��\?");
            System.out.println(file.createNewFile());
        }
        else
            System.out.print(file.getName() + "�ɮפw�s�b");

        File newFile = new File(file.getParent(), "comment.txt");
        System.out.println(file.getName() + "��W��" + newFile.getName());
        System.out.print("�ؿ��O�_�ק令�\?");
        System.out.println(file.renameTo(newFile));
        System.out.print(newFile.getName() + "�ɮ׬O�_�R�����\?");
        System.out.println(newFile.delete());
        System.out.print(dir.getName() + "�ؿ��O�_�R�����\?");
        System.out.println(dir.delete());
    }
}