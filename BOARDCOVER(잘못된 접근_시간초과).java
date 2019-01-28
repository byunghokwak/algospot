/*
 * Algospot
 * 문제 : picnic
 * 유형 : 완전탐색 (시간초과, 중복 카운트 문제)
 * 해결법 : 특정한 순서대로 답을 생성하도록 강제해야함 : 빈 칸 중에서 가장 위, 그 중에서도 가장 왼쪽에 있는 칸을 처음 채우는 방식
 * 
 */

import java.util.Scanner;

public class Main {
	static int  dx[] = {0,1,0,1,1,1,1,1}, dy[] = {1,0,1,1,0,1,0,-1};
	
	static int N, M, ans, takePossible; 
	static char map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			takePossible=0;
			ans=0;
			sc.nextLine();
			for(int i=0; i<N; i++) {
				map[i] = sc.nextLine().toCharArray();
				for(int j=0; j<M; j++) {
					if(map[i][j]=='.')
						takePossible++;
				}
			}
			
			if(takePossible%3==0)
				ans = recursive(0);
			System.out.println(ans);
		}
	}
	static int recursive(int idx) {
		if(isAllFill()) {
			//System.out.println("ans");
			return 1;
		}
		
		int ret=0;
		boolean nextPossible=false;
		for(int next=idx; next<N*M; next++) {
			int x = next/M;
			int y = next-x*M;
			
			if(map[x][y]=='.') {
				for(int i=0; i<7; i+=2) {
					if(check(x+dx[i], y+dy[i]) && check(x+dx[i+1], y+dy[i+1])) {
						map[x][y]='@';
						map[x+dx[i]][y+dy[i]]='@';
						map[x+dx[i+1]][y+dy[i+1]]='@';
						nextPossible=true;
						print();
						ret+=recursive(next+1);
						map[x][y]='.';
						map[x+dx[i]][y+dy[i]]='.';
						map[x+dx[i+1]][y+dy[i+1]]='.';
					}
				}
				if(!nextPossible)
					break;
			}
		}
		return ret;
	}
	static boolean isAllFill() {
		boolean check = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='.') {
					check = false;
				}
			}
		}
		return check;
	}
	static boolean check(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<M && map[x][y]=='.')
			return true;
		else
			return false;
	}
	
	static void print() {
		System.out.println("------------");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
