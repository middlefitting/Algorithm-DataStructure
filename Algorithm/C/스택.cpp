//stack(스택) 
//후입선출
//자료구조는 데이터의 기반 구조를 처리하는 방법에 대한 내용
//알고리즘은 이러한 스택이나 큐를 이용해서 문제를 해결하는 방법
// 스택은 라이브러리 및 직접 구현해서 사용
// 대회에서는 라이브러리를 사용하는 것이 일반적

#include<iostream>
#include<stack>

using namespace std;

int main(void){
	stack<int> s;
	s.push(7);
	s.push(5);
	s.push(4);
	s.pop(); //꺼낸다
	s.push(6); 
	s.pop();
	while(!s.empty()){
		cout << s.top() << ' '; //맨 위를 출력
		s.pop(); //출력이후 해당 데이터 꺼낼 수 있도록 pop한다. 
	}
}
 
