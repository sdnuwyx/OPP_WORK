//example6_9.h: print()��������Ϊ�麯��
#include <iostream>
using namespace std;
class Base						//�������Base
{
public:
    Base(int x);				//����Ĺ��캯��
	virtual void Print();       //���庯��Print()Ϊ�麯��
    int a;					   	//����Ĺ������ݳ�Աa
};
class Derive:public Base	    //����һ������������Derive
{
public:
    int a;					  	//�����������ݳ�Աa��������ݳ�Աͬ��
    Derive(int x,int y);	 	//������Ĺ��캯��
    virtual void Print();       //�˴���virtual����ʡ��
};