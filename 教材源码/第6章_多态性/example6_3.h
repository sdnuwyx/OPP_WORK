//example6_3.h:��Array���������+=��++
#include<iostream.h>
class Array                       		//������ Array
{
private:
    int  *ptr;                    		//��̬����ռ��������Ԫ��
    int  size;                    		//������ʵ��Ԫ�ظ���
public:
    Array(int arraySize =10) ;       		//���캯��ԭ���������ṩĬ�ϲ���ֵ
    Array(const Array &);          		//�������캯��ԭ������
    ~Array();                     
    void print() ;                 		//�����������
    int getSize() const;            		//�õ�����Ԫ�ظ���            
    Array operator++();           		//���ص�Ŀ�����++���޲���
    Array &operator+=(Array &);   		//����˫Ŀ�����+=��ֻ��һ������
};