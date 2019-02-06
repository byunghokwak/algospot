import java.util.Scanner;

public class Main {
	static int N, M;
	static double cache[][];
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int tc = sc.nextInt();
 		cache = new double[1001][2001];
 		
    	for(int t=0; t<tc; t++) {
    		N = sc.nextInt();
    		M = sc.nextInt();
    		
    		for(int i=0; i<=1000; i++) {
    			for(int j=0; j<=2000; j++) {
    				cache[i][j] = -1;
    			}
    		}
    		System.out.println(String.format("%.10f", clime(0, 0)));
    	}
    }    
    
    static double clime(int days, int climbed) {
    	
    	if (days == M) return climbed >=N ? 1 : 0;
    	
    	if(cache[days][climbed] != -1) return cache[days][climbed];
    	
    	cache[days][climbed] = 0.25*clime(days+1, climbed+1) + 0.75*clime(days+1, climbed+2);
    	
    	return cache[days][climbed];
    }

}