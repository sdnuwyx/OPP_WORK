//example6_14_interface.h
#include "example6_14_student.h"
const int N = 2;        //����N��ֵ���Ը���ʵ�ʱ����Ҫ����
class Interface
{
protected:
	Student st[N];
	int num;			//ѧ����Ϣ����
public:
	Interface( );		//ѧ����Ϣϵͳ����
	void Browse( );		//���ѧ����Ϣ
	void Run( );		//ϵͳ����
	void Input( );		//����ѧ����Ϣ
	void Sort( );		//����������ѧ����Ϣ
	void Statistic( );	//���Ա�ͳ��ѧ����Ϣ
	bool Search( );		//��������ѯѧ����Ϣ
};

