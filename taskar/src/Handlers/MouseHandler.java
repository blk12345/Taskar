package Handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import taskar.ShapedPane;
import taskar.main;

public class MouseHandler implements MouseListener{

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(ShapedPane.listChanged == true) {
		ShapedPane.d.removeElementAt(ShapedPane.list.getSelectedIndex());
		Disk.write();
		}
		ShapedPane.listChanged=false;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
