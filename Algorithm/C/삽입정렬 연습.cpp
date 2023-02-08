#include<stdio.h>

int main(void) {
	int i, j , temp;
	
	int array[10] = {10,9,8,7,6,5,4,3,2,1};
	
	for(i=0; i<9; i++){
		j = i;
		while(array[j]>array[j+1]){
			temp = array[j];
			array[j] = array[j+1];
			array[j+1] = array[j];
		}
	}
	
	for(i=0; i<10; i++){
		printf("%d\n", array[i]);
	}
} 
