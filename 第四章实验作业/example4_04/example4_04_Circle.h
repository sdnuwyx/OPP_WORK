<<<<<<< HEAD
#ifndef _Circle//������룬�����ظ�����
#define _Circle//������Ҫ��������ͬ
class Circle
{
private:
	double Radius;//����Բ�İ뾶
	const double PI; //����һ�������ݳ�Ա,PI����Բ����
public:
	Circle(double r=0):PI(3.14159269)//ֻ��ͨ����ʼ���б��ʼ�������ݳ�Ա
	{

		Radius=r;
	}
	double Area();//��Բ�����
	double Circumference();//��Բ���ܳ�
	double GetRadius()const;//����Ա����,��ȡ�뾶ֵ,����������
};

=======
#ifndef _Circle//������룬�����ظ�����
#define _Circle//������Ҫ��������ͬ
class Circle
{
private:
	double Radius;//����Բ�İ뾶
	const double PI; //����һ�������ݳ�Ա,PI����Բ����
public:
	Circle(double r=0):PI(3.14159269)//ֻ��ͨ����ʼ���б��ʼ�������ݳ�Ա
	{

		Radius=r;
	}
	double Area();//��Բ�����
	double Circumference();//��Բ���ܳ�
	double GetRadius()const;//����Ա����,��ȡ�뾶ֵ,����������
};

>>>>>>> fe0dfa62bd6c2a663b7eaa63a8727bcacc04741a
#endif