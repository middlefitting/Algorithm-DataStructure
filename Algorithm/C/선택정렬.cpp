//선택 정렬은 가장 작은 것을 선택해서 제일 앞으로 보내자는 것
//시간 복잡도는 O(N^2) ==> N*(N+1)/2 ==> O(N*N)
//빅오 표기법은 간단하게 말하면 특정 알고리즘의 수행시간을 가장 간단하게 표기하는 것을 말한다.
//N^2은 매우 비효율적인 알고리즘 
#include <stdio.h>

int main(void){
	int i,j,min,index,temp;
	int numArray[10] = {10,9,8,7,6,5,4,3,2,1};
	
	for(i=0;i<10;i++){
		min = 9999;
		for(j=i;j<10;j++){
			if(min > numArray[j]){
				min = numArray[j];
				index = j;
			}
		}
		//스와핑 
		temp = numArray[i];
		numArray[i] = numArray[index];
		numArray[index] = temp;
	}
	
	for(i=0; i<10; i++){
		printf("%d\n", numArray[i]);
	}
	
	return 0;
}
