//example6_1.h: ��Student�Ķ���
#include<iostream> 
#include<string>
using namespace std;
class Student                   	//������ Student
{  
	char  name[20];
    int no;
public:
    Student();                    	//���캯�����ذ汾1���޲���
    Student(char *sname, int n); 	//���캯�����ذ汾2��������
    void  print();                	//����������ذ汾1���޲���
 	void  print(int n);          	//����������ذ汾2��������
};
