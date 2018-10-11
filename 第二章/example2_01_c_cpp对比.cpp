

#include <iostream>
#include<stdio.h>
#include<stdlib.h>
using namespace std;

int main()
{
	int a;
	float f;
	char c;                           //定义变量c、a、f的值
	

	cin >> c >> a >> f;                //输入变量c、a、f的值
	a = a + c;
	f = f + 2 * a;

	cout << "c=" << c << "  a=" << a << "  f=" << f << endl;  	//输出变量c、a、f的值

	return 0;
}
