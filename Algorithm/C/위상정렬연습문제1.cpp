//2252 위상정렬연습하기

#include <iostream>
#include<vector>
#include<queue>
#define MAX 32001

using namespace std;

int n, inDegree[MAX], result[MAX];
vector<int> a[MAX]; //정점마다 연결 간선 넣을 수 있도록

void topologySort() {
	queue<int> q;
	//진입 차수가 0인 노드를 큐에 삽입
	for(int i = 1; i<=n; i++){
		if(inDegree[i] == 0){
			q.push(i);
		}
	}
	
	//정렬이 완전히 수행되려면 정확히 n개의 노드를 방문합니다.
	for(int i=1; i<=n; i++){
		int x = q.front();
		q.pop();
		result[i] = x;
		for(int j=0; j< a[x].size(); j++) {
			int y = a[x][j];
			if(--inDegree[y] == 0){
				q.push(y);
			}
		}
	}
	
	for(int i = 1; i<=n; i++){
		printf("%d ", result[i]);
	}
} 

int main(void) {
	int m;
	scanf("%d %d", &n, &m);
	for(int i = 0; i<m; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		a[x].push_back(y);
		inDegree[y]++;
	}
	topologySort();
}

