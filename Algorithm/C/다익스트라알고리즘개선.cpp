//다익스트라 알고리즘 heap 사용하기
#include<iostream>
#include<vector>
#include<queue>
//우선순위 큐를 사용하기 위해 사용 ==> 내부적으로 heap과 같은 방식으로 작동한다. 

using namespace std;

int number = 6;
int INF = 1000000000;

//자신과 연결된 노드들을 모두 pair 형태로 저장할 수 있도록 만든다 
vector<pair<int, int> > a[7];
int d[7]; //최소비용

void dijkstra(int start) {
	d[start] = 0;
	priority_queue<pair<int, int> > pq; // 힙구조를 만들 수 있도록
	pq.push(make_pair(start, 0));
	
	//가까운 순서대로 처리하므로 큐를 사용
	while(!pq.empty()){
		int current = pq.top().first; //최상단 값 사용// 한쌍의 값이 사용 //가장 적은 비용 가지는 노드의 정보를 가지고 있다
		//짧은 것이 먼저 오도록 음수화
		int distance = -pq.top().second; //처음에 0이뽑힘 
		pq.pop();
		//최단 거리가 아닌 경우 스킵
		if(d[current] < distance) continue; //처음에는 무한이니 실행 
		for(int i = 0; i<a[current].size(); i++){ //1.size => 3개나옴 
			//선택된 노드의 인접 노드
			int next = a[current][i].first; // 처음에 2, 2에서 2뽑힘 
			//선택된 노드 거쳐서 인접 노드로 가는 비용
			int nextDistance = distance + a[current][i].second; //0 + 2 
			//기존의 최소 비용보다 더 저렴하다면 교체합니다.
			if(nextDistance < d[next]){ //2 < INF
				d[next] = nextDistance; //d[2] = 2
				//음수화해서 넣어줘야 한다. //더 작은 비용이 위쪽으로 가도록 해야 하기 때문이다. //오름차순으로 정렬된다. 
				pq.push(make_pair(next, -nextDistance));  // 2, -2
			}
		} 
		 
		 
	}  
} 

int main(void) {
	//기본적 연결되지 않은 경우 무한 비용
	for(int i = 1; i<=number; i++) {
		d[i] = INF;
	} 
	
	a[1].push_back(make_pair(2, 2));
	a[1].push_back(make_pair(3, 5));
	a[1].push_back(make_pair(4, 1));
	
	a[2].push_back(make_pair(1, 2));
	a[2].push_back(make_pair(3, 3));
	a[2].push_back(make_pair(4, 2));
	
	a[3].push_back(make_pair(1, 5));
	a[3].push_back(make_pair(2, 3));
	a[3].push_back(make_pair(4, 3));
	a[3].push_back(make_pair(5, 1));
	a[3].push_back(make_pair(6, 5));
	
	a[4].push_back(make_pair(1, 1));
	a[4].push_back(make_pair(2, 2));
	a[4].push_back(make_pair(3, 3));
	a[4].push_back(make_pair(5, 1));
	
	a[5].push_back(make_pair(3, 1));
	a[5].push_back(make_pair(4, 1));
	a[5].push_back(make_pair(6, 2));
	
	a[6].push_back(make_pair(3, 5));
	a[6].push_back(make_pair(5, 2));
	
	dijkstra(1);
	
	//결과를 출력
	for(int i = 1; i<=number; i++){
		printf("%d ", d[i]);
	} 
}
