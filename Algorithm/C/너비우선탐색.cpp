//너비 우선 탐색(BFS)
//탐색을 할 때 너비를 우선으로 하여 탐색을 수행하는 탐색 알고리즘
// 시작점과 가까운 것 위주로 탐색을 하겠다는 것
//BFS는 맹목적인 탐색을 하겠다는 알고리즘
//큐가 필요하다
//선입선출이 필요
//미로찾기 같은 알고리즘에서 사용된다.
//너비우선 탐색을 할 때는 처음 노드 1을 큐에 넣어주면 된다.
//방문처리도 해야 한다.
// 큐에서 노드를 꺼내고, 노드에서 연결된 노드중 방문하지 않은 노드를 방문하고 차례대로 큐에 삽입합니다.
// 인접 노드를 모두 방문한다는 것이 핵심!
//루트와 거리가 가까운것 먼저 탐색이 이루어진다. 

//자체로는 의미가 없고 다른 알고리즘에 이것을 이용해서 적용한다는 것이 핵심이다.
//bfs는 탐색 방법중에 하나인 셈이다. 

#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int number = 7;
int c[8];
vector<int> a[8]; //벡터가 들어갈 배열을 만들어줌 각 노드 인덱스가 1부터 처리되도록 하게하기 위해 8개 공간 할당

void bfs(int start){
	queue<int> q;
	q.push(start);
	c[start] = true;
	while(!q.empty()){
		int x = q.front(); //1
		q.pop();
		printf("%d ", x); //1출력 
		for(int i = 0; i< a[x].size(); i++){
			int y = a[x][i]; //2
			if(!c[y]){
				q.push(y);
				c[y] = true;
			}
		}
	}
} 

int main(void){
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
	
	bfs(1);
	
	return 0;
}
