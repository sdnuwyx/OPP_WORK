//example6_11.h���麯����ͬ����������
#include<iostream>
using namespace std;
class base                       		//������������� base
{
public: 
    virtual void f1()               		//����Ϊ�麯��
    {
		cout<<"f1 function of base \n";	   
    } 
    virtual void f2()               		//����Ϊ�麯����
    {
		cout<<"f2 function of base \n"; 	   
    } 
   void f3()                    		//����Ϊ��ͨ����
    { 
	   cout<<"f3 function of base \n"; 	   
    } 
}; 
class derive:public base             		//���������������� derive
{
 public:
    void f1()                    		//�����麯������
    {
		cout<<"f1 function of derive \n"; 	   
    } 
    void f2 (int x)                 		//�ı������ͬ������,�������麯������
    { 
		cout<<"f2 function of derive \n"; 	   
    } 
    void f3()                     		//��Ϊ��ͨ������ͬ������
    { 
		cout<<"f3 function of derive \n";	   
    } 
};
