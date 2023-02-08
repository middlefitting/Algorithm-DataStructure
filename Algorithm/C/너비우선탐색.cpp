//�ʺ� �켱 Ž��(BFS)
//Ž���� �� �� �ʺ� �켱���� �Ͽ� Ž���� �����ϴ� Ž�� �˰���
// �������� ����� �� ���ַ� Ž���� �ϰڴٴ� ��
//BFS�� �͸����� Ž���� �ϰڴٴ� �˰���
//ť�� �ʿ��ϴ�
//���Լ����� �ʿ�
//�̷�ã�� ���� �˰��򿡼� ���ȴ�.
//�ʺ�켱 Ž���� �� ���� ó�� ��� 1�� ť�� �־��ָ� �ȴ�.
//�湮ó���� �ؾ� �Ѵ�.
// ť���� ��带 ������, ��忡�� ����� ����� �湮���� ���� ��带 �湮�ϰ� ���ʴ�� ť�� �����մϴ�.
// ���� ��带 ��� �湮�Ѵٴ� ���� �ٽ�!
//��Ʈ�� �Ÿ��� ������ ���� Ž���� �̷������. 

//��ü�δ� �ǹ̰� ���� �ٸ� �˰��� �̰��� �̿��ؼ� �����Ѵٴ� ���� �ٽ��̴�.
//bfs�� Ž�� ����߿� �ϳ��� ���̴�. 

#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int number = 7;
int c[8];
vector<int> a[8]; //���Ͱ� �� �迭�� ������� �� ��� �ε����� 1���� ó���ǵ��� �ϰ��ϱ� ���� 8�� ���� �Ҵ�

void bfs(int start){
	queue<int> q;
	q.push(start);
	c[start] = true;
	while(!q.empty()){
		int x = q.front(); //1
		q.pop();
		printf("%d ", x); //1��� 
		for(int i = 0; i< a[x].size(); i++){
			int y = a[x][i]; //2
			if(!c[y]){
				q.push(y);
				c[y] = true;
			}
		}
	}
} 

int main(void){
	a[1].push_back(2);
	a[2].push_back(1);
	
	a[1].push_back(3);
	a[3].push_back(1);
	
	a[2].push_back(3);
	a[3].push_back(2);
	
	a[2].push_back(4);
	a[4].push_back(2);
	
	a[2].push_back(5);
	a[5].push_back(2);
	
	a[4].push_back(5);
	a[5].push_back(4);
	
	a[3].push_back(6);
	a[6].push_back(3);
	
	a[3].push_back(7);
	a[7].push_back(3);
	
	a[6].push_back(7);
	a[7].push_back(6);
	
	bfs(1);
	
	return 0;
}
