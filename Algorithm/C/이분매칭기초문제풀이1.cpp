//이분 매칭 기초 문제풀이
//2188번 축사배정
#include<iostream>
#include<vector>
#define MAX 201

using namespace std;

vector<int> a[MAX];
int d[MAX];
bool c[MAX];
int n,m,s;

//매칭에 성공한 경우 True, 실패한 경우 False 
bool dfs(int x){
	for(int i = 0; i<a[x].size(); i++){
		int t = a[x][i];
		//이미 처리한 노드 볼 필요 없다.
		if(c[t]) continue;
		c[t] = true;
		//비어있거나 점유 노드에 더 들어갈 공간이 있는 경우
		if(d[t] == 0 || dfs(d[t])){
			d[t] =x;
			return true;
		} 
	}
	return false;
}

int main(void) {
	scanf("%d %d", &n, &m);
	for(int i = 1; i<=n; i++) {
		scanf("%d", &s);
		for(int j=1; j<=s; j++){
			int t;
			scanf("%d", &t);
			a[i].push_back(t);
		}
	}
	int count = 0;
	for(int i = 1; i<=n; i++) {
		//최대한 우겨 넣는다.
		fill(c, c+MAX, false);
		if(dfs(i)) count++;
	}
	printf("%d\n", count);
	return 0;
}
 
