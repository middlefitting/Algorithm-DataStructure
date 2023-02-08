#include<stdio.h>

int number = 9;
int heap[9] = {9,9,7,1,3,2,6,5,4};

int main(void){
	
	for(int i = 1; i<number; i++){
		int c = i;
		do{
			int root = (c-1)/2;
			if(heap[root] < heap[c]){
				int temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			}
			c = root;
		}while(c!=0);
	}
	
	
	for(int i = number-1; i>0; i--){
		int temp = heap[0];
		heap[0] = heap[i];
		heap[i] = temp;
		
		int c = 1;
		int root = 0;
		
		do{
			c = (root*2) + 1;
			
			if(heap[c] < heap[c+1] && c<i-1){
				c++;
			}
			if(heap[root] < heap[c] && c<i){
				int temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			}
			root = c;
		}while(c<i);
	}

	for(int i = 0; i<number; i++){
		printf("%d\n", heap[i]);	
	}
}
