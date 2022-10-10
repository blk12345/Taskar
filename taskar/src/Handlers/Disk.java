package Handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import taskar.ShapedPane;

public class Disk {

	private static File scores= new File("scores");
	
	 public static ArrayList<String> names = new ArrayList<String>();
	//private static String[] scores = new String[10];
	public static int fileIndex = 1;
	public static int num =0;
	public Disk() {
		
		for(File f:scores.listFiles()) {
			
			names.add(f.getName());
			num++;
		}




}
	
	
	public static void write() {
		 FileWriter Writer;
		 
		 try {
			Writer = new FileWriter(new File(names.get(fileIndex)));
				for(int i =0;i<ShapedPane.d.getSize();i++) {
			Writer.write(ShapedPane.d.get(i).toString()+"\n");
					} Writer.close();
	
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public static void read() {
	
		try {
		Scanner	myReader = new Scanner(new File(names.get(fileIndex)));
		while (myReader.hasNextLine()) {
		    ShapedPane.d.addElement(myReader.nextLine());
		  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
}
