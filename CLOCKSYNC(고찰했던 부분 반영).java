import java.util.Scanner;

public class Main {
	static int clock[], ans, INF = 235434534, SWITCH=10, CLOCK=16,	
			   rotation[][] = {
					   {0, 1, 2},
					   {3, 7, 9, 11},
					   {4, 10, 14, 15},
					   {0, 4, 5, 6, 7},
					   {6, 7, 8, 10, 12},
					   {0, 2, 14, 15},
					   {3, 14, 15},
					   {4, 5, 7, 14, 15},
					   {1, 2, 3, 4, 5},
					   {3, 4, 5, 9, 13} };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			ans = INF;
			clock = new int[CLOCK];
			for(int i=0; i<CLOCK; i++) {
				clock[i] = sc.nextInt()%12;
			}
			
			find(0,0);
			
			if(ans==INF)
				ans=-1;
			System.out.println(ans);
		}
	}
	static void find(int rotCnt, int swtch) {
// �� ������ �����µ� ������ Ʋ�� �信���� �Ʒ� 1���� 2���� �ٲ�  �����̾��� ������.
// ����ġ 9�� ������ 10������ �Ѿ�� �ѵ� �ɸ��µ� ���⼭ 9������ �ߴ� ����� üũ�ؾ��ϴµ� �̸� üũ�� ���� ���ߴ� �κ����� ���� �߻��߾���.
		
		// 1. ��� 12�� üũ
		int allDirect=0;
		for(int i=0; i<CLOCK; i++) {
			allDirect+=clock[i];
		}
		if(allDirect==0) {
			if(rotCnt<ans)
				ans = rotCnt;
			return;
		}
		
		// 2. ȸ���� �Ǵ� ����ġ �ε��� �ʰ� ����
		if(rotCnt>ans || swtch==SWITCH)
			return;
			
		for(int cnt=0; cnt<4; cnt++) {
			find(rotCnt+cnt, swtch+1);
			rotate(swtch);
		}
	}
	static void rotate(int idx) {
		int linkClockCnt = rotation[idx].length;
		for(int i=0; i<linkClockCnt; i++) {
			clock[rotation[idx][i]] = (clock[rotation[idx][i]]+3)%12; 
		}
	}
}