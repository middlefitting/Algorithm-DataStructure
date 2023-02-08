//이진 트리
//비선형 자료구조
//일직선으로 나열된 것이 아니라 왼쪽 오른쪽으로 퍼져 나가는 자료구조
//왼쪽 오른쪽으로 나눌 수 있는 자료구조
//완전 이진트리가 아니면 포인터를 사용해서 구현한다.
// 자식의 접근이 훨씬 용이해진다.
//한번 내려갈 때마다 1/2씩 데이터를 줄여주기 때문에 높이가 log2n이라 할 수 있다.
//완전 이진 트리가 아닌 이진 트리는 배열로 표현하기가 어렵다.
//오른쪽으로 이어지는 실제로 배열의 담을 공간은 14개나 필요하다 4개만 이동해도
// 그래서 포인터를 사용해서 구현한다. 불필요한 배열의 개수를 줄일 수 있다.
// 이진트리 탐색방법
//	 - 전위, 중위, 후위 순회 방식 
//전위는 자신 -> 왼쪽 -> 오른쪽
// 중위는 왼쪽 -> 자신 -> 오른쪽
// 후위는  왼쪽 -> 오른쪽 -> 자신

#include <iostream>

using namespace std;

int number = 15;

// 하나의 노드 정보를 선언합니다.
typedef struct node *treePointer; //포인터의 이름을 정해준다. node라는 구조체를 *treepointer라는 포인터의 형식으로 사용하겠다는 것 
typedef struct node {
	int data;
	treePointer leftChild, rightChild; //왼쪽,오른쪽  노드 가리키는 포인터 변수 
} node; //node라는 이름으로 사용 가능

//전위 순회를 구현합니다
void preorder(treePointer ptr) { //특정 포인터 위치에서 
	if(ptr){ //포인터가 null이 아니면 
		cout << ptr ->data << ' '; //자기데이터 출력 
		preorder(ptr->leftChild); //왼쪽 노드 기준 수행 
		preorder(ptr-> rightChild); //오른쪽 노드 기준 수행 
	}
} 

void inorder(treePointer ptr) { //특정 포인터 위치에서 
	if(ptr){ //포인터가 null이 아니면
		inorder(ptr->leftChild); //왼쪽 노드 기준 수행 
		cout << ptr ->data << ' '; //자기데이터 출력 
		inorder(ptr-> rightChild); //오른쪽 노드 기준 수행 
	}
} 

void postorder(treePointer ptr) { //특정 포인터 위치에서 
	if(ptr){ //포인터가 null이 아니면  
		postorder(ptr->leftChild); //왼쪽 노드 기준 수행 
		postorder(ptr-> rightChild); //오른쪽 노드 기준 수행
		cout << ptr ->data << ' '; //자기데이터 출력 
	}
} 

int main(void) {
	node nodes[number + 1];
	for(int i = 1; i<=number; i++) {
		nodes[i].data = i; //자기 자신이 들어갈 수 있도록
		nodes[i].leftChild = NULL; //기본적으로 null값 
		nodes[i].rightChild = NULL; 
	}
	for(int i = 2; i<= number; i++) { //연결 수행 
		if(i%2 ==0){
			nodes[i/2].leftChild= &nodes[i];
		}
		else{
			nodes[i/2].rightChild= &nodes[i];
		}
	}
	
	//순회 진행
	preorder(&nodes[1]); //1번 노드 기준 
	inorder(&nodes[1]);
	postorder(&nodes[1]);
}

 
