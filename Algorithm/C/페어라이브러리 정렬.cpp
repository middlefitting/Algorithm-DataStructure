//클래스는 실무에서 쓰는 것이지 속도 면에서 그렇게 빠르지 않다 
//따라서 페이 라이브러리를 작성
#include <iostream>
#include <vector>
#include <algorithm>
// 어떤 경우에는 벡터가 효율적이고 어떤 경우에는 알고리즘 그냥 쓰는게 좋을 수도 있다.
//단순 배열과 벡터는 큰 차이가 없다고 생각해도 된다.
//백터는 배열을 보다 사용하기 쉽게 개편한 자료구조라 할 수 있다. 
//페어 STL은 한 쌍의 데이터를 처리할 수 있도록 해주는 자료구조라 할 수 있다. 
using namespace std;

int main(void){
	vector<pair<int, string> > v; //한 쌍의 데이터를 묶어주게 된다.
	v.push_back(pair<int, string>(90, "박한울")); 
	v.push_back(pair<int, string>(85, "이태일")); 
	v.push_back(pair<int, string>(82, "나동빈")); 
	v.push_back(pair<int, string>(98, "강종구")); 
	v.push_back(pair<int, string>(79, "이상욱")); 
	
	
	sort(v.begin(), v.end());
	for(int i=0; i<v.size(); i++){
		//벡터로 만든 리스트 접근을 위해 다양한 함수 사용
		//push_back: 리스트의 마지막 부분에 삽입
		//size : 삽입되고 몇개의 데이터가 있는지, 데이터 크기 
		cout << v[i].second << ' '; //second는 두번째 값을 말한다. == 이름정보 
	}
	return 0; 
} 


 
