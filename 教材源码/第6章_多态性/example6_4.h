//example6_4.h���ڸ�����Complex������Ԫ��ʽ����"+"��ǰ׺"++"�����
#include <iostream.h>
class Complex                    		//������ Complex
{
private:
    float  real;
    float  imag;
public:
    Complex(float r=0, float i=0) ;
    void print();
    friend Complex operator + (const Complex &a, const Complex &b);  
    								//��Ԫ����"+"��������ʽ����	    
    friend Complex operator ++ ( Complex &a);  
    								//��Ԫ���ص�Ŀ�����ǰ׺"++"���ṩһ�����ò���
};