//example7_03.cpp����ģ��Ķ���
#include<iostream>
using namespace std;
template < class T1 , class T2 >         		//��ģ�����õ��������Ͳ���
class Myclass
{   public:
        Myclass( T1 xx , T2  yy );
        void Print()              		//��ģ���г�Ա���������������ڶ���
        {   cout<<"x="<<x<<",y="<<y<<endl;  
        }
    private:
        T1 x;
        T2 y;
};
template<class T1,class T2>         		//��ģ���г�Ա���������������ⶨ��
Myclass<T1,T2>::Myclass(T1 xx,T2 yy)
{   x=xx;
    y=yy;
}
int main()
{   Myclass<int ,char> obj(10,'a');           //Myclass<int��char>Ϊģ����
    obj.Print();
    return 0;
}
