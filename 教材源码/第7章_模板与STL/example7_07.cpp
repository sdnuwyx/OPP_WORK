//example7_07.cpp:��Ա����at()��ʹ�á�
#include <vector>
#include <iostream>
using namespace std;
int main()
{  vector< int > vi( 10, 4);               //ʹ��Ĭ�Ϲ��캯������10��Ԫ�ز���ʼ��Ϊ4
   vi[0] = 100;                         //���������[ ]
   try
   {        cout<< vi.at(10) <<endl;         //�����±�10�Ƿ�Խ�磬���׳��쳣
   }
   catch(std::out_of_range )
   {        cout<<"out of range"<<endl;        //�쳣����
   }
   for(int i=0; i<10 ;i++)
	     cout<<vi[i]<<"    ";
   cout<<endl;
   return 0;
}
