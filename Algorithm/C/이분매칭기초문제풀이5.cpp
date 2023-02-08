//이분매칭 기초 문제풀이3 
//이분 매칭 기초 문제풀이5
//1671 상어들의 저녁식사 

#include<iostream>
#include<vector>
#define MAX 51

using namespace std;

bool c[MAX];
int stat[MAX][3]; 
int d[MAX];
vector<int> a[MAX];
int n;

bool dfs(int x){
	for(int i = 0; i<a[x].size(); i++) {
		int y = a[x][i];
		if(c[y]) continue;
		c[y] = true;
		if(d[y] == 0 || dfs(d[y])){
			d[y] = x;
			return true;
		}
	}
	return false;
}

int main(void) {
	scanf("%d", &n);
	for(int i = 1; i<=n; i++) {
		int a,b,c;
		scanf("%d %d %d", &stat[i][0], &stat[i][1], &stat[i][2]);
	}
	for(int i = 1; i<=n-1; i++) {
		for(int j = i+1; j<=n; j++) {
			if(stat[i][0] == stat[j][0] && stat[i][1] == stat[j][1] && stat[i][2] == stat[j][2]){
				a[i].push_back(j);
//				a[j].push_back(i); //완벽하게 같은 경우 서로를 잡아먹을 수 있는데 그건 말이 안되니까 하나만 강제한다 
			}else if(stat[i][0] >= stat[j][0] && stat[i][1] >= stat[j][1] && stat[i][2] >= stat[j][2]){
				a[i].push_back(j);
			}else if(stat[i][0] <= stat[j][0] && stat[i][1] <= stat[j][1] && stat[i][2] <= stat[j][2]){
				a[j].push_back(i);
			}
		}
	}
	int count = 0;
	for(int k = 0; k<2; k++){
		for(int i =1; i<=n; i++){
			fill(c, c+MAX, false);
			if(dfs(i)) count++; 
		}
	}
		
	printf("%d\n", n-count);
	return 0;
}
