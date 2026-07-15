package Test.B_medium;
import java.util.ArrayList;
import java.util.List;
/**
 * 139. 单词拆分
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * https://leetcode.cn/problems/word-break/description/
 */
public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(wordDict.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        T139 t139 = new T139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean leetcode = t139.wordBreak("leetcode", list);
        System.out.println(leetcode);
    }
}
