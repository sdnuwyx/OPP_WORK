//example6_9.cpp: �����Ա������ʵ��
#include "example6_9.h"
Base::Base(int x)					//����Ĺ��캯��
{
	a=x; 
}
void Base::Print()        	//���庯��Print()Ϊ�麯��
{ 
	cout<<"Base::a="<<a<<endl; 
}
Derive::Derive(int x,int y):Base(x)	//������Ĺ��캯��
{
	a=y;					//�����ຯ����ֱ�ӷ��ʱ����ͬ����Ա
    Base::a*=2;			  	//�Լ̳е�ͬ�����ݳ�Ա�޸�
}
void Derive::Print()    //�˴���virtual����ʡ��
{
	Base::Print();            	//���ʻ����ͬ����Աǰ����׺��Base::
    cout<<"Derived::a="<<a<<endl;//���ʱ����е�ͬ����Ա
}
