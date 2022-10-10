package Handlers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintPane extends JFrame {
	@Override
		public
		Dimension getPreferredSize() {
		    return new Dimension(700, 700);
		}

		protected void paintComponent(Graphics g) {
		    super.paintComponents(g);
		    Graphics2D g2d = (Graphics2D) g.create();
		    RenderingHints hints = new RenderingHints(
		            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    g2d.setRenderingHints(hints);
		    
		}

		protected void drawShape(Graphics2D g2d, int x, int y) {
			g2d.setColor(Color.black);
			g2d.drawRoundRect(0,0,500,500,55,55);
			
		}
		}

