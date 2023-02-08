//다익스트라 알고리즘
//가장 비용이 적은 최단 경로 탐색 알고리즘입니다.
//다익스트라 알고리즘은 ㅊ특정한 하나의 정점에서 다른 모든 정점으로 가는 최단 경로를 알려줍니다.
//음의 간선을 가질 때는 사용할 수 없다.
//현실세계에서 사용하기 좋다. 현실에서는 음의 간선이 없기 때문이다.
//다이나믹 프로그래밍 유형이다.
//이전에 구한 최단 거리 정보를 그대로 사용한다.
//그리디 알고리즘으로 분류되기도 한다.
//다익스트라 알고리즘은 최단 경로를 계속해서 갱신
//비용이 적을 경우에 갱신
//그다음 비용이 적은 노드로 이동해서 다시 갱신 반복
//모든 노드에서 갱신이 완료되면 끝 

#include<stdio.h>

int number = 6;
int INF = 1000000000; 

//전체 그래프를 초기화 
int a[6][6] = {
	{0, 2, 5, 1, INF, INF},
	{2,0,3,2, INF, INF},
	{5,3,0,3,1,5},
	{1,2,3,0,1,INF},
	{INF,INF,1,1,0,2},
	{INF,INF,5,INF,2,0}
};

bool v[6]; //방문한 노드 
int d[6];//최단거리

//가장 최소 거리를 가지는 정점을 반환
int getSmallIndex(){
	int min = INF;
	int index = 0;
	for(int i = 0; i<number; i++){
		if(d[i] < min && !v[i]){ //더 작은 값을 가지는 노드가 존재한다면 갱신 
			min = d[i];
			index =i;
		}
	}
	return index;
} 

//다익스트라를 수행하는 함수
void dijkstra(int start) {
	for(int i =0; i<number; i++){
		d[i] = a[start][i];
	} //d[i] ==> {0, 2, 5, 1, INF, INF}
	v[start] =true; //v[0] ==> true //나머지 false 
	
	//4번 수행하는데  
	for(int i = 0; i<number -2; i++){ //현재 방문하지 않은 노드 중 최소 비용을 가지는 노드의 인덱스 가져오고 
		int current = getSmallIndex(); //3
		v[current] = true; //노드 방문처리 //v[3]-> true
		for(int j = 0; j<6; j++){
			if(!v[j]){ //그 노드의 인접한 모든 노드 확인 방문하지 않았다면 //0,3 빼고 == 1,2,4,5 
			//노드까지의 최소 비용에서 노드를 거쳐 인접한 노드로 가는 비용 값이 현재 그 노드로 가는 값보다 작다면 갱신 
				if(d[current] + a[current][j] < d[j]) { //d[3] + d[3][1] < d[1]
					d[j] = d[current] + a[current][j];  //d[1] = d[3] + d[3][1]
				}
			
			}
		} 
	}
}

//해당 방법은 시간 복잡도가 O(2^n)
//getSmallIndex가 for문을 반복해서 확인하기때문에 n
//그리고 전체 for문이 한번 더 있으니까 O(2^n)
//힙의 경우 항상 큰 값이나 작은 값이 최상단에 존재하니까 가장 작은 값을 가져오는 것이 logn밖에 안되서 nlogn으로 만들 수 있다. 
//위의 알고리즘은 정점의 개수는 적은데 간선의 개수가 많으면 치명적일 수 있다. 

int main(void){
	dijkstra(0);
	for(int i=0; i<number; i++){
		printf("%d", d[i]);
	}
} 
