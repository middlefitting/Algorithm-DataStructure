//Ŭ������ �ǹ����� ���� ������ �ӵ� �鿡�� �׷��� ������ �ʴ� 
//���� ���� ���̺귯���� �ۼ�
#include <iostream>
#include <vector>
#include <algorithm>
// � ��쿡�� ���Ͱ� ȿ�����̰� � ��쿡�� �˰��� �׳� ���°� ���� ���� �ִ�.
//�ܼ� �迭�� ���ʹ� ū ���̰� ���ٰ� �����ص� �ȴ�.
//���ʹ� �迭�� ���� ����ϱ� ���� ������ �ڷᱸ���� �� �� �ִ�. 
//��� STL�� �� ���� �����͸� ó���� �� �ֵ��� ���ִ� �ڷᱸ���� �� �� �ִ�. 
using namespace std;

int main(void){
	vector<pair<int, string> > v; //�� ���� �����͸� �����ְ� �ȴ�.
	v.push_back(pair<int, string>(90, "���ѿ�")); 
	v.push_back(pair<int, string>(85, "������")); 
	v.push_back(pair<int, string>(82, "������")); 
	v.push_back(pair<int, string>(98, "������")); 
	v.push_back(pair<int, string>(79, "�̻��")); 
	
	
	sort(v.begin(), v.end());
	for(int i=0; i<v.size(); i++){
		//���ͷ� ���� ����Ʈ ������ ���� �پ��� �Լ� ���
		//push_back: ����Ʈ�� ������ �κп� ����
		//size : ���Եǰ� ��� �����Ͱ� �ִ���, ������ ũ�� 
		cout << v[i].second << ' '; //second�� �ι�° ���� ���Ѵ�. == �̸����� 
	}
	return 0; 
} 


 
