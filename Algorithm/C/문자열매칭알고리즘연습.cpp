//���ڿ���Ī�˰��� ����

#include<iostream>

using namespace std;

int findString(string parent, string pattern){
	int parentSize= parent.size();
	int patternSize = pattern.size();
	
	for(int i =0; i<parentSize - patternSize; i++){
		bool success = true;
		for(int j=0; j<patternSize; j++){
			if(parent[i+j]!=pattern[j]){
				success = false;
			}
		}
		if(success){
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
		printf("ã�� �� ���� ���ڿ��Դϴ�!");
	} else{
		printf("%d ��° ���� ���ڿ��� ã�ҽ��ϴ�!", result +1);
	}
	return 0;
}
