//심화 정렬 문제 풀어보기
#include <iostream>
#include <algorithm>

using namespace std;

string a[20000];
int n;

int getSum(string a){
	int length = a.length(), sum=0;
	for(int i = 0; i< length; i++){
		//숫자인 경우에만 더합니다.
		if(a[i] - '0' <=9 && a[i] - '0' >=0){ //0을 빼줌으로써 숫자만 고를수 있다? 
			sum += a[i] - '0';
		}
		return sum;
	}
	return sum;
}

bool compare(string a, string b){
	// 길이가 짧은 순서 우선
	if(a.length() < b.length()){
		return 1; //우선순위 높다 
	}else if(a.length() > b.length()){
		return 0;
	}else{
		int aSum = getSum(a);
		int bSum = getSum(b);
		if(aSum != bSum){
			return aSum < bSum; //숫자 카운트가 다르다면 
		}else{
			return a<b; //사전순 정렬 
		}
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
