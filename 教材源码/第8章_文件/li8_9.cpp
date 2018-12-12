//li8_9.cpp����write()��read()�������ж������ļ��Ķ�д
#include<iostream.h>
#include<fstream.h>
#include<string.h>
void CreateBiFile(char *s);
void ReadBiFile(char *s);
int main()
{   CreateBiFile("test.dat");    	//�����������ļ�test.dat
    ReadBiFile("test.dat");       	//��ȡ�������ļ�test.dat�е����ݲ����
	return 0;
}
void CreateBiFile(char *s)        			//�����������ļ�
{   ofstream out(s);             			//����������out�����ļ���׼�����ļ�д������
    if(!out)                    			//����ļ��Ƿ�������
    {   cout<<"Cannot open output file.\n";
        return ;
    }
    double num=98.64;          
    char str[]="This is a test of read and write\n";
    out.write((const unsigned char *)&num,sizeof(double)); 
                            			//дһ��doubleֵ
    out.write(str,strlen(str));        			//�����ļ�д��һ���ַ���
    out.close();                  			//�ر��ļ�
}
void ReadBiFile(char *s)           			//��ȡ�������ļ�������
{   ifstream in(s);                			//����������in�����ļ���׼�����ļ�����
    if(! in)                      			//����ļ��Ƿ�������
    {   cout<<"Cannot open input file.\n";
        return ;
    }
    double num;
    char str[80]="";               			//��ʼ���ַ��������������������������ַ�ֵ
    in.read((unsigned char *)&num,sizeof(double)); 
            							//�ļ����ݶ���double����
    in.read(str,40);                			//�ļ����ݶ����ַ�����
    cout<<num<<' '<<str;          			//������ļ��л��ֵ�ı���
    in.close();                    			//�ر��ļ�
}
