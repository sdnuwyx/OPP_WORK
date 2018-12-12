//example7_04.cpp������������ģ��Ķ��弰ʹ��ʾ��
#include<iostream>
using namespace std;
template <class Type> 
class Link
{public:
    Link();                      		//���캯��
    void Insert(Type&) ;           		//������
    void PrintLink();              		//���������Ϣ
    ~Link();
protected:
    struct Node
    {   Node* next;
        Type* p;                 		//�����Ϣ��ָ������
    };
    Node* head;
};
template<class Type>
Link<Type>::Link()
{   head=0;  
}
/*�����ײ����½�㣬ʹÿ���½�㶼���µĵ�һ�����*/
template<class Type>
void Link<Type>::Insert(Type& t)
{   Node* temp=new Node;
    temp->p=&t;
    temp->next=head;
    head=temp;
}
template<class Type>
void Link<Type>::PrintLink()
{   for( Node *pp=head ;  pp ;  pp = pp->next )
    {   cout<<*(pp->p)<<"  ";	
    }
    cout<<endl;
}
template<class Type>
Link<Type>::~Link()
{   Node* pp;
    while( pp = head )
    {   head = head->next;
        delete pp->p;
        delete pp;
    }
}
int main()
{   
	Link< double > DoubleLink;
    for( int i=1;  i<7 ;  i++ )
    {   
		DoubleLink.Insert(*new double ( i + 0.1 ) );	
    }
    DoubleLink.PrintLink( );
	return 0;
}
