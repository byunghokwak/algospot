import java.util.Scanner;

public class Main {
	static int map[][], sizeCache[][], pathCache[][], N;
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int tc = sc.nextInt();
    	for(int t=0; t<tc; t++) {
    		N = sc.nextInt();
    		
    		map = new int[N][N];
    		sizeCache = new int[N][N];
    		pathCache = new int[N][N];
    		
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<=i; j++) {
    				map[i][j] = sc.nextInt();
    			}
    		}
    		triPathCnt(0,0);
    		System.out.println(pathCache[0][0]);
    	}
    }    
    
    static int triPathCnt(int i, int j) {
    	
    	if(i >= N-1) {
    		pathCache[i][j] = 1;
    		return map[i][j];
    	}
    	
    	if(sizeCache[i][j] > 0) return sizeCache[i][j];
    	
    	int down = triPathCnt(i+1, j);
    	int rightDown = triPathCnt(i+1, j+1);
    	
    	sizeCache[i][j] = map[i][j] + Math.max(down, rightDown);
    	
    	if(down == rightDown) {
    		pathCache[i][j] = pathCache[i+1][j] + pathCache[i+1][j+1];
    	} else {
    		if(down > rightDown) {
    			pathCache[i][j] = pathCache[i+1][j];
    			
    		} else {
    			pathCache[i][j] = pathCache[i+1][j+1];
    		}
    	}
    	return sizeCache[i][j];
    }
}