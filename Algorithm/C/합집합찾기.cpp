//������ ã��
//���μ� �����̶�� �˰��� �̶�� �Ѵ�
//�������� ��尡 ������ �� �� ��带 �����ؼ� ���� �� ��尡 ���� �׷����� ���ϴ��� �Ǻ��ϴ� �˰���
//�θ� ��ĥ ���� �Ϲ������� �� ���� �� ������ ��Ĩ�ϴ�. == ��ħ(Union) �̶�� �Ѵ�.
//�θ� ��常 ����� �ѹ��� �ľ��ϱ� ����� ���� �Ͱ� ������ �Ǿ �θ� �ٸ� ��ó�� ���� �� �ֱ� ����
// ==> ����Լ��� ���ȴ�.  == �θ� ���� ����Ű���� �� ��Ʈ���� Ȯ���� �ؼ� �θ� �����Ѵ�
//���� �θ� �������� �ƴ����� �ľ��ϴ� ���� Union�� �ٽ�
//�ٸ� ��� �׷��� �˰����� ���̽��� �ȴ�. 

#include<stdio.h>

//ex) 3�� 2�� ����Ű�� ���� �� 2�� ����Ű�� �ִ� 1�� ã�ƿ��� ���� 
int getParent(int parent[], int x) {
	if(parent[x] ==x) return x; //���� �ڽ��� ����Ű�� �θ�� �ڱ��ڽ��� �ٸ��ٸ� 
	return parent[x] = getParent(parent, parent[x]); //���� �θ� ã�� ���� ��������� �Լ��� ����
}

//�� �θ� ��带 ��ġ�� �Լ�
int unionParent(int parent[], int a, int b){
	a = getParent(parent, a); //�θ� ���ϰ� 
	b = getParent(parent, b);
	if(a < b) parent[b] = a; //�� ������ ������ �θ� �����ش�. 
	else parent[a] = b;
} 

//���� �θ� �������� Ȯ��
int findParent(int parent[], int a, int b){
	a = getParent(parent, a);
	b = getParent(parent, b);
	if(a == b) return 1;
	return 0;
}

int main(void) { 
	int parent[11];
	for(int i; i<=10; i++){
		parent[i] = i; //�⺻������ �ڱ� �ڽ��� �θ�� �������� �Ѵ�. 
	}
	
	unionParent(parent, 1, 2);
	unionParent(parent, 2, 3);
	unionParent(parent, 3, 4);
	unionParent(parent, 5, 6);
	unionParent(parent, 6, 7);
	unionParent(parent, 7, 8);
	
	printf("1��5�� ����Ǿ� �ֳ���? %d\n", findParent(parent, 1, 5));
	unionParent(parent, 1, 5);
	printf("1��5�� ����Ǿ� �ֳ���? %d\n", findParent(parent, 1, 5));
}
 
 

