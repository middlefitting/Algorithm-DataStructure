//���� ��ȹ�� DP ���̳��� ���α׷��� ��������
//Ÿ�� ä��� 
#include<stdio.h>

int d[1001];


int dp(int n){
	if(n==1) return 1;
	if(n==2) return 3;
	if(d[n]!=0) return d[n];
	
	return d[n] = (2*dp(n-2) + dp(n-1))%10007;
} 

int main(void){
	int n;
	scanf("%d", &n);
	printf("%d\n", dp(n));
}
