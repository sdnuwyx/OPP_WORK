//example6_6.cpp��ʵ����Matrix�г�Ա����
#include"example6_6.h"
Matrix::Matrix(int r, int c)
{
	row=r;
    col=c;
    m=new int[row * col];      		//���붯̬�ռ��ž����Ԫ��
    for(int i=0; i<r*c; i++)   		//��ʼ������
        *(m+i)=i;
}
int & Matrix::operator() (int r, int c) 
{ 
	return (*(m+r*col+c));  
}                              		//���ؾ����r��c��Ԫ������
