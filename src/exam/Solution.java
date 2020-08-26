package exam;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public int numWays(int n) {
    //     if(n==0) return 1;
    //     return getCurrentFromPrevious(n)%1000000007;

    // }

    // public int getCurrentFromPrevious(int curr){
    //     if(curr==1) return 1;
    //     if(curr==2) return 2;
    //     return getCurrentFromPrevious(curr-1)+getCurrentFromPrevious(curr-2);
    // }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(1000));
    }
    public int numWays(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    // public int numWays(int n) {
    //     int num_money = n;
    //     if(num_money<=0) return 1;
    //     if(num_money==1) return 1;
    //     if(num_money==2) return 2;
    //     BigInteger[] bigIntegers = new BigInteger[num_money];
    //     bigIntegers[0] = new BigInteger("1");
    //     bigIntegers[1] = new BigInteger("2");
    //     for(int i =2; i<num_money;i++){
    //         bigIntegers[i] = bigIntegers[i-1].add(bigIntegers[i-2]);
    //     }
    //     return bigIntegers[num_money-1].intValue()%1000000007;
    // }


}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
