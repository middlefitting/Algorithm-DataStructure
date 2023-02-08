//강한 결합 요소 기초 문제풀이
//강한결합 요소는 서로 긴밀하게 연결된 정점간의 구륩을 의미합니다.
//강한 결합요소 안에 있는 요소들끼리는 서로에게 갈 수 있다. 
//3977 축구 전술 

#include <iostream>
#include<vector>
#include<stack>
#include<algorithm>
#define MAX 100001

using namespace std;

int n,m; 
int id, d[MAX];
//처리가된 노드 
bool finished[MAX];
vector<int> a[MAX];
vector<vector<int> > SCC;
stack<int> s;
int group[MAX];
bool inDegree[MAX];
vector<int> result;
 
//항상 처음 방문하는 노드만 실행. 즉 N번 수행
int dfs(int x){
	d[x] = ++id;
	s.push(x);
	
	//scc알고리즘 소스코드 
	int result = d[x];
	for(int i = 0; i<a[x].size(); i++){
		int y = a[x][i];
		//아직 방문하지 않은 이웃 노드의 경우
		if(d[y] ==0) result = min(result, dfs(y));
		//방문은 했지만 아직 처리중 이웃 노드
		else if(!finished[y]) result = min(result, d[y]);
	}
	
	//부모 노드가 자기 자신인 경우 SCC를 형성합니다.
	if(result ==d[x]){
		vector<int> scc;
		while(1) {
			int t = s.top();
			s.pop();
			scc.push_back(t);
			//특정 강한결합 속해있는 모든 원소들의 그룹값은  SCC크기에 1을 더해준 값 == 그룹 1 그룹 2 그룹3.. 
			group[t] = SCC.size() + 1;
			finished[t] = true;
			if(t==x) break;
		}
		SCC.push_back(scc);
	}
	//자신의 부모 값을 반환합니다.
	return result; 
}

int main(void) {
	int t; 
	scanf("%d", &t);
	while(t--){
		//테스트 케이스마다 초기화 
		SCC.clear();
		fill(d,d + MAX, 0);
		fill(finished, finished + MAX, 0);
		fill(inDegree, inDegree + MAX, false);
		result.clear();
		
		scanf("%d %d", &n, &m);
		for(int i = 1; i<=n; i++) {
			a[i].clear();
		}
		//도미노 여부 
		for(int i =0; i<m; i++) {
			int x, y;
			scanf("%d %d", &x, &y);
			//각 정점이 1부터 시작하게 만든다 
			a[x+1].push_back(y+1);
		}
		//dfs수행 
		for(int i =1; i<=n; i++){
			if(d[i] == 0) dfs(i);
		}
		for(int i = 1; i<=n; i++){
			for(int j = 0; j<a[i].size(); j++) {
				int y = a[i][j];
				//결국 올려놨으니 그럴수밖에 없다. 
				if(group[i] != group[y]){
					//진입 차수가 존재 
					inDegree[group[y]] = true;
				}
			}
		}
		int count = 0;
		for(int i = 0; i<SCC.size(); i++) {
			//특정한 scc에 진입차수 없는 경우 
			if(!inDegree[i+1]){
				count++;
				for(int j=0; j<SCC[i].size(); j++) {
					result.push_back(SCC[i][j] - 1);
				}
			}
		}
		sort(result.begin(), result.end());
		if(count != 1) {
			printf("Confused\n\n");
		}else{
			for(int i = 0; i<result.size(); i++) {
				printf("%d\n", result[i]);
			}
			printf("\n");
		}
	}
	return 0;
}

