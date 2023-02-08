#include<bits/stdc++.h>
using namespace std;

vector<int> a[8];
bool visited[8];

void bfs(int x){
	queue<int> bfsQueue;
	bfsQueue.push(x);
	visited[x] = true;
	
	while(!bfsQueue.empty()){
		int now = bfsQueue.front();
		bfsQueue.pop();
		cout << now << ' ';
		
		for(int i=0; i<a[now].size(); i++) {
			int toAppend = a[now][i];
			if(!visited[toAppend]){
				bfsQueue.push(toAppend);
				visited[toAppend] = true;
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
}
