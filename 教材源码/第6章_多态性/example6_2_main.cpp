//example6_2_main.cpp: ��Point�Ĳ���
#include"example6_2.h"
int  main ()
{ 
	Point p1(5,10), p2(20,30),p3,p4;    //����4������
    p3=p1+p2;                          	//�൱��p3=p1.operator +(p2);���
    p4=p1-p2;                           //�൱��p4=operator - (p1,p2);���
    cout<<"P1=";
    p1.print();                         //���p1�����ֵ
    cout<<"P2=";
    p2.print();                         //���p2�����ֵ 
    cout<<"p3 = p1 + p2 is:";
    p3.print();                         //���p3=p1+p2�����ֵ
    cout<<"p4 = p1 - p2 is:";
    p4.print();                         //���p4=p1-p2�����ֵ
	return 0;
}
