//li8.11.cpp������Sample������">>"��"<<"�����������н��е���
#include <iostream.h>
class Sample 
{   int x,y;
public:
    Sample(int m=0,int n=0):x(m),y(n)
    {}
    friend ostream & operator<<(ostream & stream,const Sample &s);
    friend istream & operator >>(istream & stream,Sample &s);
};
ostream & operator<<(ostream & stream,const Sample &s)
{   stream<<"x="<<s.x<<",y="<<s.y<<endl;
    return stream;
}
istream & operator >>(istream & stream,Sample &s)
{   cout<<"Input x & y"<<endl;
    cout<<"x:";    stream>>s.x;
    cout<<"y:";    stream>>s.y;
    return stream;
}
void main()
{   Sample a(1,2),b,c;            		//����3������
    cout<<"a object is:\n";
    cout<<a;                    		//�൱��operator<<(cout,a);���
    cin>>b>>c;                  		//�൱��operator(operator>>(cin,b),c);���
    cout<<"b and c objects are:\n";
    cout<<b<<c;               		//�൱��operator(operator<<(cout,b),c);���
}
