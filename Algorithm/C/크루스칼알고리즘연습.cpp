#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int getParent(int parent[], int x){
	if(parent[x] == x) return x;
	return getParent(parent , parent[x]);
}

void unionParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);
	if(a<=b) parent[b] = a;
	else parent[a] = b;
}

int findParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);
	if(a == b){
		return 1;
	}
	else{
		return 0;
	}
}

class Edge {
public:
	int node[2];
	int distance;
	
	Edge(int a, int b, int distance){
		this -> node[0] = a;
		this -> node[1] = b;
		this -> distance = distance;
	}	
	//정렬기준 거리가 짧은 순 
	bool operator<(Edge & edge){
		return this ->distance < edge.distance; 
	}
};

int main(void){
	int m = 11;
	int n = 7;
	
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
	
	//v오름차순 정렬 
	sort(v.begin(), v.end());
	
	int parent[n];
	
	for(int i=0; i<=n; i++){
		parent[i] = i;
	}
	
	int sum = 0;
	
	for(int i = 1; i<=v.size(); i++){
		if(!findParent(parent, v[i].node[0], v[i].node[1])){
			sum += v[i].distance;
			unionParent(parent, v[i].node[0], v[i].node[1]);
		}	
	}
	
	printf("%d\n", sum);
}
