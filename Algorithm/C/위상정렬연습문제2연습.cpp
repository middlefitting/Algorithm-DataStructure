#include<iostream>
#include<vector>
#include<queue>
#define MAX 501

using namespace std;

int n, inDegree[MAX], time[MAX], result[MAX];
vector<int> a[MAX];

void topologySort(){
	queue<int> q;
	
	for(int i=1; i<=n; i++) {
		if(inDegree[i]==0){
			result[i] = time[i];
			q.push(i);
		}
	}
	
	while(!q.empty()){
		int x = q.front();
		q.pop();
		for(int i = 0; i<a[x].size(); i++){
			int y = a[x][i];
			result[y] = max(result[y], result[x] + time[y]);
			
			if(--inDegree[y] == 0){
				q.push(y);
			}
		}
	}
	
	for(int i=1; i<=n; i++){
		printf("%d\n", result[i]);
	}
}

int main(void){
	scanf("%d", &n);
	
	for(int i=1; i<=n; i++) {
		scanf("%d", &time[i]);
		while(1){
			int x;
			scanf("%d", &x);
			if(x==-1) break;
			++inDegree[i];
			a[x].push_back(i);
		}
	}
	
	topologySort();
}
