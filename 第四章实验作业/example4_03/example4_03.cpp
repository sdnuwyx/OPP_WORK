#include <iostream>//包含系统文件
#include<stdlib.h>
using namespace std;
#include "example4_03_Circle.h"//包含自定义头文件
int main()
{
	Circle c1(3.5),c2;//定义两个类的对象,c2的半径用默认值
	cout<<"area of c1="<<c1.Area()<<",circumference of c1="<<c1.Circumference()
		<<endl;
	cout<<"area of c2="<<c2.Area()<<",circumference of c2="<<c2.Circumference()
		<<endl;
	system("pause");
	return 0;
}