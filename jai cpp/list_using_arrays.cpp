//list implemented in arrays
#include<iostream>
using namespace std;
int search(int a[],int l,int x)
{
        int i;
        for(i=0;i<l;i++)
        {
                if(a[i]==x)
                {
                        cout<<"index of search element "<<x<<" is:"<<i<<endl;return i;
                }
        }
        cout<<"search element not found"<<endl;
        return -1;
}
void print(int a[],int l)
{
        cout<<"\nLIST\n";
        for(int i=0;i<l;i++)
        {
        cout<<a[i]<<endl;
        }
}
int max(int a[],int l)
{
        int i;
        int max=a[0];
        for(i=0;i<l;i++)
        {
                if(a[i]>max)
                {
                        int t=max;
                        max=a[i];
                        a[i]=t;
                }
        }
        cout<<"max element is:"<<max<<endl;
        return max;
}
int min(int a[],int l)
{
        int i;int min=a[0];
        for(i=0;i<l;i++)
        {
                if(a[i]<min)
                {
                        int t=min;
                        min=a[i];
                        a[i]=t;
                }
        }
        cout<<"min element is:"<<min<<endl;
        return min;
}
void Delete1(int a[],int& l,int p=0)
{
        int i;
        for(i=p;i<l;i++)
        {
                a[i]=a[i+1];
        }
        l--;
        print(a,l);
}
void Delete2(int a[],int l,int x)
{
        int i;
        for(i=0;i<l;i++)
        {
                if(x==a[i])
                {
                        Delete1(a,l,i);
                }
        }
}
void insert(int a[],int& l,int x,int p=0)
{
        if((p<0)||(p>=l))
        {
                cout<<"\nerror!!enter within range:("<<0<<'-'<<l-1<<')'<<endl;
                return;
        }
        else{
        int i;
        for(i=l-1;i>=p;i--)
        {
                a[i+1]=a[i];
        }
        l++;
        a[p]=x;
        print(a,l);}
}
int main()
{
        int l,i,n,p,x;
        cout<<"enter length of list:";
        cin>>l;
        int a[l];
        for(i=0;i<l;i++)
        {
                cout<<"enter\t"<<i+1<<"\telment:";
                cin>>a[i];
        }
        do{
        cout<<"enter operation:\n1)insert\n2)delete\n3)maximum\n4)minimum\n5)search\n6)exit\n";cin>>n;
        switch(n)
        {
                case 1:{cout<<"give position to insert:";cin>>p;cout<<"give element:";cin>>x;insert(a,l,x,p);break;}
                case 2:{cout<<"give 1)position or 2)value:";cin>>p;if(p==1){cout<<"give position:";cin>>x;Delete1(a,l,x);}else{cout<<"give value:";cin>>x;Delete2(a,l,x);}break;}
                case 3:{max(a,l);break;}
                case 4:{min(a,l);break;}
                case 5:{cout<<"give search element:";cin>>x;search(a,l,x);break;}
                case 6:{cout<<"\nThank you!";break;}
                default:{cout<<"\nerror!!";break;}
        }}while(n!=6);
        return 0;
}
