//example7_01.cpp������ģ��ʾ��
#include<iostream>
using namespace std;
template<class T>                   			//����δ֪�������Ͳ���T��ʾ
T Max(T a,T b)                       			//��������ͬ���͵���ʽ����a��b�еĽϴ���
{	
	return a>b ?a :b ;                        
}
int main()
{   
	cout<<"Max(2,8) is "<<Max(2,8)<<endl;  		//��ʵ�ε�����int���Զ�ʵ����T
    cout<<"Max('2','8') is "<<Max('2','8')<<endl;		//��ʵ�ε�����char���Զ�ʵ����T
    return 0;
}
