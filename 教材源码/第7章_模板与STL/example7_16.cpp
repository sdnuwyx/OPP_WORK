//example7_16.cpp: sort( )�㷨����
#include <iostream>
#include <algorithm>                  //sort()�Ķ���
#include <vector>
using namespace std;
int main()
{  	int intarr_1[ ]={3,14,5,17,27,7,6,18,9,8};
	vector <int> ivect_1(intarr_1 , intarr_1 + sizeof(intarr_1)/sizeof(int));
  sort(ivect_1.begin(), ivect_1.end() );  
      // sort()��������ָ�����п�ʼ�ͽ�β��const���͵�����������vi��Ĭ��������
    vector<int> ::iterator p = ivect_1.begin();
    while ( p!= ivect_1.end() )
	   cout<< *p++ <<"   ";
    cout<<endl;
    return 0;
}

