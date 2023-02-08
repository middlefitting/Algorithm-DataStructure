#include<iostream>
#include<stack>

using namespace std;

int main(void){
	stack<int> s;
	
	s.push(6);
	s.push(7);
	s.push(5);
	s.pop();
	s.push(1);
	s.pop();
	s.pop();
	
	while(!s.empty()){
		cout << s.top() << ' ';
		s.pop();
	}
}
