//에라토스테네스의 체
//소수 판별 알고리즘
//소수는 양의 약수를 두개만 가지는 자연수
#include<stdio.h>
#include<math.h> 

bool isPrimeNumber(int x){
	for(int i =2; i<x; i++){
		if(x%i ==0) return false; //약수가 나오면 false 
	}
	return true;
}

//int main(void){
//	printf("%d", isPrimeNumber(97));	
//}

//해당 알고리즘의 시간 복잡도는 O(N) 이다 모든 경우의 수를 다 돌아야 하기 때문이다. 비효율적이다.
//사실은 O(N^(1/2))까지만 확인해도 계산이 가능합니다. 대칭을 이루기 때문이다.
//제곱근까지만 약수의 여부를 검증하면 된다.

bool isPrimeNumber2(int x){
	int end = (int) sqrt(x);
	for(int i = 2; i<=end; i++){
		if(x % i ==0) return false;
	}
	return true;
}

//int main(void){
//	printf("%d", isPrimeNumber2(97));
//	return 0;
//}

//대량의 소수를 한번에 판별하고자 할 때 사용하는 것이 에라토스테네스의 채이다.
//배열에 숫자 넣어준다.
//배수를 모두 지워준다 자기 자신을 지우지는 않는다.
//지워진 숫자는 무시하고 건너뛴다.
//모든숫자에 대해서 실행한다 

int number = 10000;
int a[10001];

void primeNumberSieve() {
	for(int i = 2; i<=number; i++){
		a[i] = i;
	}
	for(int i=2; i<=number; i++){
		if(a[i]==0) continue;
		for(int j=i+i; j<=number; j+=i){
			a[j] = 0; 
		}
	}
	for(int i=2; i<=number; i++){
		if(a[i]!=0) printf("%d ", a[i]); 
	}
}

void primeNumberSieve2() {
	for(int i = 2; i<=number; i++){
		a[i] = i;
	}
	
	int sqnum = (int) sqrt(number);
	
	for(int i=2; i<=sqnum; i++){
		if(a[i]==0) continue;
		for(int j=i+i; j<=number; j+=i){
			a[j] = 0; 
		}
	}
	for(int i=2; i<=number; i++){
		if(a[i]!=0) printf("%d ", a[i]); 
	}
}

void primeNumberSieve3() {
	for(int i = 2; i<=number; i++){
		a[i] = i;
	}
	
	int sqnum = (int) sqrt(number);
	
	for(int i=2; i<=sqnum; i++){
		if(a[i]==0) continue;
		for(int j=i*i; j<=number; j+=i){
			a[j] = 0; 
		}
	}
	for(int i=2; i<=number; i++){
		if(a[i]!=0) printf("%d ", a[i]); 
	}
}

int main(void){
	primeNumberSieve3();
}






