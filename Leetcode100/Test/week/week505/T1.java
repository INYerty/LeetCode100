package Test.week.week505;

public class T1 {
    public int sumOfGoodIntegers(int n, int k) {
        int count = 0;
        int start = Math.max(1,n-k);
        for (int x = start; x <= n+k; x++) {
            if(Math.abs(n-x)<=k){
                count+=x;
            }
            if((n&x) == 0){
                count+=x;
            }
        }
        return count;
    }
}
