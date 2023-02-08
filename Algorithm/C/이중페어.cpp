//3가지 정렬하기 2중페어
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<string, pair<int, int> > a,
			  pair<string, pair<int, int> > b) {
			  	if(a.second.first == b.second.first){ //성적이 같다면 
			  		return a.second.second > b.second.second; //생년월일이 느린 학생이 우선순위, 어린 학생이 우선순위 
				  }
				else{
					return a.second.first > b.second.first; //성적이 더 높은 학생이 우선순위; 
				}
			  }

int main(void){
	vector<pair<string, pair<int, int> > > v; //한 쌍의 데이터를 묶어주게 된다.
	v.push_back(pair<string, pair<int, int> >("나동빈", pair<int, int>(90, 19961222))); 
	v.push_back(pair<string, pair<int, int> >("이태일", pair<int, int>(97, 19930518))); 
	v.push_back(pair<string, pair<int, int> >("박상욱", pair<int, int>(95, 19930203))); 
	v.push_back(pair<string, pair<int, int> >("이상욱", pair<int, int>(90, 19921207))); 
	v.push_back(pair<string, pair<int, int> >("강종구", pair<int, int>(88, 19900302))); 
	
	
	sort(v.begin(), v.end(), compare);
	for(int i=0; i<v.size(); i++){
		//벡터로 만든 리스트 접근을 위해 다양한 함수 사용
		//push_back: 리스트의 마지막 부분에 삽입
		//size : 삽입되고 몇개의 데이터가 있는지, 데이터 크기 
		cout << v[i].first << ' '; //second는 두번째 값을 말한다. == 이름정보 
	}
	return 0; 
} 
//기준이 3개가 넘어가면 pair가 더 복잡할 수도 있다. 그럴때는 class를 정의해서 정렬을 하거나 하자
//프로그래밍 대회에서는 2가지 정도면 vector와 pair를 통해 정렬을 진행한다. 
