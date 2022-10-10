package taskar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Handlers.Disk;
import Handlers.MouseHandler;


public class main extends JFrame {

	private JPanel contentPane;
	public static main frame;
	public static Disk disk = new Disk();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new main();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ImageIcon icon = new ImageIcon("book.jpg");
					
					frame.setIconImage(icon.getImage());
					frame.setLocationRelativeTo(null);
					frame.setResizable(true);
					
					
					frame.setUndecorated(true);
					
					frame.getContentPane().setLayout(new BorderLayout());
					
					frame.setContentPane(new ShapedPane());
					
					
					frame.pack();
					frame.setVisible(true);
					frame.setBackground(new Color(1.0f,1.0f,1.0f,0f));
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
			Disk.read();
		
	}
	public static void minWindow() {
		frame.setState(Frame.ICONIFIED);
	}
	public static void dragWindow(int MouseX, int MouseY, MouseEvent e) {
		frame.setLocation(frame.getX()+e.getX()-MouseX,frame.getY()+e.getY()-MouseY);
	}
}
