//이분매칭 연습

#include<iostream>
#include<vector>
#define MAX 101

using namespace std;

int n=3;
int d[MAX];
bool c[MAX];
vector<int> a[MAX];

bool dfs(int x){
	for(int i=0; i<a[x].size(); i++){
		int t = a[x][i];
		if(c[t]) continue;
		c[t] = true;
		if(d[t]==0 || dfs(d[t])){
			d[t] = x;
			return true;
		}
	}
	return false;
}

int main(void) {
	a[1].push_back(1);
	a[1].push_back(2);
	a[1].push_back(3);
	a[2].push_back(1);
	a[3].push_back(2);
	
	int count = 0;
	
	for(int i =1; i<=n; i++){
		fill(c, c+MAX, 0);
		if(dfs(i)){
			count++;
		}
	}
	
	printf("총 갯수는 다음과 같습니다: %d\n", count);
	for(int i=1; i<=n; i++){
		printf("%d -> %d \n", d[i], i);
	}
}
