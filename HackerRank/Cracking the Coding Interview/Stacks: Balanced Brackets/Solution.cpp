#include <stack>
#include <string>
#include <iostream>

using namespace std;

bool is_balanced(string expression) {
    std::stack<char> brackets;
    char one[] = {'(', ')'};
    char two[] = {'{', '}'};
    char three[] = {'[', ']'};
    int len = expression.length();

    for(int i=0; i<len; i++) {
        if(expression[i] == one[0]) {
            brackets.push(one[0]);
        }
        else if(expression[i] == two[0]) {
            brackets.push(two[0]);
        }
        else if(expression[i] == three[0]) {
            brackets.push(three[0]);
        }
        else if(expression[i] == one[1]) {
            if(brackets.empty() || brackets.top() != one[0]) {
                return false;
            }
            else {
                brackets.pop();
            }
        }
        else if(expression[i] == two[1]) {
            if(brackets.empty() || brackets.top() != two[0]) {
                return false;
            }
            else {
                brackets.pop();
            }
        }
        else if(expression[i] == three[1]) {
            if(brackets.empty() || brackets.top() != three[0]) {
                return false;
            }
            else {
                brackets.pop();
            }
        }
    }
    if(brackets.empty()){
        return true;
    }
    else{
        return false;
    }
}

int main(){
    int t;
    cin >> t;
    for(int a0 = 0; a0 < t; a0++){
        string expression;
        cin >> expression;
        bool answer = is_balanced(expression);
        if(answer)
            cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}
