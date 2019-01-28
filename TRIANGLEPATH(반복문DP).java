/*
 * 문제 : algospot : TRIANGLEPATH
 * 유형 : dp
 */

import java.util.Scanner;

public class Main {
	static int n, map[][], dp[][], ans;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			ans=0;
			n = sc.nextInt();
			map = new int[101][101];
			dp = new int[101][101];
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=i; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=i; j++) {
					if(j==1) 
						dp[i][j] = dp[i-1][j]+map[i][j];
					else
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + map[i][j];
				}
			}
			for(int j=1; j<=n; j++) {
				ans = Math.max(ans, dp[n][j]);
			}
			
			System.out.println(ans);
		}
	}
}