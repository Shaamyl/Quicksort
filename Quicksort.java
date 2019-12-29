
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {
	static int mainArr[] = new int[10000];
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("QuickSort.txt"));
			
			int c = 0;
			while(in.hasNext()) {
				mainArr[c] = in.nextInt();
				c++;
			}
			int[] testArr = {4, 1 ,2 ,3, 29, 31, 0};
			Quicksort qO = new Quicksort();
			//System.out.println(qO.choosePivot(testArr, 0, testArr.length - 1));
			//qO.partition(testArr, 3, 0, 6);
			//System.out.println(Arrays.toString(testArr));
			System.out.println("Array sorted!");
			System.out.println("Number of comparisions made during QuickSort: " + qO.quickSort(mainArr, 0, mainArr.length-1));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private int choosePivot(int mainArr[], int startI, int endI) {
		int middle = (((endI + startI)))/2;
		int[] medianArr = new int[3];
		medianArr[0] = mainArr[startI];
		medianArr[1] = mainArr[middle];
		medianArr[2] = mainArr[endI];
		Arrays.sort(medianArr);
		
		if(medianArr[1] == mainArr[startI]) {
			return startI;
		}else if(medianArr[1] == mainArr[middle]) {
			return middle;
		}else if (medianArr[1] == mainArr[endI]) {
			return endI;
		}
		System.out.println("failed");
		return 0;
	}
	
	private int partition(int mainArr[], int pivot, int startI, int endI) {
		int temp;
		temp = mainArr[pivot];
		mainArr[pivot] = mainArr[startI];
		mainArr[startI] = temp;
		
		int i = startI + 1;
		for(int j = startI + 1; j <= endI; j++) {
			if(mainArr[j] < mainArr[startI]) {
				temp = mainArr[j];
				mainArr[j] = mainArr[i];
				mainArr[i] = temp;
				i++;
			}
		}
		temp = mainArr[i - 1];
		mainArr[i-1] = mainArr[startI];
		mainArr[startI] = temp;
		return i-1;
	}
	
	private int quickSort(int[] mainArr, int startI, int endI) {
		if(startI >= endI) {
			return 0;
		}
		int comparisons = 0;
		comparisons += endI - startI;
		int pivot = choosePivot(mainArr, startI, endI);
		int finalPivot = partition(mainArr, pivot, startI, endI);
		comparisons += quickSort(mainArr, startI, finalPivot - 1);
		comparisons += quickSort(mainArr, finalPivot + 1, endI);
		return comparisons;
	}
}
