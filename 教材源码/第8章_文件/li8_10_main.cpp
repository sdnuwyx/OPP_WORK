//li8_10_main.cpp: ���崴���ļ��������ļ��ĺ�����������
#include <fstream.h>
#include "li8_10.h"
void CreateBiFile(char *filename)           			//����һ���������ļ�
{   ofstream out(filename);                			//���ļ�
    Student stu[3]={Student("B11041015","���ﺮ","��",92),
                 Student("B11041111","��������","��",95),
                 Student("B11050902","�׺��Ȱ���.����","Ů",98)};
    out.write((char *)stu,sizeof(Student)*3); 			//һ�����ļ���д��3����¼
    out.close();                        				//�ر��ļ�
}
void ReadBiFile(char *filename)           			//�Ӷ������ļ���ȡ��Ϣ���
{   Student stu[5];
    int i=0;
    ifstream in(filename);                			//���ļ�
	/*
    while (!in.eof())                  				//���ļ��������δ����ʶʱ
          in.read((char * )&stu[i++],sizeof(Student));       
               								//������ȡ��¼��������
    for (int j=0;j<i-1;j++) cout<<stu[j];    				//ʵ�ʼ�¼����Ϊi-1
*/
 while (!in.eof())      
{   in.read((char * )&stu[i],sizeof(Student)); 
    cout<<stu[i];
    i++;
}



    in.close();                       				//�ر��ļ�
}
int  main()
{    CreateBiFile("stu.dat");           				//���ú�����������ѧ����Ϣ���ļ�stu.dat
     ReadBiFile("stu.dat");            				//���ú�����ȡ�������ļ�stu.dat
     return 0;
}