//위상정렬연습하기3 연습
#include<iostream>
#include<vector>
#include<queue>
#define MAX 100001

using namespace std;

class Edge{
public:
	int node;
	int time;
	Edge(int node, int time){
		this -> node = node;
		this -> time = time;
	}
};

int n, start, finish;
int inDegree[MAX], result[MAX], c[MAX];
vector<Edge> a[MAX];
vector<Edge> b[MAX];

void topologySort(){
	queue<int> q;
	q.push(start);
	
	while(!q.empty()){
		int x = q.front();
		q.pop();
		for(int i=0; i<a[x].size(); i++) {
			Edge y = Edge(a[x][i].node, a[x][i].time);
			result[y.node] = max(result[y.node], result[x] + y.time);
		
			if(--inDegree[y.node] == 0){
				q.push(y.node);
			}
		}
	}
	
	int count = 0;
	q.push(finish);
	while(!q.empty()){
		int x = q.front();
		q.pop();
		for(int i=0; i<b[x].size(); i++){
			Edge y = Edge(b[x][i].node, b[x][i].time); //y가 더 앞 
			if(result[x] - result[y.node] == y.time){
				++count;
				if(c[y.node] == 0){
					q.push(y.node);
					c[y.node] =1;
				}
			}
		}
	}
	
	printf("%d\n%d", result[finish], count);
}

int main(void){
	int m;
	scanf("%d %d", &n, &m);
	for(int i =0; i<m; i++){
		int x, node, time;
		scanf("%d %d %d", &x, &node, &time);
		a[x].push_back(Edge(node, time));
		b[node].push_back(Edge(x, time));
		inDegree[node]++;
	}
	scanf("%d %d", &start, &finish);
	
	topologySort();
	
}
