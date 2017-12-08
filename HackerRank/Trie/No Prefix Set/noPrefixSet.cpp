#include <iostream>
#include <map>
using namespace std;

class Trie {
    bool isWord;
    map<char, Trie*> children;
    public:
    Trie(): isWord(false), children({}){}
    ~Trie() {
        for(auto &child: children) {
            delete child.second;
        }
    }
    bool add_check(string s) {
        if((s.length()==0 && children.size()>0) || isWord) {
            return false;
        }
        if(s.length() == 0) {
            isWord = true;
            return true;
        }
        else {
            if(children.find(s[0]) == children.end()) {
                children[s[0]] = new Trie;
            }
            return children[s[0]]->add_check(s.substr(1));
        }
    }
};


int main() {
    Trie *myTrie = new Trie();
    int num_lines;
    bool bad = false;
    cin >> num_lines;
    string in;
    while(cin >> in) {
        if(!(myTrie->add_check(in))) {
            cout << "BAD SET" << endl;
            cout << in << endl;
            bad = true;
            break;
        }
    }
    if(!bad) {
        cout << "GOOD SET" << endl;
    }
    delete myTrie;
}

