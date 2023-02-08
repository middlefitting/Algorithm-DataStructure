//KMP 문자열 매칭 알고리즘
//Knuth-Morris-Pratt 알고리즘
//문자열 매칭 알고리즘으로 가장 많이 활용
//단순하게 모두 비교하는 경우 최악의 경우 많은 시간이 소요된다
// 때문에 모든 경우를 다 비교하지 않아도 부분 문자열을 찾을 수 있는 kmp알고리즘을 사용한다 
//접두사와 접미사의 개념을 사용한다.
//불필요한 부분은 점프한다. 
//접두사와 접미사의 최대 일치 길이를 확인한다.
#include<iostream>
#include<vector>

using namespace std;

vector<int> makeTable(string pattern){
	//찾고자 하는 문자열 길이 
	int patternSize = pattern.size();
	//패턴 사이즈만큼 0초기화 
	vector<int> table(patternSize, 0);
	int j = 0;
	//모든 문자 한개씩 확인 
	for(int i = 1; i<patternSize; i++){
		//일치하지 않으면 
		while(j>0 &&pattern[i] != pattern[j]){
			//인덱스 테이블 값으로 인덱스 변경 
			j = table[j-1];
		}
		if(pattern[i] == pattern[j]){
			//현재 j에 1을 더한 값 
			table[i] = ++j;  
		}
	}
	return table;
}

void KMP(string parent, string pattern){
	vector<int> table = makeTable(pattern);
	int parentSize = parent.size();
	int patternSize = pattern.size();
	int j = 0;
	for(int i =0; i<parentSize; i++){
		while(j>0 && parent[i] !=pattern[j]){
			//일치하지 않았을때 이전단계 값으로 이동 
			j = table[j-1];
			printf("======%d\n", j);
		}
		//전체 문자열이 일치하였을 때 
		if(parent[i] ==pattern[j]){
			if(j==patternSize -1){
				printf("%d번째에서 찾았습니다.\n", i-patternSize+2); //2를 왜 더하나
				j = table[j]; //점프를 위해 j갱신 //모든 경우 찾아야 하기 때문에 
			} else{
				printf("======%d와비교\n", j);
				//아니면 j더해서 계속확인 
				j++; //0 1 2 3 // table[2] == 1
			}
		}
	}
}

int main(void){
	string parent = "ababacabacaabacaaba";
	string pattern = "abacaaba";
	KMP(parent, pattern);
	//찾고자 하는 문자열로 테이블 만듬 
	vector<int> table = makeTable(pattern);
	for(int i = 0; i<table.size(); i++){
		printf("%d ", table[i]);
	}
	return 0;
}
 
