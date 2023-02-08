//라빈 카프 알고리즘
//일반적인 경우 빠르게 작동
//해시기법
//상징하는 데이터로 바꾸어 처리한다
//단순 해시 알고리즘은 연산 속도가 O(1)
//각 문자의 아스키 코드 값에 2의 제곱 수를 차례대로 곱하여 더해준다.
//매우 높은 확률로 해시값이 다르게 나온다.
//문자열이 달라지면 결과값 해시값도 바뀌는 것을 알 수 있다.
//해시값이 중복되는 해시값 충돌도 일어나지만 발생률이 높지 않다.
//실제로 출돌이 일어나면 포인터를 이용해 연결 자료구조를 ㄹ이용하여 해결
//여러개의 문자열 비교 해시값 비교, 해시값이 일치하는 경우에만 문자열 비교
//라빈 카프 알고리즘 시간복잡도 == O(N)
//해시 값 일치 여부를 검증하기 위해 나머지 연산(MOD)를 사용하는 경우가 많다.
//일반적으로 오버플로우가 발생해도 해시 값 자체는 동일하기 때문에 굳이 나머지 연산을 사용하지 않아도 된다.
//하지만 안정성을 고려한다면 나머지연산을 고려하라
 
 
#include<iostream>

using namespace std;

void findString(string parent, string pattern) {
	int parentSize = parent.size();
	int patternSize = pattern.size();
	int parentHash = 0, patternHash = 0, power = 1; //power는 제곱수를 의미한다. 
	//전체위치에서 하나씩 검사를 하겠다는 것 
	for(int i = 0; i<=parentSize - patternSize; i++) {
		//i가 0일때만 j를 이용해서 해시값을 만든다. 
		if(i ==0) {
			for(int j = 0; j<patternSize; j++) {
				parentHash += parent[patternSize -1 - j] * power;
				patternHash +=pattern[patternSize-1-j] * power;
				if(j<patternSize -1 ) power *= 2;
			}
		} else{
			//가장 왼쪽 값 빼고 2곱해줌 
			parentHash = 2 * (parentHash - parent[i-1]*power) + parent[patternSize - 1 + i];
			printf("%d   %d\n", parentHash, patternHash);
		}
		if(parentHash == patternHash){
			bool finded = true;
			for(int j = 0; j<patternSize; j++) {
				if(parent[i+j] != pattern[j]){
					finded = false;
					break;
				}
			}
			if(finded){
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
