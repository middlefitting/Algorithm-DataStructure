//병합정렬
//편향되게 분할할 가능성이 없다.
// 최악의 경우에도 O(NlogN)을 보장한다.
// 일단 반으로 나누고 나중에 합쳐서 정렬하는 알고리즘
#include <stdio.h>

int number = 8;
int sorted[8]; //정렬 배열은 반드시 전역 변수로 선언
//추가적인 배열이 필요한데 필요할 때마다 배열을 생성하면 비효율적이기 때문 

void merge(int a[], int m, int middle, int n){
	int i = m; //배열 시작 위치
	int j = middle + 1;
	int k = m; //전역변수 k는 i와 동일한 위치
	//작은 순서대로 배열에 삽입 
	while(i <= middle && j<=n) {
		if(a[i] <= a[j]){ //i있는 값이 j있는 값보다 작으면 
			sorted[k] = a[i]; //k에 i에 있는 값 넣어준다 
			i++;
		}
		else{
			sorted[k] = a[j];
			j++;
		}
		k++; //다음 원소에 값을 넣을 수 있도록 해준다.
	}
	//남은 데이터도 삽입
	if(i>middle){ //i가 먼저 끝나면 
		for(int t = j; t<=n; t++){
			sorted[k] = a[t];
			k++;
		}
	}
	else{
		for(int t = i; t<=middle; t++){
			sorted[k] = a[t];
			k++;
		}
	} 
	//a를 정렬했으니 sorted에 넣어야 한다. 정렬된 배열을 삽입
	for(int t = m; t<=n; t++){
		a[t] = sorted[t];
	}	 
}

void mergeSort(int a[], int m, int n){ //배열, 시작, 끝 
	//크기가 1보다 큰 경우만 따질 수 있도록 
	if(m<n){
		int middle = (m + n) / 2;  
		mergeSort(a, m, middle); //왼쪽 병합정렬 수행 
		mergeSort(a, middle + 1, n); //오른쪽 병합정렬 수행
		merge(a, m, middle, n); //나중에 합친다. 
	}
}

int main(void) {
	int array[number] = {7,6,5,8,3,5,9,1};
	mergeSort(array, 0, number - 1);
	for(int i = 0; i< number; i++){
		printf("%d\n", array[i]);
	}
}
 
 
 
