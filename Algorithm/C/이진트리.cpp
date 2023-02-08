//���� Ʈ��
//���� �ڷᱸ��
//���������� ������ ���� �ƴ϶� ���� ���������� ���� ������ �ڷᱸ��
//���� ���������� ���� �� �ִ� �ڷᱸ��
//���� ����Ʈ���� �ƴϸ� �����͸� ����ؼ� �����Ѵ�.
// �ڽ��� ������ �ξ� ����������.
//�ѹ� ������ ������ 1/2�� �����͸� �ٿ��ֱ� ������ ���̰� log2n�̶� �� �� �ִ�.
//���� ���� Ʈ���� �ƴ� ���� Ʈ���� �迭�� ǥ���ϱⰡ ��ƴ�.
//���������� �̾����� ������ �迭�� ���� ������ 14���� �ʿ��ϴ� 4���� �̵��ص�
// �׷��� �����͸� ����ؼ� �����Ѵ�. ���ʿ��� �迭�� ������ ���� �� �ִ�.
// ����Ʈ�� Ž�����
//	 - ����, ����, ���� ��ȸ ��� 
//������ �ڽ� -> ���� -> ������
// ������ ���� -> �ڽ� -> ������
// ������  ���� -> ������ -> �ڽ�

#include <iostream>

using namespace std;

int number = 15;

// �ϳ��� ��� ������ �����մϴ�.
typedef struct node *treePointer; //�������� �̸��� �����ش�. node��� ����ü�� *treepointer��� �������� �������� ����ϰڴٴ� �� 
typedef struct node {
	int data;
	treePointer leftChild, rightChild; //����,������  ��� ����Ű�� ������ ���� 
} node; //node��� �̸����� ��� ����

//���� ��ȸ�� �����մϴ�
void preorder(treePointer ptr) { //Ư�� ������ ��ġ���� 
	if(ptr){ //�����Ͱ� null�� �ƴϸ� 
		cout << ptr ->data << ' '; //�ڱⵥ���� ��� 
		preorder(ptr->leftChild); //���� ��� ���� ���� 
		preorder(ptr-> rightChild); //������ ��� ���� ���� 
	}
} 

void inorder(treePointer ptr) { //Ư�� ������ ��ġ���� 
	if(ptr){ //�����Ͱ� null�� �ƴϸ�
		inorder(ptr->leftChild); //���� ��� ���� ���� 
		cout << ptr ->data << ' '; //�ڱⵥ���� ��� 
		inorder(ptr-> rightChild); //������ ��� ���� ���� 
	}
} 

void postorder(treePointer ptr) { //Ư�� ������ ��ġ���� 
	if(ptr){ //�����Ͱ� null�� �ƴϸ�  
		postorder(ptr->leftChild); //���� ��� ���� ���� 
		postorder(ptr-> rightChild); //������ ��� ���� ����
		cout << ptr ->data << ' '; //�ڱⵥ���� ��� 
	}
} 

int main(void) {
	node nodes[number + 1];
	for(int i = 1; i<=number; i++) {
		nodes[i].data = i; //�ڱ� �ڽ��� �� �� �ֵ���
		nodes[i].leftChild = NULL; //�⺻������ null�� 
		nodes[i].rightChild = NULL; 
	}
	for(int i = 2; i<= number; i++) { //���� ���� 
		if(i%2 ==0){
			nodes[i/2].leftChild= &nodes[i];
		}
		else{
			nodes[i/2].rightChild= &nodes[i];
		}
	}
	
	//��ȸ ����
	preorder(&nodes[1]); //1�� ��� ���� 
	inorder(&nodes[1]);
	postorder(&nodes[1]);
}

 
