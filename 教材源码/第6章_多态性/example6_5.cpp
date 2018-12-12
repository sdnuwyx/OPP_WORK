//example6_5.cpp�ļ�������example3_13.cpp,�����˸�ֵ�����������
#include <string>
#include <iostream>
using namespace std;
class Student
{
	char *specialty;
public:
    Student(char *pSpec = 0) ;      	
	Student (const Student &r);    
	~Student( );
    void Show( );
	Student & operator = (const Student &s);  //�����ӵ����ظ�ֵ���������
};
Student::Student( char *pSpec )       		//��ͨ���캯���Ķ���
{ 
	if( pSpec )
    {
		specialty = new char[strlen( pSpec ) + 1];
        strcpy(specialty,  pSpec);
    }
    else specialty = 0;
}
Student:: Student (const Student &r)          	//�������캯���Ķ���
{  
	if( r.specialty )
    {  
		specialty=new char[strlen( r.specialty ) + 1];
        strcpy(specialty,  r.specialty);
    }
    else
		specialty=0;
}
Student::~Student( )           		     //���������Ķ���
{ 
	if ( specialty )
		delete [ ]specialty;     	//specialty�Ĵ洢�ռ���new��������䣬����delete�ͷ�
}
void Student::Show()
{ 
	cout<< "specialty=" << specialty << '\n' ;  
}
Student & Student::operator = (const Student &s)//�����ӵ����ظ�ֵ������Ķ���
{
	if ( specialty ) delete [ ]specialty; 
    if( s.specialty )
    {
		specialty=new char[strlen(s.specialty ) + 1];
        strcpy(specialty,  s.specialty);
    }
    else 
		specialty=0;
	return *this;
}
int main( )
{ 
	Student zhang("computer");    		//������ͨ���캯��
    Student wang("LLL") ;         	//������ͨ���캯��
    wang=zhang;                      //��ֵ,���������ص�=�����
    zhang.Show();
    wang.Show();
	return 0;
}
