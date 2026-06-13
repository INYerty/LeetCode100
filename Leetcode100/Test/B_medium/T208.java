package Test.B_medium;
/**
 * 208. 实现 Trie (前缀树)
 *
 * Trie [https://baike.baidu.com/item/字典树/9825209?fr=aladdin]（发音类似 "try"）或者说 前
 * 缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 请你实现 Trie 类：
 * * Trie() 初始化前缀树对象。
 * * void insert(String word) 向前缀树中插入字符串 word 。
 * * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；
 * 否则，返回 false 。
 * * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 tru
 * e ；否则，返回 false 。
 * 提示：
 * * 1 <= word.length, prefix.length <= 2000
 * * word 和 prefix 仅由小写英文字母组成
 * * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 *
 * 链接：https://leetcode.cn/problems/implement-trie-prefix-tree/
 */

public class T208 {
    class Trie {

        class TrieNode{
            boolean isEnd;
            TrieNode[] next;

            public TrieNode(){
                isEnd = false;
                next = new TrieNode[26];
            }
        }

        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()){
                if (node.next[c-'a'] == null){
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()){
                if (node.next[c-'a'] == null) return false;
                node = node.next[c-'a'];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char p : prefix.toCharArray()){
                if (node.next[p-'a'] == null) return false;
                node = node.next[p-'a'];
            }
            return true;
        }
    }
}