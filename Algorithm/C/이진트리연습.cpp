#include<iostream>

using namespace std;

int number = 15;

typedef struct node *treePointer; //node�� �����͸� *treePointer��� �ϰڴ�. //����� �����ʹ� ����� �ּ�? 

typedef struct node{
	int data;
	treePointer leftChild, rightChild;
} node;

void preorder(treePointer ptr){
	if(ptr){ //.�� ->�� ���°� ���� 
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
	
	preorder(&nodes[1]);  //node�� �ּҸ� treePointer��� ����ߴ�.  &�� ����� �ּҴϱ� &node �� �� treePointer�̴�. 
						  //�����Ͱ� ����Ű�� �Ϳ��� ������ ���� ���� -> , �����Ϳ����� .���� �̴´�. 
	
}
