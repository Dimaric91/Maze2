package maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {

	Cell[][] cells;
	
	public Maze(int n, int m) {
		cells = new Cell[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
	}
	
	public List<Cell> getNeighbors(int i, int j) {
		List<Cell> ret = new ArrayList<>();
		
		try {
			ret.add(cells[i + 1][j]);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		
		try {
			ret.add(cells[i][j + 1]);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		
		try {
			ret.add(cells[i - 1][j]);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		
		try {
			ret.add(cells[i][j - 1]);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		
		return ret;
	}
	
	public void print() {
		for (int i = 0; i < cells[0].length; i++) {
			if (cells[0][i].isUp()) {
				System.out.print(" ---");
			} else {
				System.out.print("    ");
			}
		}
		System.out.println();
		for (int i = 0; i < cells.length; i++) {
			if (cells[i][0].isLeft()) {
				System.out.print("|");
			} else {
				System.out.print(" ");
			}
			for (int j = 0; j < cells[i].length; j++) {
				System.out.print("   ");
				if (cells[i][j].isRight()) {
					System.out.print("|");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			for (int j = 0; j < cells[i].length; j++) {
				if (cells[i][j].isDown()) {
					System.out.print(" ---");
				} else {
					System.out.print("    ");
				}
			}
			System.out.println();
		}
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}
}
