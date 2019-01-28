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
// 답 오류가 났었는데 이유가 틀린 답에서는 아래 1번과 2번을 바꾼  로직이었기 때문임.
// 스위치 9번 누르고 10번으로 넘어가면 한도 걸리는데 여기서 9번까지 했던 결과를 체크해야하는데 이를 체크를 하지 못했던 부분으로 오답 발생했었음.
		
		// 1. 모두 12시 체크
		int allDirect=0;
		for(int i=0; i<CLOCK; i++) {
			allDirect+=clock[i];
		}
		if(allDirect==0) {
			if(rotCnt<ans)
				ans = rotCnt;
			return;
		}
		
		// 2. 회전수 또는 스위치 인덱스 초과 여부
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