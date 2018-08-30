package test;

public class Problem2 {
    private static boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start = start + 1;
            end = end - 1;
        }
        return true;
    }

    public static int minPalSubNum(String s) {
        return recursiveCall(s, 0, s.length() - 1);
    }

    private static int recursiveCall(String s, int start, int end) {
        if (checkPalindrome(s, start, end)) {
            return 1;
        }
        int min = end - start + 1;
        int sum;
        for (int k = start; k < end; k++) {
            sum = recursiveCall(s, start, k) + recursiveCall(s, k + 1, end);
            if (min > sum) {
                min = sum;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minPalSubNum("13212"));
        System.out.println(memoizedMethod("13215552"));
    }

    public static int memoizedMethod(String s) {
        int[][] number = new int[s.length()][s.length()];
        int[][] place = new int[s.length()][s.length()];

        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start <= s.length() - len; start++) {
               int end = start + len - 1;
                if (checkPalindrome(s,start,end)){
                    number[start][end]=1;
                    place[start][end]=-1;
                }
                else{
                    number[start][end]= len;
                    for (int k =start;k<end;k++ ){
                        int sum = number[start][k]+ number[k+1][end];
                        if(sum<number[start][end]){
                            number[start][end]= sum;
                            place[start][end]= k;
                        }
                    }
                }
            }

        }
        printPal(s,place,0,s.length()-1);
        return number[0][s.length()-1];
    }
    private static void printPal(String s,int[][] place,int start,int end){
        if (checkPalindrome(s,start,end)){
            System.out.print(s.substring(start,end+1)+",");
        }
        else{
            printPal(s,place,start,place[start][end]);
            printPal(s,place,place[start][end]+1,end);
        }
    }
}
