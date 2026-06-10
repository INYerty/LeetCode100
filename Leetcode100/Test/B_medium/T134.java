package Test.B_medium;

public class T134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] remainOil = new int[n];
        int sumOil = 0;
        for (int i = 0; i < n; i++) {
            remainOil[i] = gas[i] - cost[i];
            sumOil += remainOil[i];
        }
        if (sumOil < 0)
            return -1;

        int curSum = 0;
        int start = 0;
        for (int i = 0; i < remainOil.length; i++) {
            curSum += remainOil[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        return start;
    }
}
