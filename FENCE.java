/*
 * 문제 : algospot fence
 * 접근법 : 분할정복
 * 주의사항 : baseCase, idx 관리
 * 
 */
import java.util.Scanner;

public class Main {
	static int arr[], N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(solve(0, N-1));
		}
	}
	
	static int solve(int l, int r) {
		// 1.l==r 같은 경우(블록 길이 :1)
		if(l==r) return arr[l];

		// 2. 분할정복 후 중간 기준 좌/우 둘 중 max값 받아오기
		int mid = (l+r)/2;
		int ret = Math.max(solve(l,mid), solve(mid+1,r));
		
		// 3. 중간기준 좌/우 최대값 vs 중간포함 직사각형 최대값
		int nowHeight = Math.min(arr[mid], arr[mid+1]);
		
		int moveL = mid;
		int moveR = mid+1; 
		ret = Math.max(ret, nowHeight*2);
		
		// 다음 idx확인 시 +1/-1로 접근해서 확인함. 미리 idx 증가시켜서 접근하면 배열idx 초과 문제 해결하기 어려움
		while(moveL>l || moveR<r) {
			if(moveL>l && (moveR==r || (arr[moveL-1] > arr[moveR+1]))) {
				moveL--;
				nowHeight = Math.min(nowHeight, arr[moveL]);
			} else {
				moveR++;
				nowHeight = Math.min(nowHeight, arr[moveR]);
			}
			ret = Math.max(ret, (moveR-moveL+1)*nowHeight);
		}
		return ret;
	}
}