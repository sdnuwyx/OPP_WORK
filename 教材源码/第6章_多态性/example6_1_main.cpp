//example6_1_main.cpp: ��Student�Ĳ���
#include"example6_1.h" 
int main()
{ 
	Student  s1;               	//������Student��һ�����󣬵��õ�1�����캯�� 
    Student  s2("ѧ��",22) ;   	//������Student�Ķ��󣬵��õ�2�����캯�� 
    s1.print();					//����s1�������ذ汾1���������print()
    s2.print();                	//����s2�������ذ汾1���������print()
    s2.print(2008) ;           	//����s2�������ذ汾2���������print(int)
	return 0;
}
