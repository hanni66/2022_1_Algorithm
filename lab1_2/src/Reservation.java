// 예약번호, 시작시간, 종료시간 정보를 갖는 예약을 표현하는 클래스 
public class Reservation {
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
