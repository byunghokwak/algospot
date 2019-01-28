/*
 * Algospot
 * 문제 : boardcover
 * 유형 : 완전탐색
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
				ans = recursive();
			System.out.println(ans);
		}
	}
	static int recursive() {
		int x=-1, y=-1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='.') {
					x=i;
					y=j;
					break;
				}
			}
			if(y!=-1) break;
		}
		
		if(y==-1) return 1;
		
		int ret=0;
		
		for(int i=0; i<7; i+=2) {
			if(check(x+dx[i], y+dy[i]) && check(x+dx[i+1], y+dy[i+1])) {
				map[x][y]='@';
				map[x+dx[i]][y+dy[i]]='@';
				map[x+dx[i+1]][y+dy[i+1]]='@';
				//print();
				ret+=recursive();
				map[x][y]='.';
				map[x+dx[i]][y+dy[i]]='.';
				map[x+dx[i+1]][y+dy[i+1]]='.';
			}
		}
		return ret;
	}
	static boolean check(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<M && map[x][y]=='.')
			return true;
		else
			return false;
	}
}
