//example6_13_main.cpp: �������봿�麯������ͼ������е�ʹ��
#include "example6_13.h"
int main() 
{ 
	Shape *ptr[3];     	        		//����������ָ������
    ptr[0]=new Triangle(2.5,10.0);		//����Triangle��Ķ���
    ptr[1]=new Rectangle(15, 22);		//����Rectangle��Ķ���
    ptr[2]=new Circle(3.0);         		//����Circle��Ķ���
    cout<<"The area of Triangle(2.5,10.0) is:";
    cout<<ptr[0]->area()<<endl;    		//����Triangle���area()����
    cout<<"The area of Rectangle(15, 22) is:";
    cout<<ptr[1]->area()<<endl;   		//����Rectangle���area()����
    cout<<"The area of Circle(3.0); is:";
    cout<<ptr[2]->area()<<endl;    		//����Circle���area()����
	return 0;
}
