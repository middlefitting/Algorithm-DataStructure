//1948 �������Ŀ����ϱ�3
//�Ӱ��α��� ���ؾ� �Ѵ�. �������� ��ȭ
//�������� �ؾ� �Ѵ�.
//�Ϲ������̰� ����Ŭ�� ���� == ���������� �⺻����
//1�е� ���� �ʴ´� == ���� ���� �ð��� �ɸ��� ��� == �Ӱ���

#include<iostream>
#include<vector>
#include<queue>
#define MAX 10001

using namespace std;

class Edge{
public:
	int node;
	int time;
	Edge(int node, int time) {
		this -> node = node;
		this -> time = time;
	}
};

int n, start, finish;
int inDegree[MAX], result[MAX], c[MAX]; //c���� ó���� �Ǿ����� ����
vector<Edge> a[MAX];// ���ۿ��� ���������� ���°� 
vector<Edge> b[MAX]; //�������� ���� ��� //���������� ���������� ���� ��

void topologySort() {
	queue<int> q;
	//������ ��� ť�� ����
	q.push(start);
	//���̻� �湮�� ��尡 ���� ������
	//������ ����Ǿ� �ִ� ������ �ϳ��� ó�� 
	while(!q.empty()){
		int x = q.front();
		q.pop();
		for(int i = 0; i<a[x].size(); i++){
			//���� �ð����� �޴´�. 
			Edge y = Edge(a[x][i].node, a[x][i].time);
			if(result[y.node] <=y.time + result[x]){
				result[y.node] = y.time + result[x];
			}
			//���Ӱ� ���������� 0��  �� ������ ť�� ����
			if(--inDegree[y.node] ==0){
				q.push(y.node);
			} 
		}
	}
	
	//����� �������մϴ�.
	int count = 0;
	q.push(finish);
	while(!q.empty()){
		int y = q.front();
		q.pop();
		for(int i = 0; i<b[y].size(); i++){
			Edge x = Edge(b[y][i].node, b[y][i].time);
			//���� ��ο� ���ԵǴ� �������� Ȯ���մϴ�.
			//���� ��ο� ���ԵǴ� �����϶��� ���� 
			if(result[y] - result[x.node] == x.time) {
				count++;
				//ť���� �� ���� ��� ����
				if(c[x.node] == 0){
					q.push(x.node);
					//ó���� ���� 1 
					c[x.node] = 1;
				} 
			}
		}
	}
	printf("%d\n%d", result[finish], count);
}

int main(void) {
	int m;
	scanf("%d %d", &n, &m);
	for(int i = 0; i<m; i++) {
		int x, node, time;
		scanf("%d %d %d", &x, &node, &time);
		a[x].push_back(Edge(node,time));
		b[node].push_back(Edge(x,time));
		inDegree[node]++;	
	}
	scanf("%d %d", &start, &finish);
	topologySort();
}



 
