package mouse;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class MouseCompment extends JComponent {

	private static final int SIDELENGTH = 10;
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	
	public MouseCompment() {
		current = null;
		squares = new ArrayList<>();
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				current = find(e.getPoint());
				if(current == null) {
					add(e.getPoint());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				current = find(e.getPoint());
				if(current != null&&e.getClickCount()>2) {
					remove(current);
				}
			}
			
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if(find(e.getPoint()) == null) {
					setCursor(Cursor.getDefaultCursor());
				}else {
					setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(current != null) {
					int x = e.getX();
					int y = e.getY();
					current.setFrame(x-SIDELENGTH/2, y-SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
					repaint();
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (Rectangle2D rectangle2d : squares) {
			g2.draw(rectangle2d);
		}
	}
	
	public Rectangle2D find(Point2D p) {
		for (Rectangle2D rectangle2d : squares) {
			if(rectangle2d.contains(p)) {
				return rectangle2d;
			}
		}
		
		return null;
	}
	
	public void add(Point2D p) {
		double x = p.getX();
		double y = p.getY();
		
		current = new Rectangle2D.Double(x-SIDELENGTH/2, y-SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
		squares.add(current);
		repaint();
	}
	
	public void remove(Rectangle2D s) {
		if(s == null) {
			return;
		}
		if(s == current) {
			current = null;
		}
		squares.remove(current);
		repaint();
	}
}
