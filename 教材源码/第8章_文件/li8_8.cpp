//li8_8.cpp:����get( )��put( )����ʵ�ֽ��ı��ļ��ĸ���
#include <fstream>
#include <iostream>
using namespace std;
int main()
{   ifstream ifile("d:\\abc.txt");    	//�򿪱����Ƶ�Դ�ļ�abc.txt�����ļ���������D�̽���
    if(!ifile)                   		//�ж��ļ��Ƿ�������
    {   cout<<"abc.txt cannot be openned!"<<endl;
        return;
    }
    ofstream ofile("d:\\xyz.txt");      //��d�̸�Ŀ¼�½���Ŀ���ļ�xyz.txt
    if(!ofile)                     		//�ж��ļ��Ƿ�������
    {   cout<<"xyz.txt cannot be openned!"<<endl;
        return;
    }
    char ch;
    while(ifile .get(ch))            		//��Դ�ļ��ж���һ���ַ�������ch
        ofile.put(ch);             		//������ch��ֵд��Ŀ���ļ�
    ifile. close();                 		//�ر�Դ�ļ�
    ofile.close();                 		//�ر�Ŀ���ļ�
	return 0;
}