//TO IMPLEMENT CIRCULAR QUEUE USING CIRCULAR ARRAY
#include<iostream>
using namespace std;
static int front=-1,rear=-1,len=0;
int Setlen(int a)
{
        len=a;
        return len;
}
void print(int a[])
{
        cout<<"queue:"<<endl;
        if(rear>front){
        for(int i=front;i<=rear;i++){cout<<a[i]<<endl;}}
        else
        {
                for(int i=rear;i<=front;i++){cout<<a[i]<<endl;}
        }
}
bool isEmpty()
{
        return front==-1 && rear==-1;
}
bool isFull()
{
        return ((rear+1) % (len)) == front;
}
void Enqueue(int a[],int b)
{
        if(isFull()){cout<<endl<<"STACK IS FULL"<<endl;}
        else{
        if(isEmpty()) {front++;}
        rear++;
        if(rear>len-1){rear%=(len+1);}
        a[rear]=b;
        }
        //print(a);
}
void Dequeue(int a[])
{
        if(isEmpty()){cout<<endl<<"QUEUE IS EMPTY"<<endl;}
        int temp=a[front];
        front++;
        if(front==rear){rear=front=-1;}
        else if(front>len){front%=(len+1);
            cout<<"Element removed:"<<temp<<endl;}
}
int main()
{
        int n,c,v;cout<<"enter size of queue:";cin>>n;int a[n];len=n;Setlen(len);
        //for(int i=0;i<10;i++){Enqueue(a,i);}
        do{
                cout<<"CHOOSE OPERTAION:\n1)ENQUEUE\n2)DEQUEUE\n3)EXIT\nENTER CHOICE:";cin>>c;
                switch(c)
                {
                        case 1:{cout<<endl<<"enter value:";cin>>v;Enqueue(a,v);print(a);break;}
                        case 2:{Dequeue(a);print(a);break;}
                        case 3:{cout<<endl<<"THANK YOU!"<<endl;break;}
                        default:{cout<<"ERROR!! ENTER ELIGIBLE CHOICE";break;}
                }
        }while(c!=3);
        return 0;
}