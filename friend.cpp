#include <iostream>


using namespace std;


class Date;


//DateL's friend
bool equal(const Date&r1, Date &r2)
{

	if (r1.year == r2.year&&r1.month == r2.month&&r1.day == r2.day)
	{
		return true;
	}
	else
		return false;
}

//-----------------------------studentÀà-------------------------------------------------------
class student
{
public:
	student(int _id, const char *pname);
	~student();

	//void outputInfo();
	void student::outputInfo(Date &r);

private:

	int id;
	char name[10];

};

student::student(int _id, const char *pname)
{
	this->id = _id;


	strcpy(this->name,pname);
}

student::~student()
{
}

void student::outputInfo(Date &r)
{
	cout << id << "-" << name;

	cout << r.year;
	r.display();
}

//-------------------------DateÀà-----------------------------------------------------------
class Date
{
private:

	int year, month, day;

public:

	Date(int y, int m, int d)
	{
		this->year = y;
		this->month = m;
		this->day = d;
	}
	~Date()
	{
		cout << "destrust is called" << endl;
	}

	void display();

	friend bool equal(const Date&r1, Date &r2);
	friend void student::outputInfo(Date &r);
	//friend class  student;
	friend  student;

};

void Date::display()
{
	cout << year << "-" << month << "-" << day << endl;
}

//------------------------------------------------------------------------------------


int main()
{


	//char 



	Date Gump(2018, 11, 8);

    student Jenny(2017, "Jenny");

	system("pause");

	return 0;
}
