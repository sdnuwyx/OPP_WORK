//example6_3_main.cpp:��Array���������+=��++��Ĳ���
#include"example6_3.h"
int main()
{
	Array a(5), b(10), c(8);        		//����3��������󣬳��Ȳ�ͬ
    cout<<"original a array:"<<endl; 
    a.print();                    		//���ԭʼ��a����
    cout<<"original b array:"<<endl;  
    b.print();                    		//���ԭʼ��b����
    cout<<"original c array:"<<endl;  
    c.print();                    		//���ԭʼ��c����
    a+=b;                       		//��ʽ�������ص�"+="��������൱��a.operator+=(b);���
    cout<<"after added with b ,a array:"<<endl;
    a.print();                    		//����ı���a����
    c.operator +=(b);             		//��ʽ�������ص�"+="��������൱��c+=b;���
    cout<<"after added with b ,c array:"<<endl;
    c.print();                   		//����ı���c����
    ++b;                        		//��ʽ�������ص�ǰ׺"++"��������൱��b.operator++();���
    cout<<"after ++, b array:"<<endl;
    b.print();                   		//����ı���b����
	return 0;
}
