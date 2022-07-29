package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.stream.FileImageOutputStream;

class Data implements Serializable
{
	String name="alekh";
	String Age="29";
}









public class Serialization_Deserrialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
        Data d=new Data();
        
        //Serialization 
        FileOutputStream o=new FileOutputStream(new File("test.txt"));
       
        ObjectOutputStream obj=new ObjectOutputStream(o);
        obj.writeObject(d);
        //De Serialization
        FileInputStream i=new FileInputStream("test.txt");
        
        ObjectInputStream oi=new ObjectInputStream(i);
       Data r = (Data)oi.readObject();
       System.out.println(r.name);
        
	}

}
