/*C���Է���Դ����example2_01.c��ʵ�ֶ��뼸������������������*/
#include <stdio.h>
int main()
{   char c;                            	/*�������c��a��f */
    int a; 
    float f;
    scanf("%c%d%f",&c,&a,&f);             	/*�������c��a��f��ֵ*/
    a=a+c;     
    f=f+2*a;
    printf("c=%c a=%d  f=%f\n",c,a,f);      	/*�������c��a��f��ֵ*/
    return 0;
}
