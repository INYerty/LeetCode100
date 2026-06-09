package Test.B_medium;

public class T122 {
    public int maxProfit(int[] prices) {
        int[] res = new int[prices.length-1];
        for(int i = 0;i<prices.length-1;i++){
            res[i] = prices[i+1] - prices[i];
        }
        int sum = 0;
        for(int i = 0;i<res.length;i++){
            if(res[i] > 0) sum+=res[i];
        }
        return sum;
    }
}
