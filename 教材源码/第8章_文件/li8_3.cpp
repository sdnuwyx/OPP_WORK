//��8_3.cpp����setf() ��������״̬��־
#include<iostream>
using namespace std;
int main()
{   cout.setf(ios::showpos);         		//����ǰ�����+
    cout.setf(ios::scientific);         		//�ÿ�ѧ���������ʵ��
    cout << 123 << "��" << 123.23 << "\n" ;
	return 0;
}
