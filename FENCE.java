/*
 * ���� : algospot fence
 * ���ٹ� : ��������
 * ���ǻ��� : baseCase, idx ����
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
		// 1.l==r ���� ���(��� ���� :1)
		if(l==r) return arr[l];

		// 2. �������� �� �߰� ���� ��/�� �� �� max�� �޾ƿ���
		int mid = (l+r)/2;
		int ret = Math.max(solve(l,mid), solve(mid+1,r));
		
		// 3. �߰����� ��/�� �ִ밪 vs �߰����� ���簢�� �ִ밪
		int nowHeight = Math.min(arr[mid], arr[mid+1]);
		
		int moveL = mid;
		int moveR = mid+1; 
		ret = Math.max(ret, nowHeight*2);
		
		// ���� idxȮ�� �� +1/-1�� �����ؼ� Ȯ����. �̸� idx �������Ѽ� �����ϸ� �迭idx �ʰ� ���� �ذ��ϱ� �����
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