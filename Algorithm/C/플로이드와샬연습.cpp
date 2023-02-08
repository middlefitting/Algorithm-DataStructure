//플로이드와샬 연습

#include <stdio.h>
int number =  4;
int INF = 1000000000;

int a[4][4]  = {
	{0, 5, INF, 8},
	{7, 0, 9, INF},
	{2, INF, 0, 4},
	{INF, INF, 3, 0},
};

void floydWarshall(){
	
	int d[number][number];
	
	for(int i = 0; i<number; i++){
		for(int j=0; j<number; j++){
			d[i][j] = a[i][j];
		}
	}
	
	for(int k =0; k<number; k++){
		for(int i = 0; i<number; i++) {
			for(int j = 0; j<number; j++){
				if(d[i][k] + d[k][j] < d[i][j]){
					d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}
	
	for(int i=0; i<number; i++){
		for(int j = 0; j<number; j++){
			printf("%d ", d[i][j]);
		}
		printf("\n");
	}
}

int main(void){
	floydWarshall();
	return 0;
}

