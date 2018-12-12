//example5_09.cpp:  �������������ͬ����Ա
#include <iostream>
using namespace std;

class Base
{
public:
		Base(int x)
		{
			a = x;
    	}
    	void Print( )
    	{
			cout << "Base::a = " << a << endl; 
    	}
   	int a;
};

class Derived: public Base
{
public:
    	int a;
    	Derived(int x, int y): Base(x)	
    	{
			a = y;		    	//�������ڲ�ֱ�ӷ��ʵ���������Աa
       	Base::a *= 2 ;  	//���ʻ����ͬ����ԱҪʹ��Base::
    	}
    	void Print( )
    	{
			Base::Print( );  	//���ʻ����ͬ����ԱҪʹ��Base::
        	cout << "Derived::a = " << a << endl;
    	}
};

void f1(Base &obj)
{
		obj.Print( );    
}

void f2(Derived &obj)
{
		obj.Print( );    
}

int main( )
{
    	Derived d(200,300) ; 
 
		d.Print( );		    	//������������������ͬ������
    	d.a = 400;		    	//�ı���������������ͬ�����ݳ�Ա
    	d.Base::a = 500;     	//�ı�����е�ͬ�����ݳ�Ա
    	d.Base::Print( ) ;    	//���û����ͬ������
 
		Base *pb; 
    	pb = &d;
    	pb -> Print( );       	//����ָ����õ��ǻ����Print( )����

		f1(d);				//�������õ��õ��ǻ����Print( )����

		Derived *pd;
		pd = &d;
		pd -> Print( );		//������ָ����õ����������Print( )���� 
	
		f2(d);				//���������õ��õ����������Print( )����

		return 0;
}
