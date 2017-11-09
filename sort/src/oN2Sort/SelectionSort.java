package oN2Sort;

public class SelectionSort {
	
	public static void selectionSort(int[] arr) {
		int minIndex;
		for(int i=0;i<arr.length-1;i++) {
			minIndex=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			swap(arr,i,minIndex);
		}
	}
	public static void selectionSort_2(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			swap(arr,i,minIndex(arr, i, arr.length-1));
		}
	}
	public static void swap(int[] arr,int i,int j) {
		int temp= arr[i];
		arr[i]= arr[j];
		arr[j]=temp;
	}
	public static int minIndex(int[] arr, int s,int e) {
		int minIndex=s;
		for(int index= s+1;index<=e;index++) {
			if(arr[minIndex]>arr[index]) {
				minIndex=index;
			}
		}
		return minIndex;
	}
	
	public static void main(String[] args) {
		int[] i= {2,24,341,2323,22,44,223,55,112};
		selectionSort_2(i);
		for(int j:i) {
			System.out.println(j);
		}
	}

}
