// dblink.cpp
#include<iostream>
using namespace std;
class node
{
        public:
        int data;
        node* next;
        node* prev;
        node(){data=0;next=nullptr;prev=nullptr;}
        node(int v)
        {data=v;next=nullptr;prev=nullptr;}
};
class dblink
{
        public:
                node* head;
                node* tail;
                node* temp=head;
        void insert1(int v)
        {
                node* r=new node();
                r->data=v;
                        r->next=tail;
                        r->prev=head;
                        head=r;
                        tail=r;
                        temp=r;
        }
        public:
        dblink()
        {
                head=tail=nullptr;
        }

        void insert(int v,int i=1)
        {
                node* r=new node();
                r->data=v;
                if(i==1){
                if(head==nullptr && tail==nullptr)
                {
                insert1(v);
                }
                else
                {
                        temp=tail;
                        r->next=tail;
                        r->prev=temp;
                        temp->next=r;
                        tail=r;
                        temp=r;
                }
                cout<<"INSERTING VALUE AT END:"<<(r->data)<<"..."<<endl;}
                else if(i==-1)
                {
                        if(head==nullptr && tail==nullptr)
                        {
                        insert1(v);
                        }
                        else if(head!=nullptr)
                        {
                                temp=head;
                                r->next=temp;
                                r->prev=head;
                                temp->prev=r;
                                head=r;
                        }
                        else
                        {
                                r->next=temp;
                                r->prev=head;
                                temp->prev=r;
                                head=r;
                                temp=r;
                        }
                        cout<<"INSERTING VALUE AT BEGINNING:"<<(r->data)<<"..."<<endl;
                }
                else if(i==0)
                {
                        int p;
                        cout<<"ENTER POSITION TO INSERT "<<r->data<<':';
                        cin>>p;
                        if(head==nullptr && tail==nullptr)
                        {
                                insert1(v);
                        }
                        else
                        {
                                temp=head;
                                for(int i=0;(temp!=tail) && (i<p);i++)
                                {
                                        temp=temp->next;//causes infinite loop when p > size
                                }
                                        r->prev=temp;
                                        r->next=temp->next;
                                        temp->next->prev=r;
                                        temp->next=r;
                                        temp=r;
                        }
                }
                else
                {
                        cout<<"ERROR !! ENTERED VALUE IS NOT WITHIN PARAMETER RANGE!!\nENTER VALID VALUE TO ENTER VALUE "<<r->data<<" IN LIST FROM(1 to -1):";cin>>i;insert(v,i);
                }
        }
        void disp(int i=1)
        {
                if(i==1)
                {
                        temp=head;
                        cout<<"LIST:"<<endl;
                        while(temp!=tail)
                        {
                                cout<<0xA<<temp->data<<endl;
                                temp=temp->next;
                        }//while(temp!=tail);
                         cout<<temp->data<<endl;
                }
                else if(i==-1)
                {
                        temp=tail;
                        cout<<"LIST REVERSED:"<<endl;
                        while(temp!=head)
                        {
                                cout<<0xB<<temp->data<<endl;
                                temp=temp->prev;
                        }cout<<temp->data<<endl;
                }
                else{cout<<"ERROR !!ENTERED PARAMETER IS NOT WITHIN RANGE!!\nGIVE CORRECT PARAMETERS FROM(-1/1):";cin>>i;disp(i);}
        }
};
int main()
{
        dblink a;
        a.insert(10);
        a.insert(20);
        a.insert(30,-1);
        a.insert(40);
        a.insert(50,0);
        a.disp();
        a.disp(-1);
        //a.disp(3);
        return 0;
}

