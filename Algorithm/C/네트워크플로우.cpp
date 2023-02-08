//네트워크 플로우
//특정한 지점에서 다른 지점으로 데이터가 얼마나 많이 흐르고 있는가를 측정하는 알고리즘
//표현방식 : 유량/용량 
//실제로 흘러가는 데이터의 양 == 유량
//경로에서 가장 적은 용량이 최적 유량
//최대 유량 문제는 각 간선에 정해진 용량이 있을 때 A에서 B로 최대로 보낼 수 있는 유량의 크기를 구하는 문제입니다.
//BFS 너비우선 탐색을 이용 == 에드몬드 카프 알고리즘
//모든 가능한 유량에 대해 흘려주는게 알고리즘 내용
//음의 유량을 고려 //현실에는 없지만 알고리즘에서는 존재한다고 가정
//남아있는 양이 1이 넘으면 계속해서 흘려 보내주면 알아서 최적화가 이루어진다.
//특별한 상황이 아니면 순서 고려하지 않아도 된다.
//에드몬드 카프 알고리즘 == 시간 복잡도가 O(VE^2) 이다  // 정정*간선의 제곱 
//모든 경로를 모든 정점에 대해 수행한다
//네트워크 플로우는 이분 매칭 등 다양한 알고리즘으로 확장이 가능하다는 점에서 매우 중요한 알고리즘이다. 

#include<iostream>
#include<vector>
#include<queue>

#define MAX 100
#define INF 1000000000

using namespace std;

int n = 6; 
int result; //최대유량 
int c[MAX][MAX], f[MAX][MAX], d[MAX]; //용량변수 // 유량변수 //방문여부
vector<int> a[MAX];

void maxFlow(int start, int end) { //시작점 끝점 받는다. 
	while(1){
		fill(d, d+MAX, -1); //모든 정점은 방문하지 않은 -1로 초기화
		queue<int> q; //큐를 하나 만들어서 모든 경로를 확인
		q.push(start); 
		//bfs를 수행 
		while(!q.empty()){
			int x = q.front();
			q.pop();
			//인접노드 모두 확인 
			for(int i=0; i<a[x].size(); i++){
				int y = a[x][i];
				//방문하지 않은 노드 중에서 용량이 남은 경우
				if(c[x][y] - f[x][y] > 0 && d[y] == -1){
					q.push(y);
					//해당 인접노드 방문처리
					d[y] = x; //경로를 기억하기 위해 노드를 인접노드로 가기 위한 값으로 넣어준다. 
					if(y ==end) break; //도착지에 도달을 한 경우 
				}
			}
		}
		if(d[end] == -1) break; //모든 경로를 찾고 탈출 //도착지까지 도달을 못하기 때문에 -1담겨서 탈출
		int flow =INF; //최소값 유량을 찾아줘야 하기 때문애 INF를 넣어준다
		//거꾸로 최소 유량 탐색합니다. 
		for(int i = end; i !=start; i=d[i]){
			//이전값 용량에서 이전값 유량을 빼준다  //남은 가능한 유량만 확인 
			flow = min(flow, c[d[i]][i] - f[d[i]][i]); //용량 - 유량 //해당 경로에 대해서 하나라도 0이되면 자동으로 flow 0 
		}
		//최소 유량만큼 추가
		for(int i = end; i !=start; i=d[i]){
			f[d[i]][i] += flow; //유량을 더해준다 
			f[i][d[i]] -= flow; //음의 유량도 처리 
		}
		result += flow; //원하는 최대 유량값 구할 수 있다. 
	}
}

int main(void) {
	a[1].push_back(2);
	a[1].push_back(1); //음의 유량도 확인해야 하니 
	c[1][2] = 12;
	
	a[1].push_back(4);
	a[4].push_back(1);
	c[1][4] = 11;
	
	a[2].push_back(3);
	a[3].push_back(2);
	c[2][3] = 6;
	
	a[2].push_back(4);
	a[4].push_back(2);
	c[2][4] = 3;
	
	a[2].push_back(5);
	a[5].push_back(2);
	c[2][5] = 5;
	
	a[2].push_back(6);
	a[6].push_back(2);
	c[2][6] = 9;
	
	
	a[3].push_back(6);
	a[6].push_back(3);
	c[3][6] = 8;
	
	a[4].push_back(5);
	a[5].push_back(4);
	c[4][5] = 9;
	
	a[5].push_back(3);
	a[3].push_back(5);
	c[5][3] = 3;
	
	a[5].push_back(6);
	a[6].push_back(5);
	c[5][6] = 4;
	
	maxFlow(1, 6);
	printf("%d", result);
}
 

 
