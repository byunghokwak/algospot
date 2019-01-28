/*
 * Algospot
 * 문제 : picnic
 * 유형 : 완전탐색
 * 
 */

import java.util.Scanner;

public class Main {
	static int N, M, ans, couple[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			couple = new int[2][M];
			ans=0;
			
			for(int i=0; i<M; i++) {
				couple[0][i] = sc.nextInt();
				couple[1][i] = sc.nextInt();
			}
			recursive(0, 0, 0);
			System.out.println(ans);
		}
	}
	static void recursive(int cplCnt, int idx, int cplChecked) {
		if(cplCnt==N)
			ans++;
		else if(idx>=M)
			return;
		
		for(int next=idx; next<M; next++) {
			int leftCpl = couple[0][next];
			int rightCpl = couple[1][next];
			
			if(((1<<leftCpl)&cplChecked)==0 && ((1<<rightCpl)&cplChecked)==0) {
				recursive(cplCnt+2, next+1, cplChecked|(1<<leftCpl)|(1<<rightCpl));
			}
		}
	}
}
