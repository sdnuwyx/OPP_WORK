//li8_2.cpp��cin>>��cin.get()�������ַ���ʱ������
#include <iostream>
using namespace std;
const int SIZE =80;
int main() 
{   char buffer1[SIZE], buffer2[SIZE];
    cout << "Enter a sentence: " << endl;
    cin >> buffer1;
    cout << endl << "The string read with cin was :" << buffer1 << endl;
    cin.get(buffer2,SIZE);
    cout << "The string read with cin.get was: "  << buffer2 << endl;
	return 0;
}
