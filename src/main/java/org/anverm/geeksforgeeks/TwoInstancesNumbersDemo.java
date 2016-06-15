package org.anverm.geeksforgeeks;

public class TwoInstancesNumbersDemo {

	public static void main(String[] args) {
		for (int k = 0; k < 50; k++) {
			int[] arr = prepareSpecialArray(k);
			if (arr != null) {
				System.out.print("For number ["+k+"]: ");
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println("");
			} else {
				System.out.print("For number ["+k+"]: ");
				System.out.println("No array posible");
			}
		}
	}
	
	private static int[] prepareSpecialArray(int n){
		int[] arr = new int[2*n];
		if(prepareSpecialArray(arr, n)){
			return arr;
		} else {
			return null;
		}
	}
	
	private static boolean prepareSpecialArray(int[] arr, int n){
		if(n == 0){
			return true;
		}
		
		for(int i = 0; (i + n + 1) < arr.length; i++){
			if(isValidIndex(arr, i, n)){
				arr[i] = n;
				arr[i + n + 1] = n;
				if(prepareSpecialArray(arr, n - 1)){
					return true;
				}
				//backtrack
				arr[i] = 0;
				arr[i + n + 1] = 0;
			}
		}
		return false;
	}

	private static boolean isValidIndex(int[] arr, int index, int n){
		return (arr[index] == 0) && (arr[index + n + 1] == 0);
	}
}
