package main;

import cls.ChildOneClass;
import cls.ChildTwoClass;
import cls.ParentClass;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		ParentClass pc = new ParentClass();
		pc.overRideMethod();
		
		ChildOneClass coc = new ChildOneClass();
		coc.overRideMethod();
		
		ChildTwoClass ctc = new ChildTwoClass();
		ctc.overRideMethod();
		*/
		
		/*
		ParentClass pc1 = new ChildOneClass();
		pc1.overRideMethod();	// 인스턴스는 부모클래스지만 ChildOneClass 에서 오버라이드한 메소드가 호출됨
		
		ParentClass pc2 = new ChildTwoClass();
		pc2.overRideMethod();	// 인스턴스는 부모클래스지만 ChildTwoClass 에서 오버라이드한 메소드가 호출됨
		*/
		
		// 상황: 회원 10명이 오는데 어느쪽이 얼마나 올지 알 수 없을 때
		
		// 상속성을 활용하지 않은 경우
		ChildOneClass arrCOC[] = new ChildOneClass[10];
		ChildTwoClass arrCTC[] = new ChildTwoClass[10];	// 어느쪽이 얼마나 올지 모르니 각각 10개씩을 잡을 수 밖에 없음 -> 복잡, 엄청난 메모리 낭비
		
		arrCOC[0] = new ChildOneClass();
		arrCTC[0] = new ChildTwoClass();
		arrCTC[1] = new ChildTwoClass();
		arrCTC[2] = new ChildTwoClass();
		arrCTC[3] = new ChildTwoClass();
		arrCOC[1] = new ChildOneClass();
		arrCTC[4] = new ChildTwoClass();
		arrCOC[2] = new ChildOneClass();
		arrCTC[5] = new ChildTwoClass();
		arrCTC[6] = new ChildTwoClass();
		// 회원 구분하기 복잡, 낭비되는 메모리 생김, 심지어 각 배열에 null 상태인 변수도 생겨서 출력도 어려움
		
		/*
		for (int i = 0; i < arrCOC.length; i++) {
			if(arrCOC[i] != null) {
				arrCOC[i].overRideMethod();
			}
		}
		
		for (int i = 0; i < arrCTC.length; i++) {
			if(arrCTC[i] != null) {
				arrCTC[i].overRideMethod();
			}
		}
		*/
		
		// 상속성을 활용한 경우
		ParentClass arrPar[] = new ParentClass[10];
		
		arrPar[0] = new ChildOneClass();
		arrPar[1] = new ChildTwoClass();
		arrPar[2] = new ChildTwoClass();
		arrPar[3] = new ChildTwoClass();
		arrPar[4] = new ChildTwoClass();
		arrPar[5] = new ChildOneClass();
		arrPar[6] = new ChildTwoClass();
		arrPar[7] = new ChildOneClass();
		arrPar[8] = new ChildTwoClass();
		arrPar[9] = new ChildTwoClass();
		// 회원 구분하기 용이, 낭비되는 메모리 없음, 배열 전부 사용
		
		for (int i = 0; i < arrPar.length; i++) {
			if (arrPar[i] instanceof ChildOneClass) {	// instanceof: 객체가 해당 클래스의 객체인지 확인해주는 기능
				ChildOneClass cOne = (ChildOneClass)arrPar[i];
				cOne.OneMethod();
			}
			else if (arrPar[i] instanceof ChildTwoClass) {
				ChildTwoClass cTwo = (ChildTwoClass)arrPar[i];
				cTwo.TwoFunc();
			}
		}	// 출력시에도 null 고려할 필요 없음, 자료가 넣은 순서대로 출력됨 등 상속성을 활용하는 경우가 더 편리
		
	//	ChildOneClass cOne = (ChildOneClass)arrPar[0];
	//	cOne.OneMethod();
		
		
		
	}

}
