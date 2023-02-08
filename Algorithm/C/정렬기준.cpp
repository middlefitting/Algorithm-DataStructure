//정렬 기준 마음대로 정의하기
#include <iostream>
#include <algorithm>

using namespace std;

class Student{ //class는 보통 여러가지 변수를 묶기 위해 사용 //객체를 만들어줌 
public:
	string name;
	int score;
	Student(string name, int score){ //생성자 
		this->name = name;
		this->score = score; //학생의 입력을 받는 초기화 함수의 생성 
	}
	//정렬 기준은 점수가 작은 순서 
	bool operator < (Student & student){ //creator를 만들어준다.  --> 왼쪽이 오른쪽보다 작다(기본함수) 
		return this -> score < student.score;
	}
}; 

bool compare(int a, int b){
	return a < b; //a가 b보다 작을때 우선적으로 정렬 //true값 반환// 더 작은 값 앞으로 //오름차순 
} 

int main(void) {
	int a[10] = {9,3,5,4,1,10,8,6,7,2};
	sort(a, a+10, compare); //메모리 주소 a와 정렬할 마지막 원소가 있는 메모리 주소  a+10 

	for(int i=0; i<10; i++){
		cout << a[i] << ' ';
	}
	
	Student students[] = {
		Student("나동빈", 90),
		Student("이상욱", 93),
		Student("박한올", 97),
		Student("강종구", 87),
		Student("이태일", 92)
	};
	
	sort(students, students + 5); //두개의 인자값만 넣어주면 알아서 정렬이 수행된다. 기준을 넣어줬기 때문에
	
	for(int i=0; i<5; i++){
		cout << students[i].name << ' ' << students[i].score << ' ';
	}
	
	
}
