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
		pc1.overRideMethod();	// �ν��Ͻ��� �θ�Ŭ�������� ChildOneClass ���� �������̵��� �޼ҵ尡 ȣ���
		
		ParentClass pc2 = new ChildTwoClass();
		pc2.overRideMethod();	// �ν��Ͻ��� �θ�Ŭ�������� ChildTwoClass ���� �������̵��� �޼ҵ尡 ȣ���
		*/
		
		// ��Ȳ: ȸ�� 10���� ���µ� ������� �󸶳� ���� �� �� ���� ��
		
		// ��Ӽ��� Ȱ������ ���� ���
		ChildOneClass arrCOC[] = new ChildOneClass[10];
		ChildTwoClass arrCTC[] = new ChildTwoClass[10];	// ������� �󸶳� ���� �𸣴� ���� 10������ ���� �� �ۿ� ���� -> ����, ��û�� �޸� ����
		
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
		// ȸ�� �����ϱ� ����, ����Ǵ� �޸� ����, ������ �� �迭�� null ������ ������ ���ܼ� ��µ� �����
		
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
		
		// ��Ӽ��� Ȱ���� ���
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
		// ȸ�� �����ϱ� ����, ����Ǵ� �޸� ����, �迭 ���� ���
		
		for (int i = 0; i < arrPar.length; i++) {
			if (arrPar[i] instanceof ChildOneClass) {	// instanceof: ��ü�� �ش� Ŭ������ ��ü���� Ȯ�����ִ� ���
				ChildOneClass cOne = (ChildOneClass)arrPar[i];
				cOne.OneMethod();
			}
			else if (arrPar[i] instanceof ChildTwoClass) {
				ChildTwoClass cTwo = (ChildTwoClass)arrPar[i];
				cTwo.TwoFunc();
			}
		}	// ��½ÿ��� null ����� �ʿ� ����, �ڷᰡ ���� ������� ��µ� �� ��Ӽ��� Ȱ���ϴ� ��찡 �� ��
		
	//	ChildOneClass cOne = (ChildOneClass)arrPar[0];
	//	cOne.OneMethod();
		
		
		
	}

}
