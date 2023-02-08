//1516 �������Ŀ����ϱ�2 
//�Ӱ��α��� ���ؾ� �Ѵ�. �������� ��ȭ 

#include <iostream>
#include<vector>
#include<queue>
#define MAX 501

using namespace std;

int n, inDegree[MAX], time[MAX], result[MAX];
vector<int> a[MAX]; //�������� ���� ���� ���� �� �ֵ���

void topologySort() {
	queue<int> q;
	//���� ������ 0�� ��带 ť�� ����
	for(int i = 1; i<=n; i++){
		if(inDegree[i] == 0){
			result[i] = time[i]; //������ 0�� ģ������ �⺻ ���� �ð��� 
			q.push(i);
		}
	}
	
	//������ ������ ����Ƿ��� ��Ȯ�� n���� ��带 �湮�մϴ�.
	for(int i=1; i<=n; i++){
		int x = q.front();
		q.pop();
		for(int j=0; j< a[x].size(); j++) {
			int y = a[x][j];
			//�� ū�� ���ǿ� ���� ���� 
			result[y] = max(result[y], result[x] + time[y]); //Ư�� ������ ���� ������ �ּ� ���� �ּҽð��� ������ �ð� ���� �� �� 
			if(--inDegree[y] == 0){ 
				q.push(y);
			}
		}
	}
	
	for(int i = 1; i<=n; i++){
		printf("%d\n", result[i]);
	}
} 

int main(void) {
	scanf("%d", &n);
	for(int i = 1; i<=n; i++) {
		scanf("%d", &time[i]);
		while(1) {
			int x;
			scanf("%d", &x);
			if(x==-1) break;
			inDegree[i]++;
			a[x].push_back(i);
		}
	}
	topologySort();
}


