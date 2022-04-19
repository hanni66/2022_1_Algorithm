package hw7_1;
public class MyHashTable {
	// 연결리스트 노드 구조
	private class Node {
		int key;
		Node link;
	}

	private Node[] table;				// 테이블
	private int m;						// 테이블 크기	
	private int n;						// 원소 수 
	private static final double A = 0.6180339887;	// 곱하기 방법에서 사용할 상수 

	// (1) 테이블 크기를 매개변수로 받아 공백 해시테이블을 생성
	public MyHashTable(int m) {
		table = new Node[m];
		n = 0;
		this.m = m;
	}

	// (2) 해시 함수 - 곱하기 방법을 이용해 key의 해시값을 계산 O(1)
	public int hash(int key) {
		// key를 이용해 해시값, 즉 해시테이블 인덱스를 계산해 리턴 
		return (int)(m*(key * A % 1));
	}

	// (3) 테이블에 key를 삽입 - key 중복 여부는 검사하지 않아도 됨. 평균 O(1)
	public void add (int key) {
		// key의 해시값을 구하여 그 위치의 연결리스트 맨 앖에 key값을 저장한 노드 삽입
		int value = hash(key);
		
		if (table[value] == null) {
			table[value] = new Node();
		} else {
			Node temp = table[value];
			while (temp.link != null) {
				temp = temp.link;
			}
			if (temp.key == key) {
				temp.key = key;
			} else {
				temp.link = new Node();
			}
		}
	}

	// (4) 적재율을 계산하여 리턴 O(1)
	public double getLoadFactor() {
		return n/m;
	}

	// (5) 테이블에서 key를 검색하여 존재하면 true 리턴 평균 O(1)
	public boolean contains(int key) {
		int index = hash(key);
		
		while (table[index] != null) {
			if (table[index] == null) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	// 과제 수행시 키 값이 올바른 위치에 삽입 되었는지 확인하기 위한 메소드
	public void printTable() {
		for(int i=0; i< table.length; i++) {
			System.out.print("table[" + i + "] = ");
			Node temp = table[i];
			while(temp != null) {
				System.out.print(temp.key + " ");
				temp = temp.link;
			}
			System.out.println();
		}
	}
}
