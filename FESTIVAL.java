import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, L;
	static double costPerDay[], cal[], ans;
	static final double MAX = 242345236;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			ans=MAX;
			N = sc.nextInt();
			L = sc.nextInt();
			costPerDay = new double[N];
			cal = new double[N];
			
			for(int i=0; i<N; i++)
				costPerDay[i] = sc.nextDouble();
			
			for(int i=L-1; i<N; i++) {
				Arrays.fill(cal, 0);
				for(int j=0; j<=i; j++)
					cal[i] += costPerDay[j];
				
				for(int j=i+1; j<N; j++) {
					cal[j] = cal[j-1]-costPerDay[j-i-1]+costPerDay[j];
				}
				
				for(int j=i; j<N; j++) {
					cal[j]/=(double)(i+1);
					if(ans>cal[j])
						ans=cal[j];
				}
				
			}
			System.out.printf("%.11f",ans);
			System.out.println();
		}
	}
}
