package object;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
    String name;
    double price; 
    
    public Book(String name, double price){
    	this.name = name;
    	this.price = price;
    }
	public void show() {
		System.out.println("�ѦW:" + name);
		System.out.println("�w��:" + price);
	}
}
