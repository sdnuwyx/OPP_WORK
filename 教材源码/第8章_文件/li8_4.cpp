//li8_4.cpp���ò��ݺ���setw�������ʾ��
#include<iostream>
#include<iomanip>
using namespace std;
void main()
{   int i=6789;
    int j=1234;
    int k=10;
    cout << setw(6) << i << j << k << "\n";
    cout << setw(6) << i << setw(6) << j << setw(6) << k;
}
