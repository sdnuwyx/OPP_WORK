//example6_7.h: ����Date�У�������������"<<"���������������">>"
#include <iostream.h>
class Date
{
	int year, month, day ;     			//���ݳ�ԱĬ��Ϊ��˽������
public :                     			//��һ��Ϊ��ͨ���캯������
    Date(int y=2011,int m=8,int d=30) ;      
    friend ostream & operator<<(ostream & out, const Date &);		//��Ԫ����������������"<<"
    friend istream & operator >> (istream & in, Date &); 		//��Ԫ�����������������">>"
};