//example6_8.h���ڸ�����Complex������Ԫ��ʽ����ǰ׺"++"����׺"++"�����
#include <iostream.h>
class Complex                    		//������ Complex
{
private:
    float  real;
    float  imag;
public:
    Complex(float r=0, float i=0) ;
    void print();
    friend Complex operator ++ ( Complex &a);  
    								//��Ԫ���ص�Ŀ�����ǰ׺"++"���ṩһ�����ò���
	friend Complex operator ++ ( Complex &a,int);
	                                //��Ԫ���ص�Ŀ�������׺"++"��������һ��int����
};