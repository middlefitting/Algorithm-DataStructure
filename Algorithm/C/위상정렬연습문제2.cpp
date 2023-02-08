//1516 위상정렬연습하기2 
//임계경로까지 구해야 한다. 위상정렬 심화 

#include <iostream>
#include<vector>
#include<queue>
#define MAX 501

using namespace std;

int n, inDegree[MAX], time[MAX], result[MAX];
vector<int> a[MAX]; //정점마다 연결 간선 넣을 수 있도록

void topologySort() {
	queue<int> q;
	//진입 차수가 0인 노드를 큐에 삽입
	for(int i = 1; i<=n; i++){
		if(inDegree[i] == 0){
			result[i] = time[i]; //차수가 0인 친구들은 기본 기초 시간값 
			q.push(i);
		}
	}
	
	//정렬이 완전히 수행되려면 정확히 n개의 노드를 방문합니다.
	for(int i=1; i<=n; i++){
		int x = q.front();
		q.pop();
		for(int j=0; j< a[x].size(); j++) {
			int y = a[x][j];
			//더 큰값 조건에 따라 결정 
			result[y] = max(result[y], result[x] + time[y]); //특정 간선에 대해 도착지 최소 비용과 최소시간에 도착시 시간 더한 것 비교 
			if(--inDegree[y] == 0){ 
				q.push(y);
			}
		}
	}
	
	for(int i = 1; i<=n; i++){
		printf("%d\n", result[i]);
	}
} 

int main(void) {
	scanf("%d", &n);
	for(int i = 1; i<=n; i++) {
		scanf("%d", &time[i]);
		while(1) {
			int x;
			scanf("%d", &x);
			if(x==-1) break;
			inDegree[i]++;
			a[x].push_back(i);
		}
	}
	topologySort();
}


