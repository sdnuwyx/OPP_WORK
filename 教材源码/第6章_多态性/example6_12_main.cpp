//example6_12_main.cpp: ���麯���Ĳ���
#include "example6_12.h"
void DrawObject(Point *p)	//���嶥�㺯�����Ի���ָ��Ϊ��ʽ����
{ 
	p->Draw();    
}
int main()
{ 
	Line L;
    Circle C;
    DrawObject(&L) ;             		//�൱��Point *p=&L;��䣬����ָ��ָ��L����
    DrawObject(&C) ;             		//�൱��Point *p=&C;��䣬����ָ��ָ��C����
	return 0;
}
