#include <iostream>
#include <algorithm>

using namespace std;

int n;
int a[10001]; //배열 전역변수 선언해주면 프로그램 시작과 동시에 0 초기화 된다. 

int main(void){
	scanf("%d", &n);
	for(int i = 0; i<n ; i++){
		int x;
		scanf("%d", &x);
		a[x]++;
	}
	
	for(int i = 0; i<10001; i++){
		while(a[i]!=0){
			printf("%d\n", i);
			a[i]--;
		}
	}
}
