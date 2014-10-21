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
		System.out.println("書名:" + name);
		System.out.println("定價:" + price);
	}
}
