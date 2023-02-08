#include<stdio.h>
int i,j,temp,min,index;

int array[10] = {10,9,8,7,6,5,4,3,2,1};

int main(void){
	for(int i=0; i<10; i++){
		min = 9999;
		for(int j=i; j<10; j++){
			if(min > array[j]){
				min = array[j];
				index = j;
			}
		}
		
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}


	for(int i=0; i<10; i++) {
		printf("%d ", array[i]);
	}
}

