/*
 * algospot 문제 : LIS
 * 접근 : 재귀 DP
 */

import java.util.Scanner;

public class Main {
	static int n, list[], dp[], ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			ans=0;
			n = sc.nextInt();
			list = new int[n];
			dp = new int[n];
			for(int i=0; i<n; i++) 
				list[i] = sc.nextInt();
			
			// 모든 idx 마다 시작점을 기반으로 LIS 구해야 하므로 for문 해줘야함
			// for문 없이 cal(0)만 했다가 개삽질함..
			for(int i=0; i<n; i++) 
				ans = Math.max(ans, cal(i));
			
			System.out.println(ans);
		}
	}
	
	static int cal(int start) {
		if(dp[start]!=0) return dp[start];

		dp[start] = 1;
		for(int next=start+1; next<n; ++next) {
			if(list[start] < list[next]) {
				dp[start] = Math.max(dp[start], cal(next)+1);
			}
		}
		return dp[start];
	}
}