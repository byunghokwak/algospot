import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

		static int N, M;
		static double comb[][];
	    public static void main(String[] args) {
	    	
	    	Scanner sc = new Scanner(System.in);
	    	
	    	int tc = sc.nextInt();
	    	
	    	comb = new double[1001][1001];
	    	for(int i=0; i<=1000; i++) {
	    		combination(1000, i);
	    	}
	    	
	    	for(int t=0; t<tc; t++) {
	    		N = sc.nextInt();
	    		M = sc.nextInt();
	    		
	    		int boundary = calBoundary();
	    		BigDecimal ans = new BigDecimal(1);
	    		
	    		if(N <= M) {
	    			System.out.println(String.format("%.11f", ans));
	    			continue;
	    		}
	    		
	    		ans = new BigDecimal(0);
	    		
	    		if(boundary == -1) {
	    			System.out.println(String.format("%.11f", ans));
	    			continue;
	    		}
	    		
	    		for(int r=0; r<boundary; r++) {

	    			BigDecimal c = new BigDecimal(comb[M][r]);
	    			
	    			if(r==0) {
	    				ans = ans.add(new BigDecimal(Math.pow(0.25, M)));
	    			} else {
	    				
	    				BigDecimal notRain = new BigDecimal(0.25);
	    				BigDecimal rain = new BigDecimal(0.75);
	    				
	    				BigDecimal tmp1 = notRain.pow(M-r);;
	    				BigDecimal tmp2 = rain.pow(r);
	    				
	    				BigDecimal tmp3 = c.multiply(tmp1.multiply(tmp2));
	    				
	    				ans = ans.add(tmp3);
	    			}
//	    			System.out.println(r+" : "+ans);
	    		}
	    		System.out.println(String.format("%.11f", new BigDecimal(1).subtract(ans)));
	    	}
	    }    
	    
	    static int calBoundary() {
	    	
	    	// 전체 기간 모두 비가 안 오는 경우(1 이동)로 시작
	    	int distance = M;
	    	int cnt = 0;
	    	
	    	while(distance < N) {
	    		// -1(비 안 오는날 빼고) + 2(비 오는날로 계산)
	    		distance += 1;
	    		
	    		//비 오는 날 횟수 계산
	    		cnt++;
	    	}
	    	
	    	if(cnt > M) return -1;
	    	
	    	return cnt;
	    }
	    
	    static double combination(int n, int r) {
	    	if(n==r || r==0) {
	    		comb[n][r] = 1;
	    		return 1;
	    	}
	    	
	    	if(comb[n][r] > 0) return comb[n][r];
	    	
	    	comb[n][r] = combination(n-1, r) + combination(n-1, r-1);
	    	
	    	return comb[n][r];
	    }
	
}