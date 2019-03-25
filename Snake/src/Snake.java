import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	Node head = null;
	Node tail = null;
	private int size = 0;
	
	public Snake(Node node) {
		head = node;
		tail = node;
		size = 1;
	}
	
	public void addToTail(Node node) {
		
	}
	
	private class Node {

		int w = Yard.BLOCK_SIZE;
		int h = Yard.BLOCK_SIZE;
		int row, col;
		Dir dir = Dir.L;
		
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
		void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.black);
			g.fillRect(Yard.BLOCK_SIZE * row, Yard.BLOCK_SIZE * col, w, h);
			g.setColor(c);
		}
	}
}
