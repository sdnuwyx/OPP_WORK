<<<<<<< HEAD
#include"example4_06_student.h"
int Student::count=0;//��̬���ݳ�Ա�ĳ�ʼ��
Student::Student()
{
	name=NULL;
	age=0;
}
Student::Student(char *na, char *id, char *num, char *spec, int ag)
{
	if (na)
	{
		name = new char[strlen(na) + 1];//����ǳ����
		strcpy(name, na);
	}
	strcpy(ID, id);
	strcpy(number, num);
	strcpy(speciality, spec);
	age = ag;
	count++;
}
Student::Student(const Student &per)    //�������캯��,�ڴ�������ʱû����
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
char* Student::Getname()  const              //��ȡ����
{
	return name;
}
char* Student::GetID()                  //��ȡ���֤
{
	return ID;
}
int Student::GetAge()  const                 //��ȡ����
{
	return age;
}
char* Student::GetSpec()               //��ȡרҵ
{
	return speciality;
}
char* Student::Getnumber()               //��ȡѧ��
{
	return number;
}
void Student::Display()  const              //���������Ϣ
{
	cout << "����:" << name << endl;
	cout << "���֤:" << ID << endl;
	cout << "ѧ��:" << number << endl;
	cout << "רҵ:" << speciality << endl;
	cout << "����:" << age << endl << endl;
}
void Student::Input()
{
	char na[10];
	cout << "��������:";
	cin >> na;
	if (name)
		delete[]name;
	name = new char[strlen(na) + 1];
	strcpy(name, na);
	cout << "�������֤:";
	cin >> ID;
	cout << "��������:";
	cin >> age;
	cout << "����רҵ:";
	cin >> speciality;
	cout << "����ѧ��:";
	cin >> number;
	count++;//�˾�����,ÿ����һ��,ѧ��������1
}
void Student::Insert()

{
	if(!age)//�������age��ԱֵΪ0ʱ,�ڴ˵���Input()����������������ֵ
		Input();
}
void Student::Delete()//����
{
	age=0;//ֻ�򵥵Ľ�age��0�����ƶ�����Ԫ��
	count--;
}
int Student::GetCount()//������̬��Ա����,ר���������ʾ�̬���ݳ�Ա
{
	return count;
}
=======
#include"example4_06_student.h"
int Student::count=0;//��̬���ݳ�Ա�ĳ�ʼ��
Student::Student()
{
	name=NULL;
	age=0;
}
Student::Student(char *na, char *id, char *num, char *spec, int ag)
{
	if (na)
	{
		name = new char[strlen(na) + 1];//����ǳ����
		strcpy(name, na);
	}
	strcpy(ID, id);
	strcpy(number, num);
	strcpy(speciality, spec);
	age = ag;
	count++;
}
Student::Student(const Student &per)    //�������캯��,�ڴ�������ʱû����
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
char* Student::Getname()  const              //��ȡ����
{
	return name;
}
char* Student::GetID()                  //��ȡ���֤
{
	return ID;
}
int Student::GetAge()  const                 //��ȡ����
{
	return age;
}
char* Student::GetSpec()               //��ȡרҵ
{
	return speciality;
}
char* Student::Getnumber()               //��ȡѧ��
{
	return number;
}
void Student::Display()  const              //���������Ϣ
{
	cout << "����:" << name << endl;
	cout << "���֤:" << ID << endl;
	cout << "ѧ��:" << number << endl;
	cout << "רҵ:" << speciality << endl;
	cout << "����:" << age << endl << endl;
}
void Student::Input()
{
	char na[10];
	cout << "��������:";
	cin >> na;
	if (name)
		delete[]name;
	name = new char[strlen(na) + 1];
	strcpy(name, na);
	cout << "�������֤:";
	cin >> ID;
	cout << "��������:";
	cin >> age;
	cout << "����רҵ:";
	cin >> speciality;
	cout << "����ѧ��:";
	cin >> number;
	count++;//�˾�����,ÿ����һ��,ѧ��������1
}
void Student::Insert()

{
	if(!age)//�������age��ԱֵΪ0ʱ,�ڴ˵���Input()����������������ֵ
		Input();
}
void Student::Delete()//����
{
	age=0;//ֻ�򵥵Ľ�age��0�����ƶ�����Ԫ��
	count--;
}
int Student::GetCount()//������̬��Ա����,ר���������ʾ�̬���ݳ�Ա
{
	return count;
}
>>>>>>> fe0dfa62bd6c2a663b7eaa63a8727bcacc04741a
