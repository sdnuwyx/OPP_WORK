//example6_13.h: ����������Ķ���
#include<iostream>
using namespace std;
const double PI=3.1415;
class Shape                      		//���������� Shape
{
public: 
    virtual double area() const=0;   	//�������麯��
};
class Triangle: public Shape         	//����������������Triangle
{
public:
    Triangle(double b,double h):base(b),hight(h)
    {   }
    double area() const ;           	//���������ж��崿�麯����ʵ�ִ���
private:
    double base,hight;
};
class Rectangle:public Shape        	//��������������Rectangle
{
public:
    Rectangle(double h,double w):hight(h),width(w)
    {   }
    double area() const ;          		//���������ж��崿�麯��
private:
    double hight,width;
};
class Circle:public Shape           	//��������Բ��Circle
{
public:
    Circle(double r):radius(r)
    {   }
    double area() const ;          		//���������ж��崿�麯��
private:
    double radius;
};