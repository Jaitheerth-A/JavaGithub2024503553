//STACK implemented in arrays
#include<iostream>
using namespace std;
int t=-1;
void print(int a[])
{
        if(t==-1)
        {cout<<"\nPlease enter element in stack";}
        else
        {
        cout<<"\nSTACK\n";
        int i;
        for(i=t;i>=0;i--)
        {
                cout<<a[i]<<endl;
        }}
}
bool isfull(int a[],int l,int top)
{
        if(l==(t+1))
        {
                cout<<"\nstack is full\n";
                return true;
        }
        else return false;
}
bool isempty(int a[],int l,int top)
{
        if(t==-1)
        {
                cout<<"\nstack is empty\n";
                return true;
        }
        else return false;
}
void push(int a[],int l,int top)
{
        if(isfull(a,l,top)==false)
        {
                t++;
                a[t]=top;
        }
}
int pop(int a[],int l,int top)
{
        if(isempty(a,l,top)==false)
        {
                cout<<"\npopped element:"<<a[t];
                t--;
        }
        return top;
}
int main()
{
        int l,x;
        cout<<"\nenter length of stack:";cin>>l;
        int a[l];
        int c;
        do{
        cout<<"\nenter command:\n1)push\n2)pop\n3)exit\n";cin>>c;
switch(c)
{       case 1:{
        cout<<"\nenter top value:";cin>>x;
        push(a,l,x);
        print(a);break;}
        case 2:{
        pop(a,l,x);
        print(a);
        break;}
        case 3:{
                       cout<<"\nThank you!\n";break;
               }
        default:{cout<<"\nerror!!\n";break;}
}
}while(c!=3);
        return 0;
}
