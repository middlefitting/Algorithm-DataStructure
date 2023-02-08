//���ڿ� ��Ī �˰���(KMP)
//Ư���� ���� ���� �� �� �� �ȿ��� �ϳ��� ���ڿ��� ã�� �˰���
//�������� ã�� ���� �ִ�.
//ctrl f�� ���� Ư�� ���ڿ� ã�� ���� ���ڿ� ��Ī �˰����� ������ �Ǿ� �ִ�.
//KMP �˰����� ���� ���� ���Ǵµ� ó�� �����ϴ� ������״� �ټ� ������ �� �ִ�.
//���� ó������ �ܼ� �� ���ڿ� ��Ī �˰������ ���캸�°� ����.
//�ܼ� �� �˰����� �� �״�� �ϳ��� Ȯ���ϴ� �˰���
//�ð� ���⵵�� O(N*M)�� �ð����⵵�� ������ �ȴ�. ==> O(N^2)
//ȿ���������� ������ �������̰� ����.

#include <iostream>

using namespace std;


//parent ��ü ����, pattern ã������ ���� 
int findString(string parent, string pattern){
	int parentSize = parent.size();
	int patternSize = pattern.size();
	for(int i = 0; i<=parentSize - patternSize; i++){
		bool finded = true;
		for(int j= 0; j<patternSize; j++){
			//�ϳ��� ��ġ���� ������ break 
			if(parent[i+j] !=pattern[j]){
				finded = false;
				break;
			}
		}
		if(finded){
			return i;
		}
	}
	return -1;
}

int main(void) {
	string parent = "Hello World";
	string pattern = "llo W";
	int result = findString(parent, pattern);
	if(result ==-1){
		printf("ã�� �� �����ϴ�");
	}else{
		printf("%d��°���� ã�ҽ��ϴ�", result +1);
	}
	return 0;
}
