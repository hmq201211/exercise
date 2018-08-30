package test;

import java.util.ArrayList;

public class test {
    private static int[] arr = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public static int cut_Rod(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        double q = Double.NEGATIVE_INFINITY;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cut_Rod(p, n - i));
        }
        return (int) q;

    }

    public static int memoized_Cut_Rod(int[] p, int n) {
        double[] memo = new double[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Double.NEGATIVE_INFINITY;
        }
        return memoized_Cut_Rod_Aux(p, n, memo);
    }

    private static int memoized_Cut_Rod_Aux(int[] p, int n, double[] memo) {
        if (memo[n] >= 0) {
            return (int) memo[n];
        }
        double result;
        if (n == 0)
            result = 0;
        else {
            result = Double.NEGATIVE_INFINITY;
            for (int i = 1; i <= n; i++) {
                result = Math.max(result, p[i] + memoized_Cut_Rod_Aux(p, n - i, memo));
            }
        }
        memo[n] = result;
        return (int) result;
    }

    public static int bottom_Up_Cut_Rod(int[] p, int n) {
        double[] memo = new double[n + 1];
        memo[0] = 0;
        double temp;
        for (int i = 1; i <= n; i++) {
            temp = Double.NEGATIVE_INFINITY;
            for (int j = 1; j <= i; j++) {
                temp = Math.max(temp, p[j] + memo[i - j]);
            }
            memo[i] = temp;
        }
        return (int) memo[n];
    }

    private static ArrayList<double[]> extended_Bottom_Up_Cut_Rod(int[] p, int n) {
        ArrayList<double[]> result = new ArrayList<double[]>();
        result.add( new double[n + 1]);
        result.add(new double[n + 1]);
        double q;
        for (int j = 1; j <= n; j++) {
            q = Double.NEGATIVE_INFINITY;
            for (int i = 1; i <= j; i++) {
                if (q < p[i] + result.get(0)[j-i]) {
                    q = p[i] + result.get(0)[j-i];
                    result.get(1)[j] = i;
                }
            }
            result.get(0)[j]=q;
        }
        return result;
    }
    public static void print_Cut_Rod_Solution(int[] p,int n){
        ArrayList<double[]> result= extended_Bottom_Up_Cut_Rod(p,n);
        while (n>0){
            System.out.println(result.get(1)[n]);
            n= (int)(n- result.get(1)[n]);
        }

    }


    public static void main(String[] args) {
        System.out.println(cut_Rod(arr, 9));
        System.out.println(memoized_Cut_Rod(arr, 9));
        System.out.println(bottom_Up_Cut_Rod(arr, 9));
        print_Cut_Rod_Solution(arr,10);
    }
}
