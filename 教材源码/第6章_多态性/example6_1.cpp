//example6_1.cpp: ���Ա������ʵ��
#include"example6_1.h" 
Student::Student()  
{
	no=0;
	strcpy(name, "ͬѧ");
}  
Student::Student(char *sname, int n)
{ 
	no=n;
	strcpy(name, sname);
}
void  Student::print() 
{   
	cout << name <<"  " << no << endl; 
}
void  Student::print(int n) 
{   
	cout << name <<"  B"<< n << no << endl;  
}