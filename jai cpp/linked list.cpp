#include<iostream>
using namespace std;
class node
{
    public:
    int data;
    node* next;
    node head;
    node()
    {
        head->next=NULL;
    }
    void add(int a)
    {
        new node* temp;
        temp=head;
        new node* r;
        if(temp->next==NULL){//head->next=r;
        head=r;
        r->next=NULL;
        r->data=a;
        }
    }
    void printall()
    {
        new node* temp;
        temp=head;
        while(temp->next!=NULL);
        {
            cout<<temp->data;
            temp=temp->next;
    }

};
int main()
{
    new node a;    
    a.add(10);
    a.add(20);
    a.printall();
    return 0;
}