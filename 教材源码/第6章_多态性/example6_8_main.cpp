//example6_8_main.cpp:�ڸ�����Complex��ʵ��ǰ׺"++"����׺"++"�����ʵ��
#include "example6_8.h"
int main()
{
	Complex c1(1.5, 2.5), c2(5, 10), c3;
    cout<<"original c1 is:   ";
    c1.print();
    cout<<"original c2 is:   ";
    c2.print();
    c3=++c2;                 	//�˾��൱��c3=operator ++(c2)�����õ���ǰ׺++
    cout<<"after c3=++c2;  c2 is:   ";
    c2.print();
    cout<<"after c3=++c2;  c3 is:   ";
    c3.print();
    c3=c1++;                    //�˾��൱��c3=operator ++(c1,0)�����õ��Ǻ�׺++
    cout<<"after c3=c1++;  c1 is:   ";
    c1.print();
    cout<<"after c3=c1++;  c3 is:   ";
    c3.print();
	return 0;
}
