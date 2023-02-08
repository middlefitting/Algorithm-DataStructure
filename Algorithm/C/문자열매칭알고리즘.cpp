//문자열 매칭 알고리즘(KMP)
//특정한 글이 있을 때 그 글 안에서 하나의 문자열을 찾는 알고리즘
//여러개를 찾을 수도 있다.
//ctrl f를 통해 특정 문자열 찾는 것이 문자열 매칭 알고리즘이 적용이 되어 있다.
//KMP 알고리즘이 가장 많이 사용되는데 처음 공부하는 사람한테는 다소 난해할 수 있다.
//따라서 처음에는 단순 비교 문자열 매칭 알고리즘부터 살펴보는게 좋다.
//단순 비교 알고리즘은 말 그대로 하나씩 확인하는 알고리즘
//시간 복잡도는 O(N*M)의 시간복잡도를 가지게 된다. ==> O(N^2)
//효율적이지는 않지만 직관적이고 쉽다.

#include <iostream>

using namespace std;


//parent 전체 문자, pattern 찾으려는 문자 
int findString(string parent, string pattern){
	int parentSize = parent.size();
	int patternSize = pattern.size();
	for(int i = 0; i<=parentSize - patternSize; i++){
		bool finded = true;
		for(int j= 0; j<patternSize; j++){
			//하나라도 일치하지 않으면 break 
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
		printf("찾을 수 없습니다");
	}else{
		printf("%d번째에서 찾았습니다", result +1);
	}
	return 0;
}
