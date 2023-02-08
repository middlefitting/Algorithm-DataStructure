//강한 결합요소 연습
#include<iostream>
#include<vector>
#include<stack>
#define MAX 10001

using namespace std;

int id, d[MAX];
bool finished[MAX];
vector<int> a[MAX];
vector<vector<int> > SCC;
stack<int> s;

int dfs(int x){
	d[x] = ++id;
	int parent = d[x];
	s.push(x);
	
	for(int i=0; i<a[x].size(); i++){
		int y = a[x][i];
		if(d[y] ==0) parent = min(parent, dfs(y));
		else if(!finished[y]) parent = min(parent, d[y]);
	}
	
	if(parent == d[x]){
		vector<int> scc;
		while(1){
			int t = s.top();
			s.pop();
			finished[t] = true;
			scc.push_back(t);
			if(t == x) break;
		}
		SCC.push_back(scc);
	}
	
	return parent;
}




int main(void){
	int v = 11;
	a[1].push_back(2);
	a[2].push_back(3);
	a[3].push_back(1);
	a[4].push_back(2);
	a[4].push_back(5);
	a[5].push_back(7);
	a[6].push_back(5);
	a[7].push_back(6);
	a[8].push_back(5);
	a[8].push_back(9);
	a[9].push_back(10);
	a[10].push_back(11);
	a[11].push_back(3);
	a[11].push_back(8);
	
	for(int i=1; i<=v; i++){
		if(d[i]==0) dfs(i);
	}
	
	printf("SCC의 갯수: %d\n", SCC.size());
	for(int i=0; i<SCC.size(); i++){
		printf("%d번째 SCC: ", i+1);
		for(int j=0; j<SCC[i].size(); j++){
			printf("%d ", SCC[i][j]);
		}
		printf("\n");
	}
}
