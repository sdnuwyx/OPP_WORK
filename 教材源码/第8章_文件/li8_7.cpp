//li8_7.cpp��ʹ��"<<"��������ļ���д���ݣ�ʹ��">>"��������ļ��ж�����ʾ��
#include<fstream>
#include <iostream>
using namespace std;
void CreateFile(char *s);
void ReadFile(char *s);
int main(  )
{   CreateFile("f1.txt");            		//����f1.txt�ļ�
    ReadFile("f1.txt");             		//��ȡf1.txt�ļ����ݲ�����ʾ������ʾ
	return 0;
}
void  CreateFile(char  *s)         		//����һ���ı��ļ�
{   ofstream outf (s);               	//�������������outf����s�ļ�
    if(! outf)                     		//�ж��ļ��Ƿ�������
    {   cout << "Cannot open the file\n";
        return ;
    }
    outf << 10 << " " << 71.2718;    		//���ļ���д��һ��������һ��ʵ��
    outf << "\"This is a short text file.\"\n"; 
    outf.close();                  		//�ر��ļ�
}
void ReadFile(char * s)             		//��ȡһ���ı��ļ�������
{   int i=0;                      		//���������ڴ����
    double d=0;
    char str[50];
    ifstream inf( s);                		//��������������inf����s�ļ�
    if(!inf)                       		//�ж��ļ��Ƿ�������
    {   cout << "Cannot open the file\n";
        return ;
    }
    inf >>i>>d;                   		//���ļ��ж����ݸ����ڴ����
    cout <<i<<" " <<d;             		//����Ļ����ڴ������ֵ
    inf.getline(str,50);              		//���ļ��ж������ո���ַ���
    cout<<str<<"\n";               	//����Ļ����ַ�����ֵ
    inf.close();
}
