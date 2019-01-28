import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static long NEGINF = -2147483647;
	static long A[], B[];
	static int aLen, bLen, cache[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=0; t<tc; t++) {
			
			aLen = sc.nextInt();
			bLen = sc.nextInt();
			
			A = new long[aLen];
			B = new long[bLen];
			
			cache = new int[101][101];
			
			for(int i=0; i<=100; i++) {
				Arrays.fill(cache[i], -1);
			}
			
			for(int i=0; i<aLen; i++)
				A[i] = sc.nextInt();
			for(int i=0; i<bLen; i++)
				B[i] = sc.nextInt();
	
			System.out.println(jlis(-1,-1)-2);
		}
	}
	
	static int jlis(int idxA, int idxB) {
		
		if(cache[idxA+1][idxB+1]!=-1) return cache[idxA+1][idxB+1];

		long a = idxA==-1 ? NEGINF : A[idxA];
		long b = idxB==-1 ? NEGINF : B[idxB];
		
		long max = Math.max(a, b);
		
		int ret = 2;
		
		for(int nextA = idxA+1; nextA<aLen; nextA++) {
			if(max<A[nextA])
				ret = Math.max(ret, jlis(nextA, idxB)+1);
		}
		
		for(int nextB = idxB+1; nextB<bLen; nextB++) {
			if(max<B[nextB])
				ret = Math.max(ret, jlis(idxA, nextB)+1);
		}
		
		cache[idxA+1][idxB+1] = ret;
		return ret;
	}
}
