/*
 * algospot 문제 : LIS
 * 유형 : DP
 * 
 * 접근법 : 비재귀로 구현
 * 
 */

import java.util.Scanner;

public class Main {
	static int n, list[], lis[], ans;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			ans=0;
			n = sc.nextInt();
			list = new int[n];
			lis = new int[n];
			
			for(int i=0; i<n; i++)
				list[i] = sc.nextInt();
			
			lis[n-1] = 1;
			for(int i=n-2; i>=0; i--) {
				int max = 0;
				for(int j=i+1; j<n; j++) {
					if(list[i] < list[j]) {
						if(max<lis[j]) max = lis[j];
					}
				}
				lis[i] = 1+max;
				if(ans<lis[i]) ans = lis[i];
			}
			System.out.println(ans);
		}
	}
}