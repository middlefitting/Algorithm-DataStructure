#include<stdio.h>

int number = 6;
int INF = 1000000000;
bool v[6];
int d[6];
int a[6][6] = {
	{0, 2, 5, 1, INF, INF},
	{2,0,3,2, INF, INF},
	{5,3,0,3,1,5},
	{1,2,3,0,1,INF},
	{INF,INF,1,1,0,2},
	{INF,INF,5,INF,2,0}
};


int getMinIndex(){
	int index = 0;
	int min = INF;
	
	for(int i=0; i<number; i++){
		if(!v[i] && d[i]<min){
			min = d[i];
			index = i;
		}
	}
	return index;
}


void dijkstra(int start) {
	v[start] = true;
	for(int i =0; i<number; i++){
		d[i] = a[start][i];
	}
	
	for(int i = 0; i<number-2; i++){
		int current = getMinIndex();
		v[current] = true;
		
		for(int j = 0; j<number; j++){
			if(!v[j] && d[j] > d[current] + a[current][j]){
				d[j] = d[current] + a[current][j];
			}
		}
	}
}


int main(void) {
	dijkstra(0);
	
	for(int i = 0; i<number; i++) {
		printf("%d ", d[i]);
	}
}
