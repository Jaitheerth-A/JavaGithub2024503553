//stack_using_linked.cpp
#include<iostream>
#include<iomanip>
#include<map>
using namespace std;
class node
{
    public:
    int data;
    node* prev;
    node()
    {
        data=0;
        prev=nullptr;
    }
    node(int val)
    {
        data=val;
        prev=nullptr;
    }
};
class Stack
{
    enum fn { PUSH,POP,PEEK,PRINT,EXIT,INVALID};
    public:
    node* top;
    node* temp;
    Stack()
    {
        top=nullptr;
    }
    ~Stack()
    {
        temp=top;
        while(!isEmpty())
        { 
            top=top->prev;
            delete temp;
        }
        cout<<"ALL STACK NODES ARE DESTROYED";
    }
    bool isEmpty()
    {
        return top==nullptr;
    }
    void push(int v)
    {
        node* r=new node(v);
        r->data=v;
        r->prev=top;
        top=r;
        cout<<"INSERTED "<<r->data<<" ON TOP OF STACK..."<<endl;
    }
    void pop()
    {
        if(isEmpty()) {cout<<"Stack is Empty...";return;}
        temp=top;
        top=top->prev;
        cout<<"DELETED "<<temp->data<<" FROM TOP OF STACK..."<<endl;
        delete temp;
    }
    void peek()
    {
        if(isEmpty()) {cout<<"Stack is Empty...";return;}
        temp=top;
        cout<<"ELEMENT IN TOP OF STACK:"<<temp->data<<endl;
    }
    void print()
    {
        if(isEmpty()) {cout<<"Stack is Empty...";return;}
        temp=top;
        cout<<"---STACK---"<<endl<<string(10,'*')<<endl;
        int n;
        while(temp!=nullptr)
        {
            n=to_string(temp->data).length();
           cout << setfill('$') << setw(((10/2)-n)+n) <<temp->data
         << setw((10/2)-n) << "" << endl;
            temp=temp->prev;
        }
        cout<<string(10,'*')<<endl;
    }
    string toUpper(const string &s)
    {
        string result = s;
        transform(result.begin(), result.end(), result.begin(),[](unsigned char c){ return toupper(c); });
        return result;
    }
    fn toenum(const string& s)
    {
       static map<string,fn>  locate=
        {
            {"PUSH",PUSH},{"POP",POP},{"PEEK",PEEK},{"PRINT",PRINT},{"EXIT",EXIT}
        };
        string key=toUpper(s);
        auto it=locate.find(key);
        if(it!=locate.end())return it->second;
        return INVALID;
    }
    void menu()
    {
        string choice;
        fn ce;
        do
        {
            cout<<"MENU\nPUSH\nPOP\nPEEK\nEXIT";
            cout<<"\nEnter the choice:";cin>>choice;
            ce=toenum(choice);
            switch(ce)
            {
                case PUSH:{int v;cout<<"\nEnter value to be inserted:";cin>>v;push(v);break;}
                case POP:{pop();break;}
                case PEEK:{peek();break;}
                case PRINT:{print();break;}
                case EXIT:{cout<<"Thank you !!";break;}
                default:{cout<<"Invalid argument !!";}
            }

        }while(ce!=EXIT);
    }
};
int main()
{
    Stack a;
    a.menu();
    return 0;
}