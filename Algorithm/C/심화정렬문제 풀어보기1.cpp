//심화 정렬 문제 풀어보기
#include <iostream>
#include <algorithm>

using namespace std;

string a[20000];
int n;

bool compare(string a, string b){
	// 길이가 짧은 순서 우선
	if(a.length() < b.length()){
		return 1; //우선순위 높다 
	} 
	else if(a.length() > b.length()){
		return 0;
	}
	//길이가 같은 경우 //사전순으로 비교하라는 뜻, 자동으로 해준다. 
	else{
		return a<b; //바로 사전순 비교 
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
			continue; //동일하먼 무시 
		}else{
			cout << a[i] << '\n';
		}
	}
	return 0;
}
