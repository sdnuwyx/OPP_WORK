//example6_8.cpp���ڸ�����Complex������Ԫ��ʽ����ǰ׺"++"����׺"++"�����
#include "example6_8.h"
Complex::Complex(float r, float i) 
{
	real=r;  
    imag=i;
}
void Complex::print()
{
	cout << real;                                
    if( imag != 0 ) 
    {   if( imag > 0 ) cout << " + " ;                  
        cout << imag << " i " ;  
    }
    cout << endl;                            
}
Complex operator ++ ( Complex &a)     
{ 
	++a.real;
    ++a.imag;
    return a;
}

Complex operator ++ ( Complex &a,int)   
{ 
	Complex temp(a);          	                  //����a������ʱ����temp��	
    a.real++ ;                  	                  //��a�����ʵ������1
    a.imag++ ;                                 	    //��a������鲿����1
    return temp;                	                  //����temp�����ı���ǰ��a
} 

