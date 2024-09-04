import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		// 외부에서 파일을 읽어들임
		//Scanner sc = new Scanner(new File("스도쿠검증.txt"));
        Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수를 받아옴
		int T = sc.nextInt();
		
		// label -> 반복문
		tcloop: for (int tc = 1; tc <= T; tc++) {
			
			// 스도쿠를 받기위한 배열을 생성
			// 1~9까지의 숫자로 주어짐 -> int형 배열로
			// 9*9배열선언
			int[][] sudoku = new int[9][9];
			
			// 9*9 배열에 각각 값을 받아들임
			for (int i = 0; i < sudoku.length; i++) {
				for (int j = 0; j < sudoku.length; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			//입력값이 문제없는것을 확인
			
			//요구사항 : 1. 같은 줄에 1~9까지의 숫자를 한번씩만 넣어야함
			// -> 가로로 탐색시 1~9까지 중복된 숫자가 없어야함
			// -> 세로로 탐색시 1~9까지 중복된 숫자가 없어야함
			// -> 3*3격자 안에서 중복이 없어야함
			
			// 스도쿠에 겹치는 숫자가 없을경우 1을 출력
			// 그렇지 않을경우 0을 출력
			
			
			for (int i = 0; i < sudoku.length; i++) {
				
				//SET : 중복을 허용하지 않는다
				// HashSet -> add method -> boolean 삽입에 성공했을경우 true / 실패는 false
				
				// 가로 체크용 해쉬셋을 만들어줌
				HashSet<Integer> widthSet = new HashSet<>();
				
				// 세로 체크용 해쉬셋을 만들어줌
				HashSet<Integer> verticalSet = new HashSet<>();
				
				for (int j = 0; j < sudoku.length; j++) {
					// i, j를 인덱스로 가로 세로 진행가능
					// true 삽입완료 / false 실패
					if (!widthSet.add(sudoku[i][j])) {
						// add처리가 실패했을경우 -> 0을 출력
						System.out.println("#" + tc + " " + 0);
						continue tcloop;
						// 이후의 처리를 모두 skip
					}
					
					if (!verticalSet.add(sudoku[j][i])) {
						// add처리가 실패했을경우 -> 0을 출력
						System.out.println("#" + tc + " " + 0);
						continue tcloop;
						// 이후의 처리를 모두 skip
					}
				}
			}
			
			// 가로세로의 체크는 완료
			
			// 3*3 격자를 체크하기
			HashSet<Integer> check = new HashSet<>();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (!check.add(sudoku[i][j])) {
						// add처리가 실패했을경우 -> 0을 출력
						System.out.println("#" + tc + " " + 0);
						continue tcloop;
						// 이후의 처리를 모두 skip
					}
				}
			}
			
			
			// 여기까지 성공했으면 스도쿠이므로 1을 출력
			System.out.println("#" + tc + " " + 1);
			
		}
		
		sc.close();
		
		
	}
}
