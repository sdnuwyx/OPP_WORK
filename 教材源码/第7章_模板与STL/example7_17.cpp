//example7_17.cpp: string��ʼ��Ӧ�þ���
#include <string>
#include <iostream>
using namespace std;
int main()
{
  const char text[] = "hello world";
  string s1 = text;  //��C�ַ�������ʼ��string����
  string s2(s1);  //�������캯��
  string s3(&text[0], &text[5]); //C�ַ����Ĳ��֣�s3 = "hello"
  string s4(10, '0'); //��һ��0����������ʼ��
  string s5 ( s2.begin(), s2.find(' ')); //ͨ������string�Ĳ�������ʼ��
                                         //s5 = "hello"
  cout<<s1<<endl;
  cout<<s2<<endl;
  cout<<s3<<endl;
  cout<<s4<<endl;
  cout<<s5<<endl;
  return 0;
}

