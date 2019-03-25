import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {
	
	public static final int ROWS = 50;
	public static final int COLS = 50;
	public static final int BLOCK_SIZE = 10;
	
//	Image offscreenImage = null;
	
	public void launch() {
		this.setLocation(200, 200);
		this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Yard().launch();
	}
	
	@Override
	public void paint(Graphics arg0) {
		Color c = arg0.getColor();
		arg0.setColor(Color.gray);
		arg0.fillRect(0, 0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		
		arg0.setColor(Color.black);
		// drow out row lines
		for (int i = 1; i < ROWS; ++i) {
			arg0.drawLine(0, BLOCK_SIZE * i, COLS*BLOCK_SIZE, BLOCK_SIZE * i);
		}

		// drow out col lines
		for (int i = 1; i < COLS; ++i) {
			arg0.drawLine(BLOCK_SIZE * i, 0, BLOCK_SIZE * i, ROWS * BLOCK_SIZE);
		}
		
		arg0.setColor(c);
	}

}
