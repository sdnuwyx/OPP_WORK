//example6_12.h: ���麯���Ķ���
#include <iostream>
using namespace std;
class Point
{
public:
    virtual void Draw ()=0; //���崿�麯��
};
class Line:public Point
{
public:
    void Draw();           //��������Line�ж���Draw����������ʵ�ִ���
 };
class Circle:public Point
{
public:
    void Draw();           //��������Circle�ж���Draw����������ʵ�ִ���
};
