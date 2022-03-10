import java.util.*;

public class hw1_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("hw1_1 : 김하은");
		int[] array = {-10, -20, 30, 40, 50, 60, 70, 80, 90, 100, 10, 20};
		
		// 1. 하한 입력
		System.out.print("하한 입력(0~11) : ");
		int lb = sc.nextInt();
		
		// 2. 상한 입력
		System.out.print("상한 입력(0~11) : ");
		int ub = sc.nextInt();
		
		// 3. 출력
		System.out.print("출력 = ");
		iterativeArrayPrint(array, lb, ub);
		
		// 4. 합 구하기 
		int sum = recursiveArraySum(array, lb, ub);
		System.out.print("합 = " + sum);
		
		sc.close();
	}
	
	private static void iterativeArrayPrint(int[] array, int lb, int ub) {
		if (lb == ub) {
			System.out.print(array[lb]);
		} else {
			for (int i=lb; i<ub; i++) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}
	
	private static int recursiveArraySum(int[] array, int lb, int ub) {
		if (lb > ub) {
			return 0;
		} 
		return array[lb] + recursiveArraySum(array, lb+1, ub);
	}
}
