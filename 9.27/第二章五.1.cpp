//������c���Է��ĳ����д��c++���Է���Դ����


#include<iostream>
#include<stdlib.h>
using namespace std;
int add(int a,int b);
int main()
{
	int x,y,sum;
	cout<<"Please input x and y:"<<'\n';
	cin>>x;
	cin>>y;//�������x,y��ֵ
	sum=add(x,y);//���
	cout<<x<<"+"<<y<<"="<<sum<<'\n';
	system("pause");
	return 0;
}
int add(int a,int b)
{
	return (a+b);
}


