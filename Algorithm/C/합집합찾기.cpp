//합집합 찾기
//서로소 집합이라는 알고리즘 이라고도 한다
//여러개의 노드가 존재할 때 두 노드를 선택해서 현재 두 노드가 같은 그래프에 속하는지 판별하는 알고리즘
//부모를 합칠 때는 일반적으로 더 작은 값 쪽으로 합칩니다. == 합침(Union) 이라고 한다.
//부모 노드만 보고는 한번에 파악하기 힘들다 같은 것과 연결이 되어도 부모가 다른 것처럼 보일 수 있기 때문
// ==> 재귀함수가 사용된다.  == 부모가 누굴 가르키는지 그 루트까지 확인을 해서 부모를 갱신한다
//같은 부모를 가지는지 아닌지를 파악하는 것이 Union의 핵심
//다른 고급 그래프 알고리즘의 베이스가 된다. 

#include<stdio.h>

//ex) 3이 2를 가리키고 있을 때 2가 가리키고 있는 1을 찾아오는 과정 
int getParent(int parent[], int x) {
	if(parent[x] ==x) return x; //현재 자신이 가르키는 부모와 자기자신이 다르다면 
	return parent[x] = getParent(parent, parent[x]); //실제 부모를 찾기 위해 재귀적으로 함수를 수행
}

//두 부모 노드를 합치는 함수
int unionParent(int parent[], int a, int b){
	a = getParent(parent, a); //부모값 구하고 
	b = getParent(parent, b);
	if(a < b) parent[b] = a; //더 작은값 쪽으로 부모를 합쳐준다. 
	else parent[a] = b;
} 

//같은 부모를 가지는지 확인
int findParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);
	if(a == b) return 1;
	return 0;
}

int main(void) { 
	int parent[11];
	for(int i; i<=10; i++){
		parent[i] = i; //기본적으로 자기 자신을 부모로 가지도록 한다. 
	}
	
	unionParent(parent, 1, 2);
	unionParent(parent, 2, 3);
	unionParent(parent, 3, 4);
	unionParent(parent, 5, 6);
	unionParent(parent, 6, 7);
	unionParent(parent, 7, 8);
	
	printf("1과5는 연결되어 있나요? %d\n", findParent(parent, 1, 5));
	unionParent(parent, 1, 5);
	printf("1과5는 연결되어 있나요? %d\n", findParent(parent, 1, 5));
}
 
 

