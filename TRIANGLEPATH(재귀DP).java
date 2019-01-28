import java.util.Scanner;

public class Main {
	static int cache[][], N, map[][];
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int tc = sc.nextInt();
    	
    	for(int t=0; t<tc; t++) {
    		
    		N = sc.nextInt();
    		
    		map = new int[N][N];
    		cache = new int[N][N];
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<=i; j++) {
    				map[i][j] = sc.nextInt();
    				cache[i][j] = 0;
    			}
    		}
    		System.out.println(cal(0,0));
    	}
  
    }    
    
    static int cal(int x, int y) {
    	
    	if(x>=N || y>=N) return 0;
    	if(cache[x][y] > 0) return cache[x][y];
    	
    	int result = map[x][y] + Math.max(cal(x+1,y), cal(x+1,y+1));
    	cache[x][y] = result;
    	
    	return cache[x][y];
    }
}