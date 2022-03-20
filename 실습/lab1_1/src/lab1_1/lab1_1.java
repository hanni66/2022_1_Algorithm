package lab1_1;
import java.util.*;

public class lab1_1 {
	public static void main(String[] args) {
		System.out.println("lab1_1 : 김하은");
		
		// 1. 사용자로부터 정수 n을 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수값 입력 : ");
		int n = sc.nextInt();
		
		// 2. 반복문을 사용해 출력한다.
		System.out.print("반복 출력 = ");
		iterativePrint(n);
		
		// 3. 재귀를 이용해 출력한다.
		System.out.print("재귀 출력 = ");
		recursivePrint(n);
		
		sc.close();
	}
	
	private static void iterativePrint(int n) {
		if (n > 0) {
			for (int i=1; i<=n; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		} else {
			System.out.println("");
		}
	}
	
	private static void recursivePrint(int n) {
		if (n > 0) {
			recursivePrint(n-1);
			if (n >= 1) {
				System.out.print(n + " ");
			}
		} else {
			System.out.print("");
		}
		
	}
}
