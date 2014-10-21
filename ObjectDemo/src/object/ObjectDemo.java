package object;
import java.io.*;

public class ObjectDemo {

	public static void main(String[] args) throws Exception{
		File file = new File("BookIn");
		Book[] books = new Book[2];
		books[0] = new Book("Java", 700);
		books[1] = new Book("C++", 600);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(Object book : books)
			oos.writeObject(book);//�g�J����۰��૬��Object
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println(file.getName() + "�ɮפ��e�p�U:");
		try{
			while(true){
				((Book)ois.readObject()).show();
			}
		}
		catch(EOFException e){
			System.out.println("���Ū������");
		}
		ois.close();
		fis.close();
	}
}
