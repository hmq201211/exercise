package oN2Sort;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		boolean flag;
		for (int i = arr.length - 1; i > 0; i--) {
			flag = true;
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] i = { 2, 24, 341, 2323, 22, 44, 223, 55, 112 };
		bubbleSort(i);
		for (int j : i) {
			System.out.println(j);

		}
	}

}
