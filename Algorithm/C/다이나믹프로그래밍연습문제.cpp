//동적 계획법 DP 다이나믹 프로그래밍 연습문제
//타일 채우기 
#include<stdio.h>
#include<iostream>

using namespace std;

int d[1001];


int dp(int n){
	if(n==1) return 1;
	if(n==2) return 2;
	if(d[n]!=0) return d[n];
	
	return d[n] = (dp(n-2) + dp(n-1))%10007;
} 

int main(void){
//	cin >> n;
	int n;
	scanf("%d", &n);
	printf("%d\n", dp(n));
}
