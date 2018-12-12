#include<iostream>
#include<stdlib.h>
using namespace std;
class Student
	{
		private:
			static int total;//私有的静态成员函数
			int num;
			char name[20];
	public:
		Student(){total++;}//构造函数,每定义一个新对象,则total加1
		~Student(){total--;}//析构函数,每一个对象生命期结束,则total减1
		Student(int n,char *p="Wang");
		void Getname();
		int Getnum();
		static void Print();//声明一个公有的静态成员函数
};
int Student::total=0;//静态数据成员的初始化
Student::Student(int n,char *p)//带参构造函数,每定义一个新对象,则total加1
{
	num=n;
	strcpy(name,p);
	total++;
}
void Student::Getname()
{
	cout<<name<<endl;
}
int Student::Getnum()
{
	return num;
}
void Student::Print()
{
	cout<<"The number of all students:"<<total<<endl;
}
int main()
{
	Student::Print();//无对象时可用类名::静态成员函数名()形式输出total
	Student *p=new Student(13);//用指针申请动态空间并得到对象*p
	Student::Print();//用类名::静态成员名()输出total
	p->Print();//用指针所指向的对象去访问静态成员函数名()
	delete p;
	Student::Print();//用类名::静态成员函数名()输出total
	Student s[2];//定义两个对象,构造函数调用两次
	s[0].Print();//这两行输出结果一定相同
    s[1].Print();
	system("pause");
	return 0;
}