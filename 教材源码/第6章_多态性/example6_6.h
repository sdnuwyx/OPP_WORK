//example6_6.h������Matrix�г�Ա�������غ������������"()"
#include<iostream.h>
class Matrix                     		//���������
{
private:
    int  *m ;                    		//����m���붯̬�ռ��ž����Ԫ��
    int  row;                    		//���������
    int  col ;                    		//���������
public:
    Matrix(int, int);
    int & operator()(int,int);       		//���غ������������"()"
};