#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
#include<stdlib.h>
using namespace std;

	
FILE *fp=NULL;
int num,cnt;
struct student{
	int number;
	char name[10];
	float dailyscore;
	float testscore;
	float finalscore;
	double generalscore;
	int rank;
};

void ReadStudent(student *stu)
{
	//¼��ѧ���ɼ�
	printf("������ѧ����������\n");
	scanf("%d",&num);
	printf("������ѧ���ɼ���\n");
	for(int i=0;i<num;i++)
	{
		scanf("%d %s %f %f %f",&stu[i].number,&stu[i].name,&stu[i].dailyscore,&stu[i].testscore,&stu[i].finalscore);
	}
}
void Totalscore(student *stu)
{
	//�ܳɼ�
	printf("\nѧ�����ܳɼ�\n");
	for(int i=0;i<num;i++)
	{
		stu[i].generalscore=stu[i].dailyscore*0.2+stu[i].testscore*0.2+stu[i].finalscore*0.6;
		printf("ѧ�ţ�%d\t������%s\t�ܳɼ���%.2f\n",(stu[i].number),(stu[i].name),(stu[i].generalscore));
	}
}
void Sort(student *stu,int n)//��ѧ���ɼ�����
{
	int i,j;
	student temp;
	for(i=0;i<n-1;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(stu[i].generalscore<stu[j].generalscore)
			{
				temp=stu[i];
				stu[i]=stu[j];
				stu[j]=temp;
			}
		}
		
	}
}
void Studentrank(student *stu)
{
	//����
	printf("\nѧ������\n");
	int j;
	for(int i=0;i<num;i++)
	{
		printf("ѧ�ţ�%d\t������%s\t�ɼ���%.2f\t���Σ�%d\n",(stu[i].number),(stu[i].name),(stu[i].generalscore),i+1);
		stu[i].rank=i+1;
	}
	int numtemp;//�����ѧ��
	printf("������Ҫ��ѯѧ����ѧ�ţ�");
	scanf("%d",&numtemp);
	for(j=0;j<num;j++)
	{
		if(stu[j].number==numtemp)
			{
				printf("��ѯ�ã�\n");
			    printf("ѧ�ţ�%d\t������%s\t�ɼ���%.2f\t���Σ�%d",numtemp,stu[j].name,stu[j].generalscore,stu[j].rank);
		}
	}

}
float mypow(float x)
{
	return(x*x);
}
void Revengescore(student *stu)//��ֵ��������㼰�ɼ��ֲ�����
{
	int a=0,b=0,c=0;
	float x=0;
	float sum=0;//��ֵ
	float meanvalue;//��ֵ
	printf("\n��ֵ\n");
	
	for(int i=0;i<num;i++)
	{
		sum=sum+stu[i].generalscore;
	}
	meanvalue=sum/num;
	printf("�ÿγ̳ɼ��ľ�ֵΪ��%.2f",meanvalue);
	printf("\n����\n");
	float variance;//����
	for(int i=0;i<num;i++)
	{
		x=x+mypow(stu[i].generalscore-meanvalue);
	}
	variance=x/num;
	printf("�ÿγ̳ɼ��ķ���Ϊ��%.2f",variance);
	for(int i=0;i<num;i++)
	{
		if(stu[i].generalscore<=85) a++;
		else if(stu[i].generalscore>85&&stu[i].generalscore<=90) b++;
		else if(stu[i].generalscore>90 )c++;
     }
	printf("\n");
	printf("�ܳɼ�������85�ֵ���������%d��\n",a);
	printf("�ܳɼ�����85���Ҳ�����90�ֵ�������%d��\n",b);
	printf("�ܳɼ�����90�ֵ�������%d��\n",c);

}

int main()
{
	void ReadStudent(student *stu);
	student stu[10];
	printf("¼��ѧ���ɼ���\n");
	ReadStudent(stu);
	Totalscore(stu);
	Sort(stu,num);
	Studentrank(stu);
	Revengescore(stu);
	system("pause");
}

