//example9_05_interface.cpp

#include "example9_05_interface.h"
#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

Interface::Interface( )
{
	ReadFile( );
}


void Interface::Display( )
{
	cout << endl;
	cout << "**********0.��    ��**********" << endl;
	cout << "**********1.�����Ϣ**********" << endl;
	cout << "**********2.��ѯ��Ϣ**********" << endl;
	cout << "**********3.ɾ����Ϣ**********" << endl;
	cout << "**********4.��ʾ��Ϣ**********" << endl;
}


void Interface::Run( )
{
	int choice;

	do
	{
		Display( );
		cout << "Please input your choice:";
		cin >> choice;
		switch ( choice )
		{
		case 0 :
			break;
		case 1 :
			Insert( );
			break;
		case 2 :
			Search( );
			break;
		case 3 :
			Delete( );
			break;
		case 4 :
			Output( );
			break;
		}

	} while (choice);

	Save( );
}


void Interface::Search( )
{
	string number;

	cout << "������Ҫ��ѯ�ı��: " << endl;
	cin >> number;

	set<Person>::iterator p = pe.begin( );

	while ( p != pe.end( ) )
	{
		if ( p->GetNumber( ) == number )
			break;
		p++;
	}

	if ( p == pe.end( ) )
		cout << "û�д�����Ϣ!\n";
	else
	{
		cout << "����\t���\t�Ա�  ��������\t רҵ\t       ����\tְ��\t����\n";
		PrintOne( p );
	}
}

void Interface::Insert( )
{
	string name;
	string number;
	char sex;		
	int y, m ,d;
	string speciality;
	string researchTopic;
	string academicTitle;
	int type;
	
	char ch = 'n';
	do
	{
		cout << "��Ҫ�������Ա����(1-ѧ�� 2-�о��� 3-��ְ�о��� 4-��ʦ ):";
		cin >> type;
		while ( type != 1 && type != 2 && type != 3 && type != 4 )
		{
			cout << "�����������������\n";
			cout << "��Ҫ�������Ա����(1-ѧ�� 2-�о��� 3-��ְ�о��� 4-��ʦ ):";
			cin >> type;
		}

		cout << "����: ";
		cin >> name;
		cout << "���: ";
		cin >> number;
		cout << "�Ա�(m/f)��";
		cin >> sex;
		cout << "��������(��� �·� ����):";
		cin >> y >> m >> d;
	
		if ( type == 1 )
		{
			cout << "רҵ: ";
			cin >> speciality; 
			researchTopic = "";
			academicTitle = "";
		}
		else if  ( type == 2 )
		{
			cout << "רҵ: ";
			cin >> speciality; 
			cout << "����: ";
			cin >> researchTopic; 
			academicTitle = "";
		}
		else if  ( type == 3 )
		{
			cout << "רҵ: ";
			cin >> speciality; 
			cout << "����: ";
			cin >> researchTopic;
			cout << "ְ��: ";
			cin >> academicTitle;
		}
		else if  ( type == 4 )
		{
			cout << "ְ��: ";
			cin >> academicTitle;
			speciality = "";
			researchTopic = "";			
		}

		Person ob( name, number, sex, y, m, d, speciality, researchTopic, academicTitle, type);
		
		pe.insert(ob);

		cout << "�������룿(y/n)" << endl;
		cin >> ch;

	} while( ch == 'y' ); 
}



void Interface::PrintOne( set<Person>::iterator p )
{
	cout << p->GetName( ) << '\t' << p->GetNumber( ) << '\t';

	if ( p->GetSex( ) == 'm' )
		cout << "Ů    ";
	else
		cout << "��    ";

	Date bi = p->GetBirth( );
	cout << bi.GetYear( ) << '-' << bi.GetMonth( ) << '-' <<bi.GetDay( ) << "\t ";

	string sp = p->GetSpec( );
	if ( sp == "" )
		cout << setw(12) << setiosflags(ios::left) << "-" << "  ";
	else
		cout << setw(12) << setiosflags(ios::left) << sp << "  ";

	string re = p->GetResearch( );
	if ( re == "" )
		cout << "-\t";
	else
		cout << re << "\t";

	string ac = p->GetAcademic( );
	if ( ac == "" )
		cout << "-\t";
	else
		cout << ac << '\t';

	int type = p->GetType( );
	if ( type == 1 )
		cout << "ѧ��\n";
	else if ( type == 2 )
		cout << "�о���\n";
	else if ( type == 3 )
		cout << "��ְ�о���\n";
	else if ( type == 4 )
		cout << "��ʦ\n";
}


void Interface::Output( )
{
	cout << "����\t���\t�Ա�  ��������\t רҵ\t       ����\tְ��\t����\n";
	set<Person>::iterator p = pe.begin( );

	while ( p != pe.end( ) )
	{
		PrintOne( p );
		p++;
	}
}


void Interface::Delete( )
{
	string number;

	cout << "������Ҫɾ���ı��: " << endl;
	cin >> number;

	set<Person>::iterator p = pe.begin( );
	while ( p != pe.end( ) )
	{
		if ( p->GetNumber( ) == number )
		{
			pe.erase(p++);
			cout << "ɾ���ɹ�!" << endl;
		}
		else
			p++;
	}
	return;
}


void Interface::ReadFile( )
{
	ifstream in("D:\\record.txt");
	if( !in )
	{
		cout << "Cannot open the file\n";
		return ;
	}

	string name;
	string number;
	char sex;		
	int y, m ,d;
	string speciality;
	string researchTopic;
	string academicTitle;
	int type;

	set<Person>::iterator p = pe.begin( );
	
	in >> name >> number >> sex >> y >> m >> d >> speciality >> researchTopic >> academicTitle >> type;

	while ( !in.eof() )
	{
		if ( speciality == "-" )
			speciality = "";

		if ( researchTopic == "-" )
			researchTopic = "";

		if ( academicTitle == "-" )
			academicTitle = "";
		
		Person ob( name, number, sex, y, m, d, speciality, researchTopic, academicTitle, type);
		pe.insert(ob);

		in >> name >> number >> sex >> y >> m >> d >> speciality >> researchTopic >> academicTitle >> type;

	}

	in.close();

	return;
}


void Interface::Save( )
{
	ofstream out("D:\\record.txt");
	if( !out )
	{
		cout << "Cannot open the file\n";
		return ;
	}

	set<Person>::iterator p = pe.begin( );
	
	while ( p != pe.end( ) )
	{
		out << p->GetName( ) << ' ' << p->GetNumber( ) << ' ' << p->GetSex( )<< ' ';

		Date bi = p->GetBirth( );
		out << bi.GetYear( ) << ' ' << bi.GetMonth( ) << ' ' <<bi.GetDay( )<< ' ';

		string sp = p->GetSpec( );
		if ( sp == "" )
			out << "-" << ' ';
		else
			out << sp << ' ';

		string re = p->GetResearch( );
		if ( re == "" )
			out << "-" << ' ';
		else
			out << re << ' ';

		string ac = p->GetAcademic( );
		if ( ac == "" )
			out << "-" << ' ';
		else
			out << ac << ' ';
	
		out << p->GetType( )  << endl;

		p++;
	}

	out.close();

	return;
}
