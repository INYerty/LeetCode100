package Test.B_medium;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;

public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return re(preorder,inorder);
    }

    /* FirstTime
    public TreeNode re(int[] preorder, int[] inorder){
        if (preorder.length == 0) return null;
        // pre 取第一个元素 即为最根节点
        TreeNode root = new TreeNode(preorder[0]);
        HashMap<Integer, Integer> map = new HashMap<>();
        // 将中序遍历的序列 以数组中的值为键 数组下标为值 存入哈希表
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        Integer inorderRootIndex = map.get(preorder[0]);//4
        ArrayList<Integer> inorderLeft = new ArrayList<>();
        for (int i = 0; i < inorderRootIndex; i++) {
            inorderLeft.add(inorder[i]);
        }
        ArrayList<Integer> inorderRight = new ArrayList<>();
        for (int i = inorderRootIndex+1; i < inorder.length; i++) {
            inorderRight.add(inorder[i]);
        }
        int leftSize = inorderLeft.size();

        ArrayList<Integer> preorderLeft = new ArrayList<>();
        for (int i = 1; i <= leftSize; i++) {
            preorderLeft.add(preorder[i]);
        }
        ArrayList<Integer> preorderRight = new ArrayList<>();
        for (int i = leftSize+1; i < preorder.length; i++) {
            preorderRight.add(preorder[i]);
        }
        //转成数组
        int[] inorderLeftArray = new int[inorderLeft.size()];
        int[] inorderRightArray = new int[inorderRight.size()];
        int[] preorderLeftArray = new int[preorderLeft.size()];
        int[] preorderRightArray = new int[preorderRight.size()];
        for (int i = 0; i < inorderLeft.size(); i++) {
            inorderLeftArray[i] = inorderLeft.get(i);
            preorderLeftArray[i] = preorderLeft.get(i);
        }
        for (int i = 0; i < inorderRight.size(); i++) {
            inorderRightArray[i] = inorderRight.get(i);
            preorderRightArray[i] = preorderRight.get(i);
        }
        root.left = re(preorderLeftArray,inorderLeftArray);
        root.right = re(preorderRightArray,inorderRightArray);
        return root;
    }*/

    // SecondTimeExec

    public TreeNode re(int[] preorder, int[] inorder){
        if (preorder.length==0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        Integer rootIndex = map.get(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);

        //分割中序序列
        LinkedList<Integer> inLeftRoot = new LinkedList<>();
        for(int i = 0;i<rootIndex;i++){
            inLeftRoot.add(inorder[i]);
        }
        LinkedList<Integer> inRightRoot = new LinkedList<>();
        for(int i = rootIndex+1;i<inorder.length;i++){
            inRightRoot.add(inorder[i]);
        }
        //分割先序遍历序列
        LinkedList<Integer> preLeftRoot = new LinkedList<>();
        for (int i = 1;i<=rootIndex;i++){
            preLeftRoot.add(preorder[i]);
        }
        LinkedList<Integer> preRightRoot = new LinkedList<>();
        for (int i = rootIndex+1;i<preorder.length;i++){
            preRightRoot.add(preorder[i]);
        }

        int[] preLeftRootArray  =new int[preLeftRoot.size()];
        int[] inLeftRootArray  =new int[inLeftRoot.size()];
        for(int i =0;i< preLeftRoot.size();i++){
            preLeftRootArray[i] = preLeftRoot.get(i);
            inLeftRootArray[i] = inLeftRoot.get(i);
        }

        int[] preRightRootArray  =new int[preRightRoot.size()];
        int[] inRightRootArray  =new int[inRightRoot.size()];
        for(int i =0;i< inRightRoot.size();i++){
            preRightRootArray[i] = preRightRoot.get(i);
            inRightRootArray[i] = inRightRoot.get(i);
        }

        root.left = re(preLeftRootArray,inLeftRootArray);
        root.right = re(preRightRootArray,inRightRootArray);

        return root;
    }
}
