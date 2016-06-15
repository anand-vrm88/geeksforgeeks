package org.anverm.geeksforgeeks;

import java.util.LinkedList;
import java.util.List;

public class TugOfWarDemo {
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[] arr =   {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		int leftSum = 0;
		for(int i = 0; i < arr.length; i++){
			leftSum += arr[i];
		}
		List<Integer> balancedRightIndices = new LinkedList<Integer>();
		balancedRightIndices = prepareBalancedIndices(arr, arr.length - 1, leftSum, 0, new LinkedList<Integer>(), balancedRightIndices);
		int[] leftArray = new int[arr.length - balancedRightIndices.size()];
		int[] rightArray = new int[balancedRightIndices.size()];
		for(int i = 0, leftIndex = 0, rightIndex = 0; i < arr.length; i++){
			if(balancedRightIndices.contains(i)){
				rightArray[rightIndex++] = arr[i];
			} else {
				leftArray[leftIndex++] = arr[i];
			}
		}
		
		System.out.println(convertToString(leftArray) + " <--> " + convertToString(rightArray));
	}
	
	private static List<Integer> prepareBalancedIndices(int[] leftArray, int lastIndex, int leftSum, int rightSum, List<Integer> rightIndices, List<Integer> balancedRightIndices){
		if(lastIndex < 0){
			return balancedRightIndices;
		}
		
		balancedRightIndices  = prepareBalancedIndices(leftArray, lastIndex - 1, leftSum, rightSum, rightIndices, balancedRightIndices);
		//Considering current element in right subarray.
		leftSum = leftSum - leftArray[lastIndex];
		rightSum += leftArray[lastIndex];
		rightIndices.add(new Integer(lastIndex));
		if(min > absoluteDiff(leftSum, rightSum)){
			min = absoluteDiff(leftSum, rightSum);
			balancedRightIndices = new LinkedList<Integer>(rightIndices);
		}
		balancedRightIndices = prepareBalancedIndices(leftArray, lastIndex - 1, leftSum, rightSum, rightIndices, balancedRightIndices);
		rightIndices.remove(new Integer(lastIndex));
		return balancedRightIndices;
	}

	private static String convertToString(int[] arr){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++){
			sb.append(arr[i]+" ");
		}
		return sb.toString();
	}
	
	private static int absoluteDiff(int a, int b){
		if (a > b) {
			return a - b;
		} else {
			return b - a;
		}
	}
}
