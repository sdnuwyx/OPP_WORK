//example6_10.h����������������Ϊ�麯��
#include <iostream>
using namespace std;
class A
{
public:
    virtual  ~A();                		//��������������Ϊ�麯��
};
class B: public A                  		//���幫��������
{
public:
    B(int i);  
    ~B();                       		//����������������Զ�Ϊ�麯��
private:
    char *buffer;
};
