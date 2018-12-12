//example6_14_interface.cpp
#include "example6_14_interface.h"
#include <string.h>
#include <iostream.h>
Interface::Interface( )
{
	num = 0;
}
void Display( )
{
	cout<<"\n**********0.��    ��**********" << endl;
	cout << "**********1.¼����Ϣ**********" << endl;
	cout << "**********2.��ѯ��Ϣ**********" << endl;
	cout << "**********3.�����Ϣ**********" << endl;
	cout << "**********4.��������**********" << endl;
	cout << "**********5.ͳ����Ϣ**********" << endl;
}
void Interface::Run( )
{
	int choice;
	do
	{
		Display( );
		cout << "\n���������ѡ��:";
		cin >> choice;
		switch ( choice )
		{
		case 0 :
			break;
		case 1 :
			Input( );
			break;
		case 2 :
			Search( );
			break;
		case 3 :
			Browse( );
			break;
		case 4 :
			Sort( );
			break;
		case 5 :
			Statistic( );
			break;
		}
		
	} while (choice);
}
void Interface::Input( )
{
	if(num == N)
	{
		cout << "\n�����Ѿ�������\n";
		return;
	}
	int i = num;
	cin >> st[i];
	num ++;
}
void Interface::Browse( )
{
	cout << "\n��Ҫ�鿴ѧ�����ݣ�\n";
	if( num == 0)
	{
		cout<<"\nû��ѧ�����ݣ�\n";
		return;
	}
	else
	{
		cout <<"����"<<'\t'<<"�Ա�"<<'\t'<< "����"<<'\t'
			<<"רҵ"<<'\t'<<"ѧ��"<<'\n';
		for ( int i=0 ; i< num ; i++ )
			cout << st[i];
	}
}
bool Interface::Search( )
{
	char na[20];
	cout << "\n��Ҫ����ѧ����" << endl;
	cout << "\n��Ҫ���ҵ���Ա����:";
	cin >> na;
	for ( int i=0 ; i< num ; i++ )
		if ( strcmp((char*)(st[i]), na ) == 0 )
			break;
		if ( i == num )
		{
			cout << "\nû�д�����Ϣ\n" << endl;
			return false;
		}
		else
			cout << st[i];
		return true;
}
void Interface::Sort( )
{
	cout << "\n��ѧ����������";
	int k;
	for ( int i=0 ; i < num - 1 ; i++ )
	{
		k=i;
		for( int j=i+1 ; j < num ; j++ )
			if( (int)(st[k]) < (int)(st[j]) )
				k = j;
			Student t = st[k];
			st[k] = st[i];
			st[i] = t;
	}
}	
void Interface::Statistic( )
{
	int m=0;
	cout << "\n��ѧ���Ա�ͳ�����ݣ�";
	for ( int i=0 ; i < num  ; i++ )
		if(char(st[i])=='M' || char(st[i])=='m')
			m++;
		cout << "\nͳ�ƽ������ͬѧ��" << m << "��\n";	
}