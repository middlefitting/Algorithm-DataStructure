//다익스트라알고리즘 개선 연습


#include<stdio.h>
#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int number = 6;
int INF = 1000000000;
int d[7];
vector<pair<int,int> > a[7];

void dijkstra(int start) {
	d[start] = 0;
	priority_queue<pair<int,int> >pq;
	pq.push(make_pair(1,0));
	
	while(!pq.empty()){
		int current = pq.top().first;
		int distance = -pq.top().second;
		pq.pop();
		if(d[current]<distance) continue; //더 크면 할 가치가 없으므로 생략 //최초는 어처피 무한이라 실행이됨 //그리고 걔 기준도 실행//근데 더 큰 방향으로 다시가는건 말이 안되는 것//그리고 무한루프에 빠지게 된다 
		
		for(int i=0; i<a[current].size(); i++){
			int next = a[current][i].first;
			int nextDistance = distance + a[current][i].second;
			if(nextDistance < d[next]){
				d[next] = nextDistance;
			}
			pq.push(make_pair(next, -nextDistance));
		}
	}
}


int main(void){
	for(int i =1; i<=number; i++){
		d[i] = INF;
	}
	
	a[1].push_back(make_pair(2, 2));
	a[1].push_back(make_pair(3, 5));
	a[1].push_back(make_pair(4, 1));
	
	a[2].push_back(make_pair(1, 2));
	a[2].push_back(make_pair(3, 3));
	a[2].push_back(make_pair(4, 2));
	
	a[3].push_back(make_pair(1, 5));
	a[3].push_back(make_pair(2, 3));
	a[3].push_back(make_pair(4, 3));
	a[3].push_back(make_pair(5, 1));
	a[3].push_back(make_pair(6, 5));
	
	a[4].push_back(make_pair(1, 1));
	a[4].push_back(make_pair(2, 2));
	a[4].push_back(make_pair(3, 3));
	
	
	a[5].push_back(make_pair(3, 1));
	a[5].push_back(make_pair(4, 1));
	a[5].push_back(make_pair(6, 2));
	
	a[6].push_back(make_pair(3, 5));
	a[6].push_back(make_pair(5, 2));
	
	dijkstra(1);
	
	for(int i =1; i<=number; i++){
		printf("%d ", d[i]);
	}
}
