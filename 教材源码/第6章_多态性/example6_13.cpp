//example6_13.cpp: ���麯�����������ʵ��
#include "example6_13.h"
double Triangle::area() const 
{ 
	return 0.5*base*hight;   
}
double Rectangle::area() const 
{ 
	return hight*width;   
}
double Circle::area() const 
{ 
	return PI*radius*radius;   
}