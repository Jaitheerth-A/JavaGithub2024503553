#include <iostream>
#include <cctype>  // for isalnum()
#include <cstdlib> // for exit()
using namespace std;

// ---------------------------
// Node class for character stack
// ---------------------------
class CharNode {
public:
    char data;
    CharNode* next;
    CharNode(char d) {
        data = d;
        next = nullptr;
    }
};

// ---------------------------
// Stack class (using linked list)
// ---------------------------
class CharStack {
    CharNode* top;
public:
    CharStack() { top = nullptr; }

    void push(char c) {
        CharNode* temp = new CharNode(c);
        temp->next = top;
        top = temp;
    }

    char pop() {
        if (isEmpty()) {
            cout << "\n Error: Stack underflow! Expression might be invalid.\n";
            exit(1);
        }
        char val = top->data;
        CharNode* del = top;
        top = top->next;
        delete del;
        return val;
    }

    char peek() {
        return (top) ? top->data : '\0';
    }

    bool isEmpty() {
        return top == nullptr;
    }
};

// ---------------------------
// Expression Converter Class
// ---------------------------
class ExpressionConverter {
public:
    int precedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    string infixToPostfix(string infix) {
        CharStack st;
        string postfix = "";

        for (char c : infix) {
            // Case 1: Operand
            if (isalnum(c)) {
                postfix += c;
            }
            // Case 2: Opening bracket
            else if (c == '(') {
                st.push(c);
            }
            // Case 3: Closing bracket
            else if (c == ')') {
                // Pop until '(' is found
                while (!st.isEmpty() && st.peek() != '(') {
                    postfix += st.pop();
                }
                // If no '(' found -> unmatched ')'
                if (st.isEmpty()) {
                    cout << "\n Error: Unmatched ')' found in expression.\n";
                    exit(1);
                }
                st.pop(); // remove '('
            }
            // Case 4: Operator
            else {
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(c)) {
                    postfix += st.pop();
                }
                st.push(c);
            }
        }

        // After processing, check for leftover '('
        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                cout << "\n Error: Unmatched '(' found in expression.\n";
                exit(1);
            }
            postfix += st.pop();
        }

        return postfix;
    }
};

// ---------------------------
// Main function
// ---------------------------
int main() {
    ExpressionConverter converter;
    string infix;

    cout << "Enter infix expression: ";
    cin >> infix;

    string postfix = converter.infixToPostfix(infix);
    cout << "\nPostfix Expression: " << postfix << endl;

    return 0;
}