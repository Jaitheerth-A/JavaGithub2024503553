#include<iostream>
using namespace std;
int retsec(int a[],int l)
{
    int max=a[0],t=-1;
    for(int i=0;i<l;i++)
    {
        if(a[i]>max){max=a[i];}
    }
    for(int i=0;i<l;i++)
    {
        if(a[i]<max)
        {
            if(a[i]!=max && a[i+1]!=max && a[i+1]<a[i]){t=a[i];}
        }
    }
    return t;
}
int main()
{
    int l;cout<<"enter length of array:";cin>>l;
    int a[l];
    for(int i=0;i<l;i++)
    {cin>>a[i];}
    cout<<"second:"<<retsec(a,l);
    return 0;
}