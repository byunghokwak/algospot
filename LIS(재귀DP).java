/*
 * algospot ���� : LIS
 * ���� : ��� DP
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
			
			// ��� idx ���� �������� ������� LIS ���ؾ� �ϹǷ� for�� �������
			// for�� ���� cal(0)�� �ߴٰ� ��������..
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