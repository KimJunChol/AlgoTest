import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("res/풍선2.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] arr = new int[n][m];
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			int dr[] = {-1, 1, 0, 0};
			int dc[] = {0, 0, -1, 1};
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					int sum = 0;
					sum += arr[i][j];
					
					for (int k = 0; k < dc.length; k++) {
						int nextR = i + dr[k];
						int nextC = j + dc[k];
						
						if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) {
							continue;
						}
						
						sum += arr[nextR][nextC];
						
						max = Math.max(max, sum);
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);
			
			
		}

	}

}
