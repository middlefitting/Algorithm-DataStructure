#include<stdio.h>

int number = 10;
int data[10] = {10,9,8,7,6,5,4,3,2,1};

void quickSort(int *data, int start, int end) {
	if(start>=end){
		return;
	}
	
	int key = start;
	int i = key+1;
	int j = end;
	int temp;
	
	while(i<=j){
		while(data[i]<=data[key]){
			i++;
		}
		while(data[j]>=data[key] && j>start){
			j--;
		}
		if(i>j){
			temp = data[j];
			data[j] = data[key];
			data[key] = temp;
		}
		else{
			temp = data[j];
			data[j] = data[i];
			data[i] = data[j];
		}	
	}
	quickSort(data, start, j-1);
	quickSort(data, j+1, end);	
}


int main(void) {
	quickSort(data, 0, number-1);
	for(int i = 0; i<10; i++){
		printf("%d\n", data[i]);
	}
}
