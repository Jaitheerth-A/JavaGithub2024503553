//queue_using_linked.cpp
#include <iostream>
//#include <iomanip>
#include <map>
using namespace std;
class node{
public:
    int data;
    node* next;
    node(int val){
        data=val;
        next=nullptr;
    }
    node(){
        next=nullptr;
    }
};
class Queue{
    node* front;
    node* rear;
    node* temp;
    enum fn { ENQUEUE,DEQUEUE,DISPLAY,EXIT,INVALID};
    public:
    Queue(){
        front=nullptr;
        rear=nullptr;
    }
    void enqueue(int v)
    {
        node* n=new node(v);
        if(front==nullptr)
        {
            front=n;
            rear=n;
            return;
        }
        rear->next=n;
        rear=n;
        cout<<n->data<<" ENQUEUED..."<<endl;
    }
    void dequeue()
    {
        if(front==nullptr)
        {
            cout<<"Queue is empty"<<endl;
            return;
        }
        temp=front;
        front=front->next;
        cout<<temp->data<<" DEQUEUED..."<<endl;
        delete temp;
    }
    void display()
    {
        if(front==nullptr)
        {
            cout<<"Queue is empty"<<endl;
            return;
        }
        temp=front;
        cout<<"---QUEUE---"<<endl;
        cout<<string(10,'*')<<endl;
        while(temp!=nullptr)
        {
            cout<<temp->data<<endl;
            temp=temp->next;
        }
        cout<<string(10,'*')<<endl;
    }
    ~Queue()
    {
        temp=front;
        while(front!=nullptr)
        {
            front=front->next;
            delete temp;
        }
        cout<<"ALL QUEUE NODES ARE DESTROYED"<<endl;
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
            {"ENQUEUE",ENQUEUE},
            {"DEQUEUE",DEQUEUE},
            {"DISPLAY",DISPLAY},
            {"EXIT",EXIT}
        };
        string key=toUpper(s);
        auto it=locate.find(key);
        if(it!=locate.end())return it->second;
        return INVALID;
    }

    void menu()
    {
        fn choice;string c;
        do
        {
            cout<<"MENU\nENQUEUE\nDEQUEUE\nDISPLAY\nEXIT\n";
            cout<<"Enter your choice: ";
            cin>>c;
            choice=toenum(c);
            switch(choice)
            {
                case ENQUEUE:
                int v;
                    cout<<"Enter value to be enqueued: ";
                    cin>>v;
                    enqueue(v);
                    break;
                case DEQUEUE:
                    dequeue();
                    break;
                case DISPLAY:
                    display();
                    break;
                case EXIT:
                    cout<<"Exiting..."<<endl;
                    break;
                default:
                    cout<<"Invalid choice"<<endl;
            }
        }while(choice!=EXIT);
    }
};
int main()
{
    Queue q;
    q.menu();
    return 0;
}