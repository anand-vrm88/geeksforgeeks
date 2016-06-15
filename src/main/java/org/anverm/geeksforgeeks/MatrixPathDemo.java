package org.anverm.geeksforgeeks;

public class MatrixPathDemo {

	public static void main(String[] args) {
		int m = 2;
		int n = 3;
		String[] path = new String[m + n - 1];
		printPath(path, m - 1, n - 1);
	}
	
	private static void printPath(String[] path, int m, int n){
		if(m < 0 || n <0){
			return;
		}
		
		path[m + n] = m + "," + n;
		
		if(m == 0 && n == 0){
			System.out.print("Path is: ");
			for(int i = 0; i < path.length; i++){
				System.out.print("["+path[i]+"], ");
			}
			System.out.println("");
			return;
		}
		
		printPath(path, m - 1, n);
		printPath(path, m, n - 1);
	}

}
