#include<stdio.h>

int data[1000001];
int number;

void quickSort(int *data, int start, int end)
{
	if(start>=end){
		return;
	}
	
	int key = start;
	int i = key + 1;
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
			data[i] = temp;
		}
	}
	quickSort(data, j+1, end);
	quickSort(data, 0 , j-1);
}

int main(void) {
	
	scanf("%d", &number);
	
	for(int i=0; i<number; i++){
		scanf("%d", &data[i]);
	}
	
	quickSort(data, 0, number-1);
	
	for(int i=0; i<number; i++){
		printf("%d\n", data[i]);
	}
}
