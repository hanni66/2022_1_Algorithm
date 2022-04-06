public class Main {
	public static void main(String[] args) {
		System.out.println("hw4_1 : 김하은");
		// 1) 크기가 n인 예약 배열을 생성 (n=10)
		int n = 10;
		Reservation[] array = new Reservation[n];
		int startTime = 0;				// 시작시간 정보를 갖는 변수 
		int endTime = 0;				// 종료시간 정보를 갖는 변수

		// 2) 예약 번호는 1, 2, 3..., 시작시간, 종료시간은 랜덤 값인 예약 객체를 n개 생성하여 배열에 저장
		for(int i=0; i<array.length; i++) {
			startTime = (int)(Math.random()*5)+1; // 시작 시간에 랜덤 값을 줌 (1~5)
			endTime = (int)(Math.random() * (6-(startTime+1)+1)) + (startTime+1); // 종료시간에 랜덤 값을 줌 (시작시간+1 ~ 6)

			array[i] = new Reservation(i+1, startTime, endTime);

			// 3) n개의 예약 각각에 대해 시작시간, 종료시간, 길이를 출력
			System.out.println(array[i].toString());
		}

		// 4) 예약 배열을 길이 오름차순으로 정렬하는 정렬 메소드 호출
		reservationSort(array);

		// 5) 정렬된 n개의 예약 각각에 대해 시작시간, 종료시간, 길이를 출력
		System.out.println("길이 오름차순 정렬 결과 = ");
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i].toString());
		}
	}

	// Reservation형 배열을 매개변수로 받아 예약 길이 (1~5시간)를 기준으로 오름차순 정렬 - 시간복잡도(O(n))
	public static void reservationSort(Reservation[] list) {
		// 계수 정렬 이용
		int[] counting = new int[6];  // 시간단위로 순서를 저장할 배열
		Reservation[] result = new Reservation[list.length];   // 정렬이 된 배열 

		// list의 값을 index로 하는 counting 배열 값 1을 증가시킴.
		for(int i=0; i<list.length; i++) {
			counting[list[i].getLength()] += 1;
		}

		// 누적 합을 더해준다.
		for(int i=1; i<counting.length; i++) {
			counting[i] += counting[i-1];
		}

		// i 번째 원소를 인덱스로 하는 counting 배열을 1 감소 시킨 뒤 counting 배열의 값을 인덱스로 해 정답 배열에서 값을 저장한다.
		for(int i=list.length-1; i>=0; i--) {
			int value = list[i].getLength();
			counting[value]--;
			result[counting[value]] = list[i];
		}
		
		// 정렬이 된 배열로 만드는 작업 
		for(int i=0; i<list.length; i++) {
			list[i] = result[i];
		}
	}
}

// 예약번호, 시작시간, 종료시간 정보를 갖는 예약을 표현하는 클래스 
class Reservation {
	// private 인스턴스 변수 
	private int id;			// 예약 번호
	private int startTime;	// 시작시간
	private int endTime;	// 종료시간

	// 예약 번호, 시작시간, 종료시간을 매개변수로 받아 초기화 하는 생성자
	public Reservation(int id, int startTime, int endTime) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getLength() {
		return endTime-startTime;
	}

	@Override
	public String toString() {
		return id + " " + startTime +"시~" + endTime +"시 " + getLength() + "시간" ;
	}
}
