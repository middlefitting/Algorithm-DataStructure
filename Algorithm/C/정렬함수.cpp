#include <iostream>
#include <algorithm>
//두개는 대표적인 stl 라이브러리 들이다 

using namespace std;

int main(void) {
	int a[10] = {9,3,5,4,1,10,8,6,7,2};
	sort(a, a+10); //메모리 주소 a와 정렬할 마지막 원소가 있는 메모리 주소  a+10 

	for(int i=0; i<10; i++){
		cout << a[i] << ' ';
	}	
}
