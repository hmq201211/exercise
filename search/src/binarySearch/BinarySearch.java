package binarySearch;

public class BinarySearch {
	public static int binarySearch(int[] values, int target, int start, int last) {
		int mid = (start + last) / 2;
		if (start > last) {
			return -1;
		} else {
			if (values[mid] == target) {
				return mid;
			} else {
				if (values[mid] > target) {
					return binarySearch(values, target, start, mid - 1);
				} else
					return binarySearch(values, target, mid + 1, last);
			}
		}
	}
	public static void main(String[] args) {
		int[] values ={1,2,3,4,5,6,7,9,200,400,900,1000};
		System.out.println(binarySearch(values, 9, 0, values.length-1));
	}

}
