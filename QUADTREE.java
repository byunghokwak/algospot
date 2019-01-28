/*
 * algospot 문제 : quadtree
 * 유형 : 분할정복
 * 핵심사항 : 분할하여 재조합 + iterator 개념 및 사용법
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static char[] str;
	static Iterator<Character> iter; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t = 0; t < T; t++) {
			ArrayList<Character> arr = new ArrayList<>();
			str = sc.nextLine().toCharArray();
			for(int i=0; i<str.length; i++)
				arr.add(str[i]);
			
			iter = arr.iterator();
			
			System.out.println(reverse());
		}
	}
	static StringBuilder reverse() {
		
		char head = iter.next();
		
		if(head=='b'||head=='w')
			return new StringBuilder().append(head);
		else {
			StringBuilder leftUpper = reverse();
			StringBuilder rightUpper = reverse();
			StringBuilder leftLower = reverse();
			StringBuilder rightLower = reverse();
			
			StringBuilder ret = new StringBuilder().append("x").append(leftLower)
					.append(rightLower).append(leftUpper).append(rightUpper);
			
			return ret;
		}
	}
}