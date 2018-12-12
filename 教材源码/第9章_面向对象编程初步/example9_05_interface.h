//example9_05_interface.h
#ifndef _INTERFACE
#define _INTERFACE

#include "example9_05_person.h"
#include <set>

class Interface
{
protected:
	set<Person> pe;									//���ݼ�
public:
	Interface( );									//���캯��
	void Display( );								//���������Ϣ
	void Run( );									//���������幦��
	void Output( );									//���������Ϣ
    void PrintOne( set<Person>::iterator p );		//����������ݼ�¼
	void Insert( );									//��������
	void Delete( );									//ɾ������
	void ReadFile( );								//���ļ��ж�ȡ����
	void Search( );									//�����ݼ��в�������
	void Save( );									//�����ݱ��浽�ļ�
};

#endif

