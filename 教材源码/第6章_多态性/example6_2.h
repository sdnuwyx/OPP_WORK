//example6_1.h: ��Point�Ķ���
#include<iostream.h>
class Point                              	//������Point
{public: 
    Point(int a=0, int b=0);                 //���캯��
    void print();                         	//��ӡ����
    Point operator + ( Point p1);           //�Գ�Ա������ʽ��������� +
    friend Point operator - (Point p1,Point p2); 	//����Ԫ��ʽ���������-
private:
    int x;    
    int y;  
};