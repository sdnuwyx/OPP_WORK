//example9_05_person.h

//��Ԥ�����������Ϊ�˼���VC6����
#ifdef WIN32
#pragma warning (disable: 4514 4786)
#endif

#ifndef _PERSON
#define _PERSON

#include<string>
using namespace std;


class Date
{
protected:
	int year;
	int month;
	int day;
public:
	void Set( int y, int m, int d );
	int GetYear( );
	int GetMonth( );
	int GetDay( );
};


class Person
{
protected:
	string name;							//����
	string number;							//���
	char sex;								//�Ա�		
	Date birthday;							//��������
	string speciality;						//רҵ
	string researchTopic;					//����
	string academicTitle;					//ְ��
	int type;								//���
public:
	Person( string na , string num , char s, int y, int m, int d , string sp, string re, string ac, int ty );
											//���캯��
	bool operator<( Person ob )const;		//����<���㣬set����Ҫ��Ԫ��֮������ù�ϵ	
	string GetName( );						//��������
	string GetNumber( );					//���ر��
	char GetSex( );							//�����Ա�
	Date GetBirth( );						//���س�������
	string GetSpec( );						//����רҵ
	string GetResearch( );					//�����о�����
	string GetAcademic( );					//����ְ��
	int GetType( );							//�������
};

#endif

