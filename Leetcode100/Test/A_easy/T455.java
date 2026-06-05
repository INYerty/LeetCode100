package Test.A_easy;

import java.util.Arrays;

public class T455 {
    public int findContentChildren(int[] g, int[] s) {
        int num = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length-1;
        for (int i = g.length-1; i >= 0 ; i--) {
            if(index>=0 && s[index] >= g[i]){
                num++;
                index--;
            }
        }
        return num;
    }
}
