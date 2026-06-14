package Test.week.week506;

public class T1 {
    public boolean checkGoodInteger(int n) {
        String num = String.valueOf(n);
        char[] charArray = num.toCharArray();
        int sum = 0;
        int muti = 0;
        for(char ch:charArray){
            sum += ch-'0';
            muti += (ch-'0')*(ch-'0');
        }
        return muti-sum>=50;
    }
}
