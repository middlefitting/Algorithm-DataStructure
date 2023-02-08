//문자열매칭알고리즘 연습

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
		printf("찾을 수 없는 문자열입니다!");
	} else{
		printf("%d 번째 에서 문자열을 찾았습니다!", result +1);
	}
	return 0;
}
