import java.util.Scanner;

public class Main {
	static int N, map[][], visited[][], result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=0; t<tc; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					visited[i][j] = -1;
				}
			}
			result = dfs(0,0);
			String ans = result==0 ? "NO":"YES";

			// result���� int�� �ʰ��ؼ� ������ ���� ���� ����. ���� no�� 0�ۿ� ������ ��Ȯ�� ���� �������ش�.			
//			String ans = result>0 ? "YES":"NO";
			System.out.println(ans);	
		}
	}
	static int dfs(int x, int y) {
		
		if(x>=N || y>=N) return 0;
		if(x==N-1 && y==N-1) return 1;
		if(visited[x][y]!=-1) return visited[x][y];
		
		int down = dfs(x+map[x][y], y);
		int right = dfs(x, y+map[x][y]);
		
		visited[x][y] = down+right; 
		return visited[x][y];
	}
}