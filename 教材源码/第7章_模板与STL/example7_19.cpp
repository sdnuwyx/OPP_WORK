// example7_19.cpp����������������ͨ����
#include<iostream>
#include<vector>
#include<algorithm>
#include "example7_19_Student.h"
using namespace std;


void menu();
void OutputStu(vector<Student>& stu_vec );
void InputStu(vector<Student>& stu_vec );

int main()
{
	vector <Student> stu_vec;
	int choice;
	string na;

	do
	{
		menu();
		cout<<"Please input your choice:";
		cin>>choice;
		if( choice>=0 && choice <= 3 )         
			switch(choice)
		{
			case 1:InputStu(stu_vec);break;
			case 2:cout<<"Input the name searched"<<endl;
			       cin.get();
				   getline(cin,na);
                   cin.get();
				   vector<Student>::iterator p;
				   for(p=stu_vec.begin();p!=stu_vec.end();p++)
					{
						if( ((*p).GetName()).compare(na) == 0 )
						{
							(*p).Display();
							break;
						}

				   }
				   if (p==stu_vec.end())
					   cout<<"���޴��ˣ�\n";
				   break;
			case 3:OutputStu(stu_vec); break;
			default:break;
		}
	}while(choice);
	return 0;
}
				   

void menu()
{
	cout<<"**********1.¼����Ϣ**********"<<endl;
	cout<<"**********2.��ѯ��Ϣ**********"<<endl;
	cout<<"**********3.�����Ϣ**********"<<endl;
	cout<<"**********0.��    ��**********"<<endl;
}

void OutputStu( vector<Student>& stu_vec)               //�����������Ԫ��
{
	int count=0;
	
	vector<Student>::const_iterator p;
	for(p=stu_vec.begin();p!=stu_vec.end();p++)
	{
		(*p).Display();
		count++;
	}
	cout<<"ѧ��������="<<count<<endl;
}

void InputStu( vector<Student>& stu_vec )                //�����������Ԫ��
{
	char ch;
	Student x;
	do
	{   
		x.Input();
		stu_vec.push_back(x);
		cout<<"����������(Y or N )"<<endl;
		cin.get();
		cin.get(ch);
	}while(ch=='Y');
}
