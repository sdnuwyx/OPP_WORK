//将下面c语言风格的程序改写成c++语言风格的源程序


#include<iostream>
#include<stdlib.h>
using namespace std;
int add(int a,int b);
int main()
{
	int x,y,sum;
	cout<<"Please input x and y:"<<'\n';
	cin>>x;
	cin>>y;//输入变量x,y的值
	sum=add(x,y);//求和
	cout<<x<<"+"<<y<<"="<<sum<<'\n';
	system("pause");
	return 0;
}
int add(int a,int b)
{
	return (a+b);
}


