//li8_11.cpp�����ı��ļ�test.txt�ļ���ǰ����ַ�����
#include<iostream>
#include<fstream>
using namespace std;
int main()
{   fstream inout("d:\\test.txt", ios::in | ios::out);  	//��һ���ı��ļ����ɶ�д
    if (!inout)                           	//�ж��ļ��Ƿ�������
    {   cout<<"Cannot open input file.\n";
        return 0;
    }
    long e=5, i, j;
    char c1, c2;
    for(i=0, j=e-1; i<j; i++, j--)             	//���ƻ�����i��jλ���ϵ��ַ�����
    {   inout.seekg(i, ios::beg);
        inout.get(c1);
        inout.seekg(j, ios::beg);
        inout.get(c2);
        inout.seekg(i, ios::beg);
        inout.put(c2);
        inout.seekg(j, ios::beg);
        inout.put(c1);
    }
    inout.close();                       	//�ر��ļ�
	return 0;
}
