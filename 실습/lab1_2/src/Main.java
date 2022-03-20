public class Main {
	public static void main(String[] args) {
		System.out.println("lab1_2 : 김하은");
		
		// 원소 수가 2인 Reservation형 배열 생성
		Reservation[] array = new Reservation[2];
		
		// 예약번호 1, 시작 3, 종료 5인 Reservation 객체를 생성하여 첫번째 배열 원소로 지정
		array[0] = new Reservation(1, 3, 5);
		// 예약번호 2, 시작 1, 종료 6인 Reservation 객체를 생성하여 두번째 배열 원소로 지정 
		array[1] = new Reservation(2, 1, 6);
		// 반복문을 이용하여 각 예약의 번호, 시작시간, 종료시간과 길이를 출력
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i].toString());
		}
	}
}
