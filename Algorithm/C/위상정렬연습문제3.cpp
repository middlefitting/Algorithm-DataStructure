//1948 위상정렬연습하기3
//임계경로까지 구해야 한다. 위상정렬 심화
//역추적을 해야 한다.
//일방통행이고 사이클이 없다 == 위상정렬의 기본조건
//1분도 쉬지 않는다 == 가장 오랜 시간이 걸리는 사람 == 임계경로

#include<iostream>
#include<vector>
#include<queue>
#define MAX 10001

using namespace std;

class Edge{
public:
	int node;
	int time;
	Edge(int node, int time) {
		this -> node = node;
		this -> time = time;
	}
};

int n, start, finish;
int inDegree[MAX], result[MAX], c[MAX]; //c에는 처리가 되었는지 여부
vector<Edge> a[MAX];// 시작에서 도착점으로 가는것 
vector<Edge> b[MAX]; //역추적을 위해 사용 //도착점에서 시작점으로 가는 것

void topologySort() {
	queue<int> q;
	//시작점 노드 큐에 삽입
	q.push(start);
	//더이상 방문할 노드가 없을 때까지
	//정점에 연결되어 있는 노드들을 하나씩 처리 
	while(!q.empty()){
		int x = q.front();
		q.pop();
		for(int i = 0; i<a[x].size(); i++){
			//노드와 시간값을 받는다. 
			Edge y = Edge(a[x][i].node, a[x][i].time);
			if(result[y.node] <=y.time + result[x]){
				result[y.node] = y.time + result[x];
			}
			//새롭게 진입차수가 0이  된 정점을 큐에 삽입
			if(--inDegree[y.node] ==0){
				q.push(y.node);
			} 
		}
	}
	
	//결과를 역추적합니다.
	int count = 0;
	q.push(finish);
	while(!q.empty()){
		int y = q.front();
		q.pop();
		for(int i = 0; i<b[y].size(); i++){
			Edge x = Edge(b[y][i].node, b[y][i].time);
			//최장 경로에 포함되는 간선인지 확인합니다.
			//최장 경로에 포함되는 간선일때만 추적 
			if(result[y] - result[x.node] == x.time) {
				count++;
				//큐에는 한 번씩 담아 추적
				if(c[x.node] == 0){
					q.push(x.node);
					//처리된 노드는 1 
					c[x.node] = 1;
				} 
			}
		}
	}
	printf("%d\n%d", result[finish], count);
}

int main(void) {
	int m;
	scanf("%d %d", &n, &m);
	for(int i = 0; i<m; i++) {
		int x, node, time;
		scanf("%d %d %d", &x, &node, &time);
		a[x].push_back(Edge(node,time));
		b[node].push_back(Edge(x,time));
		inDegree[node]++;	
	}
	scanf("%d %d", &start, &finish);
	topologySort();
}



 
