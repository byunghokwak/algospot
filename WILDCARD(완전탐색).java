/*
 * 문제 : 알고스팟 wildcard

 * 유형 : dp
 * 접근법 : 내가 푼건 완전탐색으로 풀었음(n^2)
 * 책에서는 n^3으로 완전탐색 설명하고 dp로 n^2으로 설명함
 * 허나 그냥 완전탐색으로 해도 n^2임
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static char[] str, wildcard;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		List<String> files;
		for(int tc = 0; tc < T; tc++) {
			files = new ArrayList<String>();
			wildcard = sc.nextLine().toCharArray();
			n = sc.nextInt();
			sc.nextLine();
			for(int i=0; i<n; i++) {
				files.add(sc.nextLine());
			}
			Collections.sort(files, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			
			for(int j=0; j<files.size(); j++) {
				str = files.get(j).toCharArray();
				if(check(0,0)) {
					System.out.println(str);
				}
			}
		}
			
	}
	
	static boolean check(int wIdx, int strIdx) { 
		if(wIdx==wildcard.length-1 && wildcard[wIdx]=='*')
			return true;
		if(wIdx>=wildcard.length && strIdx>=str.length)
			return true;
		if(wIdx>=wildcard.length || strIdx>=str.length)
			return false;
		
		boolean result = false;
		if(wildcard[wIdx] == '*') {
			for(int next=0; next<=str.length-1; next++) {
				if(check(wIdx+1, strIdx+next)) {
					result = true;
				}
			}
		} else if(wildcard[wIdx] == '?' || (str[strIdx] == wildcard[wIdx])) {
			if(check(wIdx+1, strIdx+1)) {
				result = true;
			}
		} 
		return result;
	}
}
