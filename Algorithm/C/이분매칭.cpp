//이분 매칭
//네트워크 플로우 알고리즘와 연계
//네트워크 플로우에서 특정 경우에서만 사용할 수 있는 것이 이분 매칭
//A집단과 B집단 오직 두 경우로 나뉘는 상황에서만 선택하는 방법이다.
//A집단이 B집단을 선택하는 방법에 대한 알고리즘
//기본 네트워크플로우로도 쓸 수도 있지만 보다 빠르고 효율적이다.
//가장 많이라는 개념은 네트워크 플로우 최대유량과 동일
//이분 매칭은 최대 유량을 구하는 문제와 같다고 할 수도 있다.
//에드몬드 카프 알고리즘은 O(V * E^2) == 정점 * 간선^2
//이분매칭은 훨씬 빠르다 == DFS로 푼다. // 깊이우선탐색 == O(V*E) 
//정점 곱하기 간선 ==dfs는 정점의 개수만큼 수행되는데 수행마다 간선처리 초기화, 간선 개수만큼 수행
//그냥 O(n^2)으로 보아도 된다. 
//겹칠 시에 다른 정점을 선택할 수 있는지 파악한다. 

#include<iostream>
#include<vector>
#define MAX 101

using namespace std;

vector<int> a[MAX]; //각 정점과 연결된 간선 정보들을 담는다. 
int d[MAX]; //특정 정점(ex 노트북) 점유하고 있는 노드 정보 
bool c[MAX]; //특정 정점 처리여부
int n = 3, m; //n은 정점의 개수, m은 간선의 개수 

//매칭에 성공한 경우 True, 실패한 경우 False
bool dfs(int x) {
	//연결된 모든 노드에 대해서 들어갈 수 있는 시도
	for(int i=0; i< a[x].size(); i++){
		int t = a[x][i];     
		//이미 처리한 노드는 더 이상 볼 필요가 없다.
		if(c[t]) continue;  
		c[t] =true;    
		//비어있거나 점유노드에 더 들어갈 공간이 있는 경우
		if(d[t] ==0 || dfs(d[t])){   
			d[t] = x; //들어갈 수 있는 경우에 매칭
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
	for(int i = 1; i<=n; i++){
		//매칭을 수행할 때마다 c값을 false로 초기화해준다. 
		fill(c, c+MAX, false);
		if(dfs(i)) count++;
	}
	printf("%d개의 매칭이 이루어졌습니다.\n", count);
	for(int i = 1; i<MAX; i++) {
		if(d[i] != 0){
			printf("%d -> %d\n", d[i], i); //d[1]를 점유하는 노드는 2이다, i=1을 점유한다.  
		}
	}
	return 0;
}
