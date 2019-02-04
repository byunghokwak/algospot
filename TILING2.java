import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int dp[];
	static final int x = 1000000007;
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int tc = sc.nextInt();
    	sc.nextLine();
    	for(int t=0; t<tc; t++) {
    		int N = sc.nextInt();
    		dp = new int[N+1];
    		Arrays.fill(dp, -1);
    		System.out.println(tiling2(N));
    	}
    }    
    
    static int tiling2(int n) {
    	if(n == 1 || n == 0) return 1;
    	if(dp[n] != -1) return dp[n];
    	return dp[n] = (tiling2(n-1) + tiling2(n-2))%x;
    }
}