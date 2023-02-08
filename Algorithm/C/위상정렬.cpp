//위상 정렬
//순서가 정해져 있는 작업을 수행해야 할 때 그 순서를 결정해주기 위해 사용하는 알고리즘
//위상정렬은 DAG (방향그래프인데 사이클이 존재하지 않는 그래프) 에서만 사용 가능
//위상정렬은 기본적으로 시작점이 존재해야 한다. 
//위상 정렬 알고리즘은 위상 정렬의 가능여부와 가능하다면 그 결과를 해결책으로 제시한다.
//스택 혹은 큐를 이용하는데 기본적으로 스택보다는 큐를 선호한다.
//진입차수: 특정한 노드가 있을 때 그 노드로 들어오는 개수 
//시간 복잡도는 정점의 갯수 + 간선의 갯수만큼 소요 == O(V+E)

#include <iostream>
#include <vector>
#include <queue>
#define MAX 10

using namespace std;

int n, inDegree[MAX]; //진입차수 정보
vector<int> a[MAX]; //각 정점에 연결된 모든 노드 정보들을 담을 수 있도록

void topologySort() {
	int result[MAX];
	queue<int> q;
	
	//진입 차수가 0인 노드를 큐에 삽입합니다.
	for(int i = 1; i<=n; i++) {
		if(inDegree[i] == 0) q.push(i);
	}
	//위상 정렬이 완전히 수행되려면 정확히 N개의 노드를 방문합니다.
	for(int i=1; i<=n; i++) {
		//n개를 방문하기 전에 큐가 빈다면 사이클이 발생
		if(q.empty()) {
			printf("사이클이 발생했습니다");
			return;
		}
		int x = q.front();
		q.pop();
		result[i] =x; //큐에서 꺼낸 순서가 곧 위상정렬 수행 결과 
		
		//연결된 모든 정점들을 확인하며 모든 간선들을 지운다. ==진입차수를 1빼준다 
		for(int j = 0; j<a[x].size(); j++){
			int y = a[x][j];
			//새롭게 진입차수가 0이된 정점을 큐에 삽입합니다 
			if(--inDegree[y] ==0) {
				q.push(y);
			}
		}
	}
	for(int i = 1; i<=n; i++) {
		printf("%d ", result[i]);
	}
	 
}

int main(void) {
	n = 7;
	a[1].push_back(2);
	inDegree[2]++;
	a[1].push_back(5);
	inDegree[5]++;
	a[2].push_back(3);
	inDegree[3]++;
	a[3].push_back(4);
	inDegree[4]++;
	a[4].push_back(6);
	inDegree[6]++;
	a[5].push_back(6);
	inDegree[6]++;
	a[6].push_back(7);
	inDegree[7]++;
	
	topologySort();
	
	printf("\n");
	int pp = 100;
	if(--pp ==0){ //이걸 if문에 써줘도 --가 들어간다. 
		printf("case1: %d", pp);
	}else{
		printf("case2: %d", pp);
	}
	printf("case3: %d", pp);
	
}
