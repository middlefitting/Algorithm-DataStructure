//���� ���� ������� �����ϱ�
#include <iostream>
#include <algorithm>

using namespace std;

class Student{ //class�� ���� �������� ������ ���� ���� ��� //��ü�� ������� 
public:
	string name;
	int score;
	Student(string name, int score){ //������ 
		this->name = name;
		this->score = score; //�л��� �Է��� �޴� �ʱ�ȭ �Լ��� ���� 
	}
	//���� ������ ������ ���� ���� 
	bool operator < (Student & student){ //creator�� ������ش�.  --> ������ �����ʺ��� �۴�(�⺻�Լ�) 
		return this -> score < student.score;
	}
}; 

bool compare(int a, int b){
	return a < b; //a�� b���� ������ �켱������ ���� //true�� ��ȯ// �� ���� �� ������ //�������� 
} 

int main(void) {
	int a[10] = {9,3,5,4,1,10,8,6,7,2};
	sort(a, a+10, compare); //�޸� �ּ� a�� ������ ������ ���Ұ� �ִ� �޸� �ּ�  a+10 

	for(int i=0; i<10; i++){
		cout << a[i] << ' ';
	}
	
	Student students[] = {
		Student("������", 90),
		Student("�̻��", 93),
		Student("���ѿ�", 97),
		Student("������", 87),
		Student("������", 92)
	};
	
	sort(students, students + 5); //�ΰ��� ���ڰ��� �־��ָ� �˾Ƽ� ������ ����ȴ�. ������ �־���� ������
	
	for(int i=0; i<5; i++){
		cout << students[i].name << ' ' << students[i].score << ' ';
	}
	
	
}
