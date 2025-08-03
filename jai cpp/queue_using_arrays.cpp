//TO IMPLEMENT QUEUE ABSTRACT DATA TYPE WITH  ARRAY
#include<iostream>
using namespace std;
static int front=-1,rear=-1,len=0;
int SetLen(int a)
{
        len=a;
        return len;
}
void Print(int a[])
{
        cout<<"QUEUE:"<<endl;
        for(int i=front;i<=rear;i++)
        {
                cout<<a[i]<<endl;
        }
}
bool isEmpty()
{if((front==-1) || (rear==-1)){return true;}
        else return false;}
bool isFull(int a[])
{
        if(rear>=len)
        {
                return true;
        }
        else return false;
}
void Enqueue(int a[],int b)
{
        if(isEmpty()){front++;}
                if(rear<len-1){rear++;a[rear]=b;}
                 Print(a);
                if(rear>=len-1)
        {
                cout<<"QUEUE IS FULL"<<endl;
        }
}
void Dequeue(int a[])
{
        if(front<=rear)
        {cout<<"Element removed:"<<a[front]<<endl;
        front++;}
        else{cout<<endl<<"QUEUE IS EMPTY"<<endl;}
        Print(a);
}
int main()
{
        int n,c,v;
        cout<<"ENTER MAX SIZE OF QUEUE:";cin>>n;
        int a[n];
        SetLen(n);
        do
        {
                cout<<"CHOOSE OPERATION:\n1)ENQUEUE\n2)DEQUEUE\n3)EXIT\nENTER CHOICE:";
                cin>>c;
                switch(c)
                {
                        case 1:{cout<<"Enter value to Insert:";cin>>v;Enqueue(a,v);break;}
                        case 2:{Dequeue(a);break;}
                        case 3:{cout<<endl<<"THANK YOU!"<<endl;break;}
                        default:{cout<<"ERROR!! ENTER ELIGIBLE CHOICE"<<endl;break;}
                }
        }while(c!=3);
        return 0;
}