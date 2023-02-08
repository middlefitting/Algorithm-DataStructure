//이분 매칭 기초 문제풀이2
//11375번 열혈강호

#include<iostream>
#include<vector>
#define MAX 1001

using namespace std;

int n,m,s;

bool c[MAX];
int d[MAX];
vector<int> a[MAX];

bool dfs(int x){
	for(int i =0; i<a[x].size(); i++){
		int t = a[x][i];
		if(c[t]) continue;
		c[t] = true;
		
		if(d[t] == 0 || dfs(d[t])){
			d[t] = x;
			return true;
		}
	}
	return false;
}

int main(void){
	scanf("%d %d", &n, &m);
	
	for(int i=1; i<=n; i++){
		scanf("%d", &s);
		for(int j=1; j<=s; j++){
			int t;
			scanf("%d", &t);
			a[i].push_back(t);
		}
	}
	
	int count=0;
	for(int i=1; i<=n; i++){
		fill(c, c+MAX, false);
		if(dfs(i)) count++; 
	}
	
	printf("%d", count);
	return 0;
}
