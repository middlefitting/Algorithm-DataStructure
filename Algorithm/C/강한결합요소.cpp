//강한 결합 요소 SCC
//강하게 결합된 정점 집합을 의미합니다.
//같은 SCC에 속하는 두 정점은 서로 도달이 가능하다.
//서로가 서로에게 갈 수 있으면 같은 SCC에 속한다고 할 수 있다.
//사이클이 발생하면 무조건 SCC
//방향 그래프일때만 의미가 있다
//코사라주 알고리즘과 타잔 알고리즘이 존재
//타잔 알고리즘이 적용이 용이하다.
	//부모로 돌아올 수 있어야 SCC가 성립될 수 있다 
//부모에서 자식으로 나가는 DFS 알고리즘 //깊이 우선 탐색 
//DFS가 끝나지 않은 상황에서 스택에 있는 원소로 돌아갈 수 있다면 해당 원소가 자신의 부모라는 것을 인지할 수 있다.
	//스택에서 자기 자신이 나올때까지 뽑는다 == SCC 집합이 된다
	//같은 부모를 가지는 노드끼리 SCC의 집합이 되는 것이다.
//일반적으로 작은 숫자를 부모로 하는게 일관적 

#include<iostream>
#include<vector>
#include<stack>
#define MAX 10001

using namespace std;

int id, d[MAX]; //노드마다 고유 번호 할당 
bool finished[MAX]; //현재 특정한 노드의 대한 DFS 끝났는지 확인
vector<int> a[MAX]; //인접 노드 배열을 담는다
vector<vector<int> > SCC; //한 그래프에서 여러개 나올 수 있으니까 2차원으로
stack<int> s; //스택 객체를 하나 만든다 

//DFS는 총 정점의 갯수만큼 실행
//특정한 노드로 DFS 수행
int dfs(int x) {
	d[x] = ++id; //맨처음 부모값    //1 2 3
	s.push(x); //스택에 자기 자신을 삽입    //1
	 
	int parent = d[x]; //맨 처음에는 자기 자신이 부모가 된다   //1
	//인접한 노드를 하나씩 확인
	for(int i = 0; i<a[x].size(); i++) {
		int y = a[x][i]; //y는 인접한 노드 자체를 가리키도록 한다    //2 3 //제일 작은 친구가 나왔을때 dfs가 멈추게 된다.  
		//만약 해당 노드를 방문한 적이 없다면 //1
		if(d[y] ==0) parent = min(parent, dfs(y)); //해당 노드로 DFS 수행 //결과적으로 더 작은 값으로 부모를 가지도록 한다   //
		//방문은 했지만 아직 처리를 하지 않았을 경우//현재 DFS를 수행하고 있는 노드
		//처리되고 있는 값의 부모와 비교해서 더 작은 값을 부모로 //이웃에게 dfs 수행이 아니라 현재까지 구해진 d[y]를 통해 수행 
		else if(!finished[y]) parent =  min(parent, d[y]); 
	} 
	
	//부모노드가 자기 자신인 경우
	if(parent == d[x]) {
		//스택에서 꺼내서 SCC를 만들어준다
		//하나의 scc를 만든 다음 자기 자신이 나올 때까지
		vector<int> scc;
		while(1) {
			int t = s.top();
			s.pop();
			scc.push_back(t); //3 //2 //1
			finished[t] = true;
			if(t ==x) break; //자기 자신==부모값이 나온경우 중지 
		}
		SCC.push_back(scc); //만들어진 scc를 전체 SCC에 담아준다. 
	}
	
	//자신의 부모값 반환
	return parent; 
}

int main(void) {
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
	
	for(int i = 1; i<=v; i++ ) { 
		if(d[i] ==0) dfs(i); 
	}
	
	printf("SCC의 갯수: %d\n", SCC.size());
	for(int i = 0; i<SCC.size(); i++) {
		printf("%d번째 SCC: ", i+1);
		for(int j=0; j<SCC[i].size(); j++) {
			printf("%d ", SCC[i][j]);
		}
		printf("\n");
	}
	
	return 0;
}

//SCC와 위상정렬의 개념을 통해 SCC를 위상정렬할 수 있다.
//각 SCC 그룹을 정점으로 사용해서 위상 정렬을 수행하는 것이다.
//시간 복잡도는 O(V+E) 이다.
//위상 정렬의 시간 복잡도와도 동일합니다.
 
 

