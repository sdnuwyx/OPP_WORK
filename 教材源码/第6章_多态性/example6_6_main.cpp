//example6_6_main.cpp���������صĺ������������"()"
#include"example6_6.h"
int main()
{ 
	Matrix  am(10,10);           		//�����������am
    cout << "am(2,3)= " <<am(2,3)<< endl;    
    am(2,3)=900;                		//�൱��am.operator()(2,3)=900;���
    cout << "am(2,3)= " <<am(2,3)<< endl;
	return 0;
}
