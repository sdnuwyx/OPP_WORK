//example7_14.cpp: ���ı������㷨��Ӧ�þ���
#include<iostream>
#include<algorithm>
#include<functional>
#include<vector>
using namespace std;
int main()
{
	int intarr_1[]={3,4,5,7,7,7,6,8,9,8};
	vector <int> ivect_1(intarr_1 , intarr_1 + sizeof(intarr_1)/sizeof(int));
	int intarr_2[]={3,4,5,7,7,7,9,7};
	vector <int> ivect_2(intarr_2 , intarr_2 + sizeof(intarr_2)/sizeof(int));
     //�ҳ���������Ԫ��ֵ��ȵĵ�һ��Ԫ��
	cout<<*adjacent_find( ivect_1.begin(), ivect_1.end())<<endl;
     //ͳ��ivect_1��Ԫ��ֵΪ7��Ԫ�ظ���
	cout<<count( ivect_1.begin(), ivect_1.end(), 7)<<endl;
     //�ҳ�ivect_1��Ԫ��ֵС��7��Ԫ�ظ���
	cout<<count_if( ivect_1.begin(), ivect_1.end(),bind2nd(less<int>(),7))<<endl;
     //�ж���������ivect_1��ivect_2�Ƿ���ȣ�0Ϊ�٣�1Ϊ�棩
	cout<<equal(ivect_1.begin(),ivect_1.end(),ivect_2.begin())<<endl;
	return 0;
}

