import java.util.Scanner;

public class Main {
	static int cache[], N, arr[];
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int tc = sc.nextInt();
    	sc.nextLine();
    	for(int t=0; t<tc; t++) {

    		String input = sc.nextLine();
    		N = input.length();
    		arr = new int[N];
    		cache = new int[N];
    		for(int i=0; i<N; i++) {
    			arr[i] = input.charAt(i)-'0';
    			cache[i] = -1;
    		}
    		System.out.println(pi(0));
    	}
    }    
    
    static int pi(int start) {
    	
    	if(start == N) return 0;
    	if(cache[start] != -1) return cache[start];
    	
    	// 메모이제이션
    	cache[start] = Integer.MAX_VALUE;
    	
    	for(int next=3; next<6; next++) {
    		
    		if(start+next>N) break;
    		int temp = pi(start+next);
    		if(temp == Integer.MAX_VALUE) {
    			cache[start] = Math.min(cache[start], temp);
    		} else {
    			cache[start] = Math.min(cache[start], classify(start, next) + pi(start+next));
    		}
    	}
    	
    	if(cache[start] == Integer.MAX_VALUE) {
    		System.out.println(start);
    	}
    	return cache[start];
    }
    
    static int classify(int s, int len) {

    	// 1. 모두 같은 경우
    	boolean allEqual = true;

    	for(int i=s; i<s+len-1; i++) {
    		if(arr[i] != arr[i+1]) {
    			allEqual = false;
    			break;
    		}
    	}
    	if(allEqual) return 1;
    	
    	// 2. 등차수열
    	boolean progessive = true;
    	for(int i=s; i<s+len-2; i++) {
    		int d1 = arr[i+2] - arr[i+1];
    		int d2 = arr[i+1] - arr[i];
    		
    		if(d1 != d2){
    			progessive = false;
    		}
    	}
    	
    	// 등차수열 공차 절대값 1인 경우
    	if(progessive && Math.abs(arr[s]-arr[s+1]) == 1) return 2;
    	
    	boolean alternative = true;
    	for(int i=s; i<s+len-2; i++) {
    		if(arr[i] != arr[i+2]){
    			alternative = false;
    		}
    	}
    	
    	// 번갈아 가며 같은 값
    	if(alternative) return 4;
    	// 등차수열 공차 절대값 2 이상
    	if(progessive) return 5;
    	
    	return 10;
    }
}