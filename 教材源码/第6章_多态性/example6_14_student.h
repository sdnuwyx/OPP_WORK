//example6_14_student.h
#include<iostream.h>
#include<fstream.h>
#include<string.h>

class Person
{
protected:
	char *name;
	char sex;
	int age;
public:
	Person( );
	Person( char *na , char s , int a);
	~Person( );
};

class Student: virtual public Person
{
protected:
	char speciality[20];
	char number[16];
public:
	Student( );
	Student( char *na , char s, int a, char * spec, char * num);
	~Student( );
	Student & operator = (Student &); //���ظ�ֵ�������
	operator char * ();				  //����ת�����������
	operator char ();				  //����ת�����������
	operator int ();				  //����ת�����������
    friend ostream & operator<<(ostream &,const Student & );  //��Ԫ����������������"<<"	
    friend istream & operator >> (istream &,Student &); 	  //��Ԫ�����������������">>"
};


