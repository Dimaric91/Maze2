package maze;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MazeGenerator {
	
	private static Set<Cell> dfsColors;
	private static Random rnd;
	
	public static Maze newInstance(int n, int m) {
		dfsColors = new HashSet<>();	
		rnd = new Random();
		Deque<Cell> stack = new ArrayDeque<>(n * m / 2);
		
		Maze ret = new Maze(n, m);
		
		int x = rnd.nextInt(n);
		int y = rnd.nextInt(m);
		
		Cell pointer = ret.getCell(x, y);
		stack.push(pointer);
		dfsColors.add(pointer);
		
		while(!stack.isEmpty()) {
			try {
				Cell neighbor = getNeighbor(ret, pointer);
				removeBorder(pointer, neighbor);
				pointer = neighbor;
				stack.push(pointer);
				dfsColors.add(pointer);
			} catch (NoNeighborsException e) {
				stack.pop();
				pointer = stack.peek();
			}
		}
		
		return ret;
	}
	
	private static void removeBorder(Cell current, Cell neighbor) {
		if (current.getX() > neighbor.getX()) {
			current.removeUp();
			neighbor.removeDown();
		} else if (current.getX() < neighbor.getX()) {
			current.removeDown();
			neighbor.removeUp();
		} else if (current.getY() > neighbor.getY()) {
			current.removeLeft();
			neighbor.removeRight();
		} else if (current.getY() < neighbor.getY()){
			current.removeRight();
			neighbor.removeLeft();
		}
	}
	
	private static Cell getNeighbor(Maze m, Cell c) throws NoNeighborsException {
		List<Cell> ret = m.getNeighbors(c.getX(), c.getY());
		
		Iterator<Cell> it = ret.iterator();
		while (it.hasNext()) {
			Cell elem = it.next();
			if (dfsColors.contains(elem)) {
				it.remove();
			}
		}
		if (ret.isEmpty()) {
			throw new NoNeighborsException();
		} else {
			
		}
		return ret.get(rnd.nextInt(ret.size()));
	}
	
	public static void main(String[] args) {
		MazeGenerator.newInstance(10, 10).print();
	}
	
}
