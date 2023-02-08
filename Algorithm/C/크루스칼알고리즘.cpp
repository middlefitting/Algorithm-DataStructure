//크루스칼 알고리즘
//가장 적은 비용으로 모든 노드를 하나로 연결하기 위해 사용하는 알고리즘
// 여러개의 도시가 있을 때 도시를 도로를 이용해 연결하고자 할 때 비용을 최소한으로 하고자 할 때 실제로 적용
//노드 == 정점: 그래프에서 동그라미 
//간선 ==거리 == 비용: 그래프에서 선
//간선의 개수는 반드시 노드 개수에서 1개를 뺀 값이어야 한다.
//간선을 거리가 짧은 순서대로 그래프에 포함시키면 어떨까
//사이클이 발생하지 않도록 조심하여야 한다.
//사이클이 발생하지 않는 경우에만 포함시킨다.
//사이클 여부는 합집합 알고리즘으로 find 해서 찾으면된다
//최소 신장트리를 통해 얼마나 적은 비용으로 모든 노드를 연결할 수 있는지 알려주는 프로그램 
//자주출제 

#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm> 

using namespace std;

int getParent(int parent[], int x){
	if(parent[x] == x) return x;
	return getParent(parent, parent[x]);
} 

int unionParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);
	if(a<b) parent[b] = a;
	else parent[a] = b;
}

int findParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);
	
	if(a==b) return 1;
	else return 0;
}

class Edge{
public:
	int node[2];
	int distance;
	Edge(int a, int b, int distance) {
		this->node[0] = a;
		this->node[1] = b;
		this->distance = distance;
	}
	bool operator <(Edge & edge) {
		return this->distance  < edge.distance; //거리가 작은게 출력되도록 
	}
};

int main(void) {
	int n = 7;
	int m = 11;
	
	vector<Edge> v;
	v.push_back(Edge(1,7,12));
	v.push_back(Edge(1,4,28));
	v.push_back(Edge(1,2,67));
	v.push_back(Edge(1,5,17));
	v.push_back(Edge(2,4,24));
	v.push_back(Edge(2,5,62));
	v.push_back(Edge(3,5,20));
	v.push_back(Edge(3,6,37));
	v.push_back(Edge(4,7,13));
	v.push_back(Edge(5,6,45));
	v.push_back(Edge(5,7,73));
	
	//간선의 비용을 기준으로 오름차순 정렬
	sort(v.begin(), v.end());
	
	//각 정점이 포함된 그래프가 어디인지 저장
	int parent[n];
	for(int i =0; i<n; i++) {
		parent[i] = i;
	}
	
	int sum = 0;
	for(int i=0; i<v.size(); i++){
		//사이클이 발생하는 경우는 무시 
		if(!findParent(parent, v[i].node[0]-1, v[i].node[1] -1)) {
			sum += v[i].distance; //해당 거리만큼 결과값 더해주고 
			unionParent(parent, v[i].node[0]-1, v[i].node[1] -1); //실제 노드를 연결 
		}
	}
	printf("%d\n", sum);
}
