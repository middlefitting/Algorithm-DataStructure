//���� ����
//������ ������ �ִ� �۾��� �����ؾ� �� �� �� ������ �������ֱ� ���� ����ϴ� �˰���
//���������� DAG (����׷����ε� ����Ŭ�� �������� �ʴ� �׷���) ������ ��� ����
//���������� �⺻������ �������� �����ؾ� �Ѵ�. 
//���� ���� �˰����� ���� ������ ���ɿ��ο� �����ϴٸ� �� ����� �ذ�å���� �����Ѵ�.
//���� Ȥ�� ť�� �̿��ϴµ� �⺻������ ���ú��ٴ� ť�� ��ȣ�Ѵ�.
//��������: Ư���� ��尡 ���� �� �� ���� ������ ���� 
//�ð� ���⵵�� ������ ���� + ������ ������ŭ �ҿ� == O(V+E)

#include <iostream>
#include <vector>
#include <queue>
#define MAX 10

using namespace std;

int n, inDegree[MAX]; //�������� ����
vector<int> a[MAX]; //�� ������ ����� ��� ��� �������� ���� �� �ֵ���

void topologySort() {
	int result[MAX];
	queue<int> q;
	
	//���� ������ 0�� ��带 ť�� �����մϴ�.
	for(int i = 1; i<=n; i++) {
		if(inDegree[i] == 0) q.push(i);
	}
	//���� ������ ������ ����Ƿ��� ��Ȯ�� N���� ��带 �湮�մϴ�.
	for(int i=1; i<=n; i++) {
		//n���� �湮�ϱ� ���� ť�� ��ٸ� ����Ŭ�� �߻�
		if(q.empty()) {
			printf("����Ŭ�� �߻��߽��ϴ�");
			return;
		}
		int x = q.front();
		q.pop();
		result[i] =x; //ť���� ���� ������ �� �������� ���� ��� 
		
		//����� ��� �������� Ȯ���ϸ� ��� �������� �����. ==���������� 1���ش� 
		for(int j = 0; j<a[x].size(); j++){
			int y = a[x][j];
			//���Ӱ� ���������� 0�̵� ������ ť�� �����մϴ� 
			if(--inDegree[y] ==0) {
				q.push(y);
			}
		}
	}
	for(int i = 1; i<=n; i++) {
		printf("%d ", result[i]);
	}
	 
}

int main(void) {
	n = 7;
	a[1].push_back(2);
	inDegree[2]++;
	a[1].push_back(5);
	inDegree[5]++;
	a[2].push_back(3);
	inDegree[3]++;
	a[3].push_back(4);
	inDegree[4]++;
	a[4].push_back(6);
	inDegree[6]++;
	a[5].push_back(6);
	inDegree[6]++;
	a[6].push_back(7);
	inDegree[7]++;
	
	topologySort();
	
	printf("\n");
	int pp = 100;
	if(--pp ==0){ //�̰� if���� ���൵ --�� ����. 
		printf("case1: %d", pp);
	}else{
		printf("case2: %d", pp);
	}
	printf("case3: %d", pp);
	
}
