//라빈 카프 알고리즘연습

#include<iostream>

using namespace std;

void findString(string parent, string pattern) {
	int parentSize = parent.size();
	int patternSize = pattern.size();
	int parentHash=0, patternHash=0, power = 1;
	
	for(int i = 0; i<=parentSize-patternSize; i++) {
		if(i==0){
			for(int j = 0; j<patternSize; j++) {
				parentHash += parent[patternSize - 1 - j] * power;
				patternHash += pattern[patternSize - 1 - j] * power;
				if(j<patternSize -1) power *= 2;
				}
			}
		else{
			parentHash = 2* (parentHash - parent[i-1] * power) + parent[patternSize - 1 + i];
		}
		if(parentHash == patternHash) {
			bool result = true;
			for(int k = 0; k<patternSize; k++) {
				if(pattern[k] != parent[i+k]){
					result = false;
					break;
				}
			}
			if(result){
				printf("%d번째에서 찾았습니다!\n", i+1);
			}
		}		
	}
}

int main(void) {
	string parent = "ababacabacaabacaaba";
	string pattern = "abacaaba";
	findString(parent, pattern);
	return 0;
}
