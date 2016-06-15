package org.anverm.geeksforgeeks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryMazeShortestPathDemo {

	public static void main(String[] args) {
		int[][] matrix = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
		
		Coordinate source = new Coordinate(0, 0);
		Coordinate destination = new Coordinate(3, 4);

		int[][] visited = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				visited[i][j] = -1;
			}
		}
		
		System.out.println("path length is = " + calculateShortestPathLength(matrix, source, destination, visited));
	}

	private static int calculateShortestPathLength(int[][] matrix, Coordinate start, Coordinate end, int[][] visited){
		printMatrix(matrix, visited);
		if(start == end){
			return 0;
		}
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		queue.add(start);
		visited[start.getX()][start.getY()] = 0;
		printMatrix(matrix, visited);
		
		while(!queue.isEmpty()){
			Coordinate coordinate = queue.remove();
			List<Coordinate> nearByCoordinates = getNearByCoordinates(matrix, coordinate);
			for(Coordinate nearByCoordinate : nearByCoordinates){
				if(nearByCoordinate.equals(end)){
					return 1 + visited[coordinate.getX()][coordinate.getY()];
				}
				if(visited[nearByCoordinate.getX()][nearByCoordinate.getY()] == -1 && matrix[nearByCoordinate.getX()][nearByCoordinate.getY()] == 1){
					visited[nearByCoordinate.getX()][nearByCoordinate.getY()] = 1 + visited[coordinate.getX()][coordinate.getY()];
					queue.add(nearByCoordinate);
					printMatrix(matrix, visited);
				}
			}
		}
		
		return 0;
	}
	
	private static void printMatrix(int[][] matrix1, int[][] matrix2){
		for(int i = 0; i < matrix1.length; i++){
			for(int j = 0; j < matrix1[0].length; j++){
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		for(int i = 0; i < matrix2.length; i++){
			for(int j = 0; j < matrix2[0].length; j++){
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("");
	}
	
	private static List<Coordinate> getNearByCoordinates(final int[][] matrix, Coordinate coordinate){
		List<Coordinate> coordinates = new LinkedList<Coordinate>();
		
		if((coordinate.getX() - 1) >= 0){
			coordinates.add(new Coordinate((coordinate.getX() - 1), coordinate.getY()));
		}
		
		if((coordinate.getY() + 1) < matrix[0].length){
			coordinates.add(new Coordinate(coordinate.getX(), (coordinate.getY() + 1)));
		}
		
		if((coordinate.getX() + 1) < matrix.length){
			coordinates.add(new Coordinate((coordinate.getX() + 1), coordinate.getY()));
		}
		
		if((coordinate.getY() - 1) >= 0){
			coordinates.add(new Coordinate(coordinate.getX(), (coordinate.getY() - 1)));
		}
		
		return coordinates;
	}
	
	static class Coordinate {
		private int x;
		private int y;
		
		public Coordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}

		@Override
		public boolean equals(Object obj) {
			return (((Coordinate) obj).getX() == x) && (((Coordinate) obj).getY() == y);
		}
	}
}
