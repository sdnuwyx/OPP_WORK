<<<<<<< HEAD
#include"example4_06_student.h"
int Student::count=0;//静态数据成员的初始化
Student::Student()
{
	name=NULL;
	age=0;
}
Student::Student(char *na, char *id, char *num, char *spec, int ag)
{
	if (na)
	{
		name = new char[strlen(na) + 1];//避免浅拷贝
		strcpy(name, na);
	}
	strcpy(ID, id);
	strcpy(number, num);
	strcpy(speciality, spec);
	age = ag;
	count++;
}
Student::Student(const Student &per)    //拷贝构造函数,在此例中暂时没有用
{
	if (per.name)
	{
		name = new char[strlen(per.name) + 1];
		strcpy(name, per.name);
	}
	strcpy(ID, per.ID);
	strcpy(number, per.number);
	strcpy(speciality, per.speciality);
	age = per.age;
	count++;
}
Student::~Student()
{
	cout<<"disCon"<<endl;
	if(name)
		delete []name;
	count--;
}
char* Student::Getname()  const              //提取姓名
{
	return name;
}
char* Student::GetID()                  //提取身份证
{
	return ID;
}
int Student::GetAge()  const                 //提取年龄
{
	return age;
}
char* Student::GetSpec()               //提取专业
{
	return speciality;
}
char* Student::Getnumber()               //提取学号
{
	return number;
}
void Student::Display()  const              //输出数据信息
{
	cout << "姓名:" << name << endl;
	cout << "身份证:" << ID << endl;
	cout << "学号:" << number << endl;
	cout << "专业:" << speciality << endl;
	cout << "年龄:" << age << endl << endl;
}
void Student::Input()
{
	char na[10];
	cout << "输入姓名:";
	cin >> na;
	if (name)
		delete[]name;
	name = new char[strlen(na) + 1];
	strcpy(name, na);
	cout << "输入身份证:";
	cin >> ID;
	cout << "输入年龄:";
	cin >> age;
	cout << "输入专业:";
	cin >> speciality;
	cout << "输入学号:";
	cin >> number;
	count++;//此句增加,每输入一个,学生总数加1
}
void Student::Insert()

{
	if(!age)//当对象的age成员值为0时,在此调用Input()函数重新输入对象的值
		Input();
}
void Student::Delete()//新增
{
	age=0;//只简单的将age置0而不移动数组元素
	count--;
}
int Student::GetCount()//新增静态成员函数,专门用来访问静态数据成员
{
	return count;
}
=======
#include"example4_06_student.h"
int Student::count=0;//静态数据成员的初始化
Student::Student()
{
	name=NULL;
	age=0;
}
Student::Student(char *na, char *id, char *num, char *spec, int ag)
{
	if (na)
	{
		name = new char[strlen(na) + 1];//避免浅拷贝
		strcpy(name, na);
	}
	strcpy(ID, id);
	strcpy(number, num);
	strcpy(speciality, spec);
	age = ag;
	count++;
}
Student::Student(const Student &per)    //拷贝构造函数,在此例中暂时没有用
{
	if (per.name)
	{
		name = new char[strlen(per.name) + 1];
		strcpy(name, per.name);
	}
	strcpy(ID, per.ID);
	strcpy(number, per.number);
	strcpy(speciality, per.speciality);
	age = per.age;
	count++;
}
Student::~Student()
{
	cout<<"disCon"<<endl;
	if(name)
		delete []name;
	count--;
}
char* Student::Getname()  const              //提取姓名
{
	return name;
}
char* Student::GetID()                  //提取身份证
{
	return ID;
}
int Student::GetAge()  const                 //提取年龄
{
	return age;
}
char* Student::GetSpec()               //提取专业
{
	return speciality;
}
char* Student::Getnumber()               //提取学号
{
	return number;
}
void Student::Display()  const              //输出数据信息
{
	cout << "姓名:" << name << endl;
	cout << "身份证:" << ID << endl;
	cout << "学号:" << number << endl;
	cout << "专业:" << speciality << endl;
	cout << "年龄:" << age << endl << endl;
}
void Student::Input()
{
	char na[10];
	cout << "输入姓名:";
	cin >> na;
	if (name)
		delete[]name;
	name = new char[strlen(na) + 1];
	strcpy(name, na);
	cout << "输入身份证:";
	cin >> ID;
	cout << "输入年龄:";
	cin >> age;
	cout << "输入专业:";
	cin >> speciality;
	cout << "输入学号:";
	cin >> number;
	count++;//此句增加,每输入一个,学生总数加1
}
void Student::Insert()

{
	if(!age)//当对象的age成员值为0时,在此调用Input()函数重新输入对象的值
		Input();
}
void Student::Delete()//新增
{
	age=0;//只简单的将age置0而不移动数组元素
	count--;
}
int Student::GetCount()//新增静态成员函数,专门用来访问静态数据成员
{
	return count;
}
>>>>>>> fe0dfa62bd6c2a663b7eaa63a8727bcacc04741a
