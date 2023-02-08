//���ͽ�Ʈ�� �˰��� heap ����ϱ�
#include<iostream>
#include<vector>
#include<queue>
//�켱���� ť�� ����ϱ� ���� ��� ==> ���������� heap�� ���� ������� �۵��Ѵ�. 

using namespace std;

int number = 6;
int INF = 1000000000;

//�ڽŰ� ����� ������ ��� pair ���·� ������ �� �ֵ��� ����� 
vector<pair<int, int> > a[7];
int d[7]; //�ּҺ��

void dijkstra(int start) {
	d[start] = 0;
	priority_queue<pair<int, int> > pq; // �������� ���� �� �ֵ���
	pq.push(make_pair(start, 0));
	
	//����� ������� ó���ϹǷ� ť�� ���
	while(!pq.empty()){
		int current = pq.top().first; //�ֻ�� �� ���// �ѽ��� ���� ��� //���� ���� ��� ������ ����� ������ ������ �ִ�
		//ª�� ���� ���� ������ ����ȭ
		int distance = -pq.top().second; //ó���� 0�̻��� 
		pq.pop();
		//�ִ� �Ÿ��� �ƴ� ��� ��ŵ
		if(d[current] < distance) continue; //ó������ �����̴� ���� 
		for(int i = 0; i<a[current].size(); i++){ //1.size => 3������ 
			//���õ� ����� ���� ���
			int next = a[current][i].first; // ó���� 2, 2���� 2���� 
			//���õ� ��� ���ļ� ���� ���� ���� ���
			int nextDistance = distance + a[current][i].second; //0 + 2 
			//������ �ּ� ��뺸�� �� �����ϴٸ� ��ü�մϴ�.
			if(nextDistance < d[next]){ //2 < INF
				d[next] = nextDistance; //d[2] = 2
				//����ȭ�ؼ� �־���� �Ѵ�. //�� ���� ����� �������� ������ �ؾ� �ϱ� �����̴�. //������������ ���ĵȴ�. 
				pq.push(make_pair(next, -nextDistance));  // 2, -2
			}
		} 
		 
		 
	}  
} 

int main(void) {
	//�⺻�� ������� ���� ��� ���� ���
	for(int i = 1; i<=number; i++) {
		d[i] = INF;
	} 
	
	a[1].push_back(make_pair(2, 2));
	a[1].push_back(make_pair(3, 5));
	a[1].push_back(make_pair(4, 1));
	
	a[2].push_back(make_pair(1, 2));
	a[2].push_back(make_pair(3, 3));
	a[2].push_back(make_pair(4, 2));
	
	a[3].push_back(make_pair(1, 5));
	a[3].push_back(make_pair(2, 3));
	a[3].push_back(make_pair(4, 3));
	a[3].push_back(make_pair(5, 1));
	a[3].push_back(make_pair(6, 5));
	
	a[4].push_back(make_pair(1, 1));
	a[4].push_back(make_pair(2, 2));
	a[4].push_back(make_pair(3, 3));
	a[4].push_back(make_pair(5, 1));
	
	a[5].push_back(make_pair(3, 1));
	a[5].push_back(make_pair(4, 1));
	a[5].push_back(make_pair(6, 2));
	
	a[6].push_back(make_pair(3, 5));
	a[6].push_back(make_pair(5, 2));
	
	dijkstra(1);
	
	//����� ���
	for(int i = 1; i<=number; i++){
		printf("%d ", d[i]);
	} 
}
