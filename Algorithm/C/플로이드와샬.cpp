//플로이드 와샬 알고리즘
//플로이드 와샬은 거쳐가는 정점을 기준으로 한다.
//모든 정점에서 모든 정점으로 
//다익스트라와 다른점은 거쳐가는 노드를 다 설정해서 확인한다는 점에서 다르다.
//플로이드 와샬은 2차원 배열을 사용한다.
//반복의 기준은 거쳐가는 정점
//x에서 노드로 가는 비용 + 노드에서 Y로 가는 비용
//다익스트라와 다른 점은 다익스트라는 1차원 1개의 시작점에서만 구한다는 것이고 플로이드 와샬은 모든 정점에 대해 수행한다는 것이다.
//플로이드 와샬은 소스코드가 짧고 직관적이고 쉬운 알고리즘 동적 프로그래밍 원리를 그대로 사용함
//3중 for문으로 인해 n**3의 시간복잡도를 가진다. 
#include <stdio.h>

int number = 4;
int INF = 1000000000;

//자료 배열을 초기화합니다
int a[4][4]  = {
	{0, 5, INF, 8},
	{7, 0, 9, INF},
	{2, INF, 0, 4},
	{INF, INF, 3, 0},
};

void floydWarshall() {
	//결과 그리프를 초기화합니다.
	int d[number][number];
	
	//초기화
	for(int i = 0; i<number ; i++) {
		for(int j= 0; j<number; j++){
			d[i][j] = a[i][j];  
		}
	}
	
	//k = 거쳐가는 노드
	for(int k = 0; k<number; k++) {
		//i = 출발 노드
		for(int i=0; i<number; i++){
			//j 도착 노드
			for(int j = 0; j<number; j++){
				if(d[i][k] + d[k][j] < d[i][j]) {
					d[i][j] = d[i][k] + d[k][j];
				}
			} 
		} 
	}
	
	//결과를 출력합니다.
	for(int i = 0; i<number; i++){
		for(int j=0; j<number; j++){
			printf("%d ", d[i][j]);
		}
		printf("\n");
	}
	 
}

int main(void){
	floydWarshall();
}
