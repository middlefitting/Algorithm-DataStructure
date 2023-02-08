//�����佺�׳׽��� ü
//�Ҽ� �Ǻ� �˰���
//�Ҽ��� ���� ����� �ΰ��� ������ �ڿ���
#include<stdio.h>
#include<math.h> 

bool isPrimeNumber(int x){
	for(int i =2; i<x; i++){
		if(x%i ==0) return false; //����� ������ false 
	}
	return true;
}

//int main(void){
//	printf("%d", isPrimeNumber(97));	
//}

//�ش� �˰����� �ð� ���⵵�� O(N) �̴� ��� ����� ���� �� ���ƾ� �ϱ� �����̴�. ��ȿ�����̴�.
//����� O(N^(1/2))������ Ȯ���ص� ����� �����մϴ�. ��Ī�� �̷�� �����̴�.
//�����ٱ����� ����� ���θ� �����ϸ� �ȴ�.

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

//�뷮�� �Ҽ��� �ѹ��� �Ǻ��ϰ��� �� �� ����ϴ� ���� �����佺�׳׽��� ä�̴�.
//�迭�� ���� �־��ش�.
//����� ��� �����ش� �ڱ� �ڽ��� �������� �ʴ´�.
//������ ���ڴ� �����ϰ� �ǳʶڴ�.
//�����ڿ� ���ؼ� �����Ѵ� 

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






