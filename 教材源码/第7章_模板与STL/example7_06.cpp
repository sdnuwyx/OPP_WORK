//example7_06.cpp :�����ط��伴�����ⶨ������
#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main()
{  vector <int> vs;
  vs.reserve(10);                                  //�õ�����10������s�Ŀռ�
  vs.push_back(1);                                //����Ԫ��1
  vs.push_back(2);                                //����Ԫ��2
  cout<<"size: "<< vs.size()<<endl;                  //�����2
  cout<<"capacity: "<<vs.capacity()<<endl;           //�����10
  cout<<"there's  "<<vs.capacity() - vs.size()
      <<"empty elements before reallocation"<<endl;
  vs.resize(20);
  cout<<"size: "<< vs.size()<<endl;                  //��� 20
  cout<<"capacity: "<<vs.capacity()<<endl;           //���20;
  return 0;
}
