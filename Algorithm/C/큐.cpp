//ť(Queue)
//���Լ���
// ��ǥ���� �ڷᱸ���� ����
//���ర�� ���� ���� ���� ���� ������.
//�ͳΰ� ���� ����
//���� �������� stl ���̺귯�� ����ϴ� ���� ȿ����
 
#include<iostream>
#include<queue>

using namespace std;

int main(void){
	queue<int> q;
	q.push(1);
	q.push(2);
	q.push(3);
	q.pop();
	q.push(4);
	q.pop();
	while(!q.empty()){
		cout << q.front() + ' ';
		q.pop();
	}
	return 0;
}
