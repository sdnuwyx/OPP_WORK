//example7_05.cpp:�����ɱ������������
#include <vector>
#include <iostream>
using namespace std;
int main()
{  vector<int> sample(3,5);
   vector <int> intv;
   int temp,i;
   cout<<"Enter numbers and press 0 to end" <<endl;
cin>>temp;
   while(temp != 0 )
{		intv.push_back(temp); //���뻺��
		cin>>temp;
}
  cout<< "There are "<< intv.size() <<" elements in intv." <<endl;
  for ( i=0; i<intv.size();i++)
	  cout<<intv[i]<<"   ";
  cout<<endl;
  cout<<"Sample element is :";
  for ( i=0; i<3; i++)
	  cout<<sample[i]<<"   ";
  cout<<endl;
  return 0;
}
