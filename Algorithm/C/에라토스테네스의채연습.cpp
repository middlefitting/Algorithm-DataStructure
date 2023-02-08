//에라토스테네스의 채 연습

#include<stdio.h>
#include<math.h>

int number = 10000;
int a[10001];

void primeNumberSieve(){
	for(int i = 2; i<=number; i++){ //1은 소수가 아니다. 
		a[i] = i;
	}
	
	int x = (int) sqrt(number);
	
	for(int i=2; i<=x; i++){
		
		if(a[i]==0) continue;
		
		for(int j = i*i; j<=number; j+=i){
			a[j] = 0;
		}
	}
	
	for(int k = 2; k<=number; k++){
		if(a[k]!=0) printf("%d ", a[k]);
	}
}

int main(void){
	primeNumberSieve();
}
