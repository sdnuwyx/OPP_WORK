<<<<<<< HEAD
#ifndef _STUDENT
#define _STUDENT
#include<iostream>
#include<string>
using namespace std;
#define SIZE 80
class Student
{
	char *name;
	char ID[19];
	char number[10];
	char speciality[20];
	int age;
	static int count;//ʵ����Ч��ѧ������,С�ڵ��ڶ���ĸ���
public:
	Student ();
	Student(char *na,char *id,char *num,char *spec,int ag);
	Student(const Student &per);
	~Student();
	char* Getname()const;//���Զ���Ϊ����Ա����
    char* GetID();//���ɶ���Ϊ����Ա����
	char* Getnumber();//�����Զ���Ϊ����Ա����
	char* GetSpec();//�����Զ���Ϊ����Ա����
	int GetAge()const;
	void Display()const;
	void Input();
	void Insert();
	void Delete();
	static int GetCount();//�����ӵľ�̬��Ա����

};
=======
#ifndef _STUDENT
#define _STUDENT
#include<iostream>
#include<string>
using namespace std;
#define SIZE 80
class Student
{
	char *name;
	char ID[19];
	char number[10];
	char speciality[20];
	int age;
	static int count;//ʵ����Ч��ѧ������,С�ڵ��ڶ���ĸ���
public:
	Student ();
	Student(char *na,char *id,char *num,char *spec,int ag);
	Student(const Student &per);
	~Student();
	char* Getname()const;//���Զ���Ϊ����Ա����
    char* GetID();//���ɶ���Ϊ����Ա����
	char* Getnumber();//�����Զ���Ϊ����Ա����
	char* GetSpec();//�����Զ���Ϊ����Ա����
	int GetAge()const;
	void Display()const;
	void Input();
	void Insert();
	void Delete();
	static int GetCount();//�����ӵľ�̬��Ա����

};
>>>>>>> fe0dfa62bd6c2a663b7eaa63a8727bcacc04741a
#endif