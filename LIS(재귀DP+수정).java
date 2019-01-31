import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int cache[], N, arr[];
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int tc = sc.nextInt();
    	
    	for(int t=0; t<tc; t++) {
    		N = sc.nextInt();
    		arr = new int[N];
    		cache = new int[N+1];
    		for(int i=0; i<N; i++) {
    			arr[i] = sc.nextInt();
    		}
    		Arrays.fill(cache, -1);
    		
    		// S[-1]은 가상으로 추가해준 값이기 때문에 최종 반환 값에서 빼 줘야 함
    		// 즉 -1을 제거한 배열에 대한 LIS를 구해야함
    		System.out.println(lis(-1)-1);
    	}
    }    
    
    static int lis(int start) {
    	
    	if(cache[start+1] != -1) return cache[start+1];
    	
    	cache[start+1] = 1;
    	
    	for(int next=start+1; next<N; next++) {
    		if(start==-1 || arr[start] < arr[next]) {
    			
    			cache[start+1] = Math.max(cache[start+1], lis(next)+1);
    			
    			// [실수한 부분]
    			// 아래 max 값은 1을 넣어주면 해당 인덱스에서의 lis 최대값으로 갱신관리 되지 않고
    			// 가장 마지막에 호출 된 값으로 lis 나옴
    			// cache[start+1] = Math.max(1, lis(next)+1);
    		}
    	}
    	return cache[start+1];
    }
}