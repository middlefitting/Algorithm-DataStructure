//깊이 우선 탐색(DFS)
//맹목적으로 각 노드를 탐색할 때 주로 사용된다.
// 스택이 사용된다.
//스택을 사용하지 않아도 구현이 ㄱ능한데 컴퓨터는 구조적으로 항상 스택의 원리를 사용하기 때문이다.
//스택의 최상단 노드를 확인하고
//인접노드중 방문하지 않은 노드가 있다면 노드를 스택에 넣고 방문처리합니다.
// 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 뺀다.
//인접 노드중 가장 작은 수에 방문한다
//재귀함수를 통해 구현한다
//dfs도 자체로는 큰 의미가 없으며 활용하는 것에 중점을 두면 된다.
//스택을 사용하지 않고 재귀함수를 사용하는 것이 더 많이 사용하는 방법이다. 

#include <iostream>
#include <vector>

using namespace std;

int number = 7;
int c[8]; //방문처리용
vector<int> a[8]; //각각 인접 노드를 가질 수 있도록

void dfs(int x){
	if(c[x]) return; //방문했다면 함수 끝냄 
	c[x] = true; //처음방문하는 거라면 방문처리 
	cout << x << ' '; //해당 노드를 출력 
	for(int i=0; i<a[x].size(); i++){ //인접노드 하나씩 방문 
		int y = a[x][i]; //인접노드에 대해서 
		dfs(y); //dfs 수행 
	}
} 

int main(void) {
	a[1].push_back(2);
	a[2].push_back(1);
	
	a[1].push_back(3);
	a[3].push_back(1);
	
	a[2].push_back(3);
	a[3].push_back(2);
	
	a[2].push_back(4);
	a[4].push_back(2);
	
	a[2].push_back(5);
	a[5].push_back(2);
	
	a[4].push_back(5);
	a[5].push_back(4);
	
	a[3].push_back(6);
	a[6].push_back(3);
	
	a[3].push_back(7);
	a[7].push_back(3);
	
	a[6].push_back(7);
	a[7].push_back(6);
	
	dfs(1);
}


