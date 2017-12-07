#include <iostream>
#include <map>
using namespace std;

class Node {
  int num_child;
  bool isWord;
  map<char, Node*> children;
public:
  Node(): num_child(0), isWord(false) {}
  ~Node(){
    for(auto &child: children) {
      delete child.second;
    }
  }
  void add(string s) {
    num_child++;
    if(s.length() == 0) {
      isWord = true;
      return;
    }
    else {
      if(!children[s[0]]) {
        children[s[0]] = new Node();
      }
      children[s[0]]->add(s.substr(1));
    }
  }

  int findNumExist(string s) {
    int sum=0;
    if(s.length() == 0) {
      sum += num_child;
      return sum;
    }
    else {
      map<char,Node *>::const_iterator it = children.find(s[0]);
      if(it!=children.end()) {
        sum = children[s[0]]->findNumExist(s.substr(1));
      }
      else {
        return 0;
      }
    }
    return sum;
  }
};


int main() {
  Node *trie= new Node();
  int n;
  cin >> n;
  string in;
  while(cin >> in) {
    if(in == "add") {
      cin >> in;
      trie->add(in);
    }
    else if(in == "find") {
      cin >> in;
      cout << trie->findNumExist(in) << endl;
    }
  }
  delete trie;
}
