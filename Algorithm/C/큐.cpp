//큐(Queue)
//선입선출
// 대표적인 자료구조의 일종
//은행같이 먼저 들어온 것이 먼저 나간다.
//터널과 같은 구조
//직접 구현보다 stl 라이브러리 사용하는 것이 효율적
 
#include<iostream>
#include<queue>

using namespace std;

int main(void){
	queue<int> q;
	q.push(1);
	q.push(2);
	q.push(3);
	q.pop();
	q.push(4);
	q.pop();
	while(!q.empty()){
		cout << q.front() + ' ';
		q.pop();
	}
	return 0;
}
