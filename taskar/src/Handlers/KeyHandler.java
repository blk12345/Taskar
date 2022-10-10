package Handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import taskar.ShapedPane;
import taskar.main;

public class KeyHandler implements KeyListener{
	
	

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
int code = e.getKeyCode();
		
		if(code==KeyEvent.VK_ENTER) {
		ShapedPane.d.addElement(ShapedPane.textField.getText());
		ShapedPane.textField.setText("");
		main.disk.write();
		
		
		}
		if(code==KeyEvent.VK_RIGHT) {
			try {
				Disk.fileIndex++;
				ShapedPane.d.removeAllElements();
				Disk.read();
				ShapedPane.fileLabel.setText(Disk.names.get(Disk.fileIndex)+".txt");
				}catch(Exception e1) {
					Disk.fileIndex = Disk.num-1;
					Disk.read();
					ShapedPane.fileLabel.setText(Disk.names.get(Disk.fileIndex)+".txt");
					System.out.println("end of file");
					
				}
		}
		if(code==KeyEvent.VK_LEFT) {
			if(Disk.fileIndex>0) {
				Disk.fileIndex--;
				ShapedPane.d.removeAllElements();
				Disk.read();
				ShapedPane.fileLabel.setText(Disk.names.get(Disk.fileIndex)+".txt");
				}else {
					
					System.out.println("end of file");
					
				}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
