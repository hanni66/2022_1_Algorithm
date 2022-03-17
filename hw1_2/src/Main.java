public class Main {
	public static void main(String[] args) {
		System.out.println("hw1_2 : 김하은");
		// 크기가 n인 예약 배열을 생성 (n=10)
		int n = 10;
		Reservation[] array = new Reservation[n];
		
		int startTime = 0;				// 시작시간 정보를 갖는 변수 
		int endTime = 0;				// 종료시간 정보를 갖는 변수
		int count[] = new int[5];		// 예약 갯수를 세기 위해 크기가 5인 배열 생성 
		
		for(int i=0; i<array.length; i++) {
			startTime = (int)(Math.random()*5)+1; // 시작 시간에 랜덤 값을 줌 (1~5)
			endTime = (int)(Math.random() * (6-(startTime+1)+1)) + (startTime+1); // 종료시간에 랜덤 값을 줌 (시작시간+1 ~ 6)
			
			array[i] = new Reservation(i+1, startTime, endTime);
			// 출력문 
			System.out.println(array[i].toString());
			// count 배열에 값 넣어줌 
			count[(endTime-startTime - 1)] += 1;
		}
		//  count 배열 출력 
		for(int i=0; i<count.length; i++) {
			System.out.println(i+1 + "시간 = " + count[i]);
		}
	}
}

// 예약번호, 시작시간, 종료시간 정보를 갖는 예약을 표현하는 클래스 
class Reservation {
	// private 인스턴스 변수 
	private int id;
	private int startTime;
	private int endTime;
	
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
	
	@Override
	public String toString() {
		return id + " " + startTime +"시~" + endTime +"시 " + (endTime-startTime) + "시간" ;
	}
}
