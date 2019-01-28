import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static String w,s;
	static List<String> ansList;
	static int cache[][];
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	int tc = sc.nextInt();
    	sc.nextLine();
    	for(int t=0; t<tc; t++) {
    		ansList = new ArrayList<String>();


    		
    		w = sc.nextLine();
    		int n = sc.nextInt();
    		sc.nextLine();
    		
    		String strArr[] = new String[n];
    		for(int i=0; i<n; i++) {
    			strArr[i] = sc.nextLine();
    		}
    		
    		for(int i=0; i<n; i++) {
    			s = strArr[i];
        		cache = new int[101][101];
        		for(int x=0; x<101; x++) {
        			for(int y=0; y<101; y++) {
        				cache[x][y] = -1;
        			}
        		}
    			if(check(0,0)==1) {
    				ansList.add(s);
    			}
    		}
    		
			Collections.sort(ansList);
			for(int cnt=0; cnt<ansList.size(); cnt++) {
				System.out.println(ansList.get(cnt));
			}
    	}

    }
    
    static int check(int wIdx, int sIdx) {
    	
    	if(cache[wIdx][sIdx] != -1) return cache[wIdx][sIdx];
    	
    	while((wIdx<w.length() && sIdx<s.length()) &&
    			(w.charAt(wIdx) == '?' || w.charAt(wIdx) == s.charAt(sIdx))) {
    		wIdx++;
    		sIdx++;
    	}
    	
    	if(wIdx==w.length()) {
    		if(sIdx==s.length()) {
    			cache[wIdx][sIdx] = 1;
    		} else {
    			cache[wIdx][sIdx] = 0;
    		}
    		return cache[wIdx][sIdx];
    	}
    	
    	cache[wIdx][sIdx] = 0;
    	
    	if(w.charAt(wIdx) == '*') {
    		for(int next=0; sIdx+next<=s.length(); next++) {
    			if(check(wIdx+1, sIdx+next) == 1) {
    				cache[wIdx][sIdx] = 1;
    				return 1;
    			}
    		}
    	}
    	return cache[wIdx][sIdx];
    }
    
}