// example7_19_Student.cpp��ѧ�����ʵ��
#include "example7_19_Student.h"
Student::Student()
{
	age=0;
}
//���캯��
Student::Student( string na , string id , string num , string  spec ,int ag)
{	name=na;
    ID=id;
    number=num;
	speciality=spec;
	age=ag;
}

Student::Student(const Student &per)           //�������캯�����ڴ�������ʱû���õ�
{
	name=per.name;
	ID=per.ID;
	number=per.number;
	speciality=per.speciality;
	age=per.age;
}
	
Student::~Student()                         //��������
{}
	   
string Student:: GetName()                   //��ȡ����
{
	return name;
}
string Student::GetID()                      //��ȡ���֤
{  
	return ID;
}
int Student::GetAge()                       //��ȡ����
{  
	return age;
}
string Student::GetSpec()                    //��ȡרҵ
{
	return speciality;
}
string Student::GetNumber()                 //��ȡѧ��
{
	return number;
}
void Student::Display()  const                  //���������Ϣ
{
	cout<<"��  ����"<<name<<endl;
	cout<<"���֤��"<<ID<<endl;
	cout<<"ѧ  �ţ�"<<number<<endl;
	cout<<"ר  ҵ��"<<speciality<<endl;	
	cout<<"��  �䣺"<<age<<endl<<endl;
}
void Student::Input()                      //��������
{
	cin.get();
	cout<<"������  ����";
	getline(cin,name);
	cin.get();
	cout<<"�������֤��";

	getline(cin,ID) ;
		cin.get();
	
	
	cout<<"����ѧ  �ţ�";

	
	getline(cin,number); 
		cin.get();
	cout<<"����ר  ҵ��";
	getline(cin,speciality) ;
	cout<<"������  �䣺";
	cin.get();
	cin>>age;

}
/*bool SearchStu( string na )         //��������ѯ
{
	bool flag=false;
	if( GetName().compare(na) == 0 )
		return true;
	else
	return false;
}*/
