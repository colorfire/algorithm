package io.colorfire.algorithm;

/**
 * 动态规划算法
 * d(i)=min{ d(i-vj)+1 }，其中i-vj >=0，vj表示第j个硬币的面值;
 *
 * 参考: http://blog.csdn.net/u013445530/article/details/45645307
 *
 * @author colorfire on 17/3/11
 */
public class DynamicProgrammingDemo {

  public int compute(int cent) {
    int coin[] = {1, 3, 5}; // 硬币种类
    int sum = 11;
    int dp[] = new int[12]; // 钱包容量, 0不算, 所以从1开始

    dp[0] = 0;
    for (int i = 1; i <= sum; i++) dp[i] = i; // 重置所有子任务的状态

    for (int i = 1; i <= sum; i++) { // 计算钱包容量内所有达到指定金额的最优解
      for (int j = 0; j < 3; j++) {
        /*
        1. 如果要求的金额大于硬币金额, 并且当前解减去指定硬币金额的硬币数小于当前解, 则认为是最优解
         */
        if (i >= coin[j] && dp[i - coin[j]] + 1 < dp[i]) {
          dp[i] = dp[i - coin[j]] + 1;
        }
      }
    }

    return dp[cent]; // 返回硬币个数
  }

  public static void main(String[] args) {
    // 凑齐10元需要的硬币个数
    int cent = new DynamicProgrammingDemo().compute(11);
    System.out.println(cent);
  }
}
