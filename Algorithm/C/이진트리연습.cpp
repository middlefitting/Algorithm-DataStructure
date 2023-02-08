#include<iostream>

using namespace std;

int number = 15;

typedef struct node *treePointer; //node의 포인터를 *treePointer라고 하겠다. //노드의 포인터는 노드의 주소? 

typedef struct node{
	int data;
	treePointer leftChild, rightChild;
} node;

void preorder(treePointer ptr){
	if(ptr){ //.을 ->로 쓰는것 같다 
		cout << ptr -> data << ' ';
		preorder(ptr -> leftChild);
		preorder(ptr -> rightChild);
	}
}

int main(void) {
	node nodes[number+1];
	
	for(int i=1; i<=number; i++){
		nodes[i].data = i;
		nodes[i].leftChild = NULL;
		nodes[i].rightChild = NULL;
	}
	
	for(int i=2; i<=number; i++){
		if(i%2 == 0){
			nodes[i/2].leftChild = &nodes[i];
		}else{
			nodes[i/2].rightChild = &nodes[i];
		}
	}
	
	preorder(&nodes[1]);  //node의 주소를 treePointer라고 명명했다.  &는 노드의 주소니까 &node 는 곧 treePointer이다. 
						  //포인터가 가리키는 것에서 데이터 뽑을 때는 -> , 데이터에서는 .으로 뽑는다. 
	
}
