package taskar;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Handlers.Disk;
import Handlers.KeyHandler;
import Handlers.MouseHandler;




@SuppressWarnings("serial")
public class ShapedPane extends JPanel{
	
	int listWidth = getWidth()+350;
	int listHeight = getHeight()+440;
	int MouseX;
int MouseY;
int exitX = getWidth()+50;
int minX = getWidth()+100;
int barX = getWidth()+150;
int halfX = getWidth()/2;

MouseHandler mouse = new MouseHandler();
KeyHandler key = new KeyHandler();

public static boolean listChanged = false;
public static ArrayList<String> List = new ArrayList<String>();
public static DefaultListModel d = new DefaultListModel();
public static JList list = new JList(d);
public static JTextField textField = new JTextField();
public static JLabel fileLabel = new JLabel(Disk.names.get(Disk.fileIndex)+".txt");




public ShapedPane() {
	
	
	
		setLayout(null);
		
		 JButton min = new JButton("_");
		 min.setBounds(minX, 4, 50, 21);	
		 min.setFocusable(false);
			add(min);
			min.setForeground(Color.BLACK);
			min.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					main.minWindow();
				}
			});
			
			JButton exit = new JButton("X");
			exit.setBounds(exitX, 4, 50, 21);
			exit.setFocusable(false);
			add(exit);
			exit.setForeground(Color.red);
			exit.setBackground(Color.LIGHT_GRAY);
			
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					main.dragWindow(MouseX, MouseY, e);
				}
			});
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					MouseX = e.getX();
					MouseY = e.getY();
				}
			});
			
			
		
			 JButton right = new JButton(">");
			 right.setBounds(minX+200, 4, 50, 21);	
			 right.setFocusable(false);
				add(right);
				right.setForeground(Color.blue);
				right.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						try {
						Disk.fileIndex++;
						d.removeAllElements();
						Disk.read();
						fileLabel.setText(Disk.names.get(Disk.fileIndex)+".txt");
						}catch(Exception e1) {
							Disk.fileIndex = Disk.num-1;
							Disk.read();
							fileLabel.setText(Disk.names.get(Disk.fileIndex)+".txt");
							System.out.println("end of file");
							
						}
						
						
						
					}
				});
				
				JButton left = new JButton("<");
				 left.setBounds(minX+150, 4, 50, 21);	
				 left.setFocusable(false);
					add(left);
					left.setForeground(Color.blue);
					left.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(Disk.fileIndex>0) {
								Disk.fileIndex--;
								d.removeAllElements();
								Disk.read();
								fileLabel.setText(Disk.names.get(Disk.fileIndex)+".txt");
								}else {
									
									System.out.println("end of file");
									
								}
							
								
						}
					});
			
			
			textField.setBounds(0, 30, 300, 30);
			textField.addKeyListener(key);
			textField.setFont(new Font("Arial",Font.ITALIC,20));
			add(textField);
			
			fileLabel.setBounds(minX, 70, 300, 21);
			fileLabel.setFont(new Font("Arial",Font.ITALIC,20));
			add(fileLabel);
			
			 JButton add = new JButton("Enter");
			 add.setBounds(300, 30, 100, 30);	
			 add.setFocusable(false);
				add(add);
				add.setForeground(Color.BLACK);
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ShapedPane.d.addElement(ShapedPane.textField.getText());
						ShapedPane.textField.setText("");
						main.disk.write();
						
					}
				});
				 JButton file = new JButton("File");
				 file.setBounds(350, 60, 50, 30);	
				 file.setFocusable(false);
					add(file);
					file.setForeground(Color.blue);
					file.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							 File directory = new File("scores");
							 try {
									Desktop.getDesktop().open(directory);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
						}
					});
				
				
				
				
				
				
				
				
				list.setBackground(Color.white);
				list.setFixedCellHeight(40);
				list.setFixedCellWidth(50);
				list.setFont(new Font("Arial",Font.BOLD,20));
				list.setDragEnabled(false);
				list.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(70, 130, 180), new Color(51, 0, 153)));
				
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
					
						System.out.println(list.getSelectedIndex());
						
						//List.remove(list.getSelectedIndex());
						try {
						listChanged = true;
					
						}catch(Exception e1){
							System.out.println(e1);
						}
						
						

		
					
					}
				});
				list.addMouseListener(mouse);
				
			
				
				JScrollPane scrollBar = new JScrollPane(list);
				
				scrollBar.setBounds(30, 100, listWidth, listHeight);
			add(scrollBar);
				
   }

    public Dimension getPreferredSize() {
        return new Dimension(main.frame.getWidth(), main.frame.getHeight());
    }

    protected void paintComponent(Graphics g) {
        super.getComponents(); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(),55,55));
       
        g2d.dispose();
    }

}
