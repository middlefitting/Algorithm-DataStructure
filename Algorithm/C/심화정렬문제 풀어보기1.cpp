//��ȭ ���� ���� Ǯ���
#include <iostream>
#include <algorithm>

using namespace std;

string a[20000];
int n;

bool compare(string a, string b){
	// ���̰� ª�� ���� �켱
	if(a.length() < b.length()){
		return 1; //�켱���� ���� 
	} 
	else if(a.length() > b.length()){
		return 0;
	}
	//���̰� ���� ��� //���������� ���϶�� ��, �ڵ����� ���ش�. 
	else{
		return a<b; //�ٷ� ������ �� 
	}
}

int main(void){
	cin >> n;
	for(int i = 0; i< n; i++){
		cin >> a[i];
	}
	sort(a, a+n, compare);
	for(int i = 0; i<n; i++ ){
		if(i > 0 && a[i] == a[i-1]){
			continue; //�����ϸ� ���� 
		}else{
			cout << a[i] << '\n';
		}
	}
	return 0;
}
