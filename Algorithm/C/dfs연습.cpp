#include<bits/stdc++.h>

using namespace std;

vector<int> graph[8];
bool visited[8];

void dfs(int x){
	visited[x] = true;
	cout << x << ' ';
	
	for(int i; i<graph[x].size(); i++){
		int y = graph[x][i];
		if(!visited[y]){
			dfs(y);
		}
	}
}

main(void) {
	graph[1].push_back(2);
	graph[2].push_back(1);
	
	graph[1].push_back(3);
	graph[3].push_back(1);
	
	graph[2].push_back(3);
	graph[3].push_back(2);
	
	graph[2].push_back(4);
	graph[4].push_back(2);
	
	graph[2].push_back(5);
	graph[5].push_back(2);
	
	graph[4].push_back(5);
	graph[5].push_back(4);
	
	graph[3].push_back(6);
	graph[6].push_back(3);
	
	graph[3].push_back(7);
	graph[7].push_back(3);
	
	graph[6].push_back(7);
	graph[7].push_back(6);
	
	dfs(1);
}
