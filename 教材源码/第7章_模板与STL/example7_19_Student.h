// example7_19_Student.h��ѧ����Ķ���
#ifndef _STUDENT
#define _STUDENT
#include<iostream>
#include<string>
#include<vector>
using namespace std;
#define SIZE 80
class Student
{
	string name;                     //����
	string ID;                     //���֤
	string number;                 //ѧ��
	string speciality;                //רҵ
	int age;                         //����
public:
	Student();                         //�޲ι��캯��
	Student( string na , string id , string num , string  spec ,int ag);  //���ι��캯��
	Student(const Student &per);          //�������캯��
	~Student();                        //��������
    string GetName();                   //��ȡ����
	string GetID();                      //��ȡ���֤
	string GetNumber();                 //��ȡѧ��
	string GetSpec();                    //��ȡרҵ
	int GetAge();                       //��ȡ����
	void Display() const;                      //��ʾѧ����Ϣ
	void Input();                        //����ѧ����Ϣ
	bool Insert( );   
//	bool SearchStu( string na )   ;
};
#endif
