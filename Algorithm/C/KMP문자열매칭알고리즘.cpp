//KMP ���ڿ� ��Ī �˰���
//Knuth-Morris-Pratt �˰���
//���ڿ� ��Ī �˰������� ���� ���� Ȱ��
//�ܼ��ϰ� ��� ���ϴ� ��� �־��� ��� ���� �ð��� �ҿ�ȴ�
// ������ ��� ��츦 �� ������ �ʾƵ� �κ� ���ڿ��� ã�� �� �ִ� kmp�˰����� ����Ѵ� 
//���λ�� ���̻��� ������ ����Ѵ�.
//���ʿ��� �κ��� �����Ѵ�. 
//���λ�� ���̻��� �ִ� ��ġ ���̸� Ȯ���Ѵ�.
#include<iostream>
#include<vector>

using namespace std;

vector<int> makeTable(string pattern){
	//ã���� �ϴ� ���ڿ� ���� 
	int patternSize = pattern.size();
	//���� �����ŭ 0�ʱ�ȭ 
	vector<int> table(patternSize, 0);
	int j = 0;
	//��� ���� �Ѱ��� Ȯ�� 
	for(int i = 1; i<patternSize; i++){
		//��ġ���� ������ 
		while(j>0 &&pattern[i] != pattern[j]){
			//�ε��� ���̺� ������ �ε��� ���� 
			j = table[j-1];
		}
		if(pattern[i] == pattern[j]){
			//���� j�� 1�� ���� �� 
			table[i] = ++j;  
		}
	}
	return table;
}

void KMP(string parent, string pattern){
	vector<int> table = makeTable(pattern);
	int parentSize = parent.size();
	int patternSize = pattern.size();
	int j = 0;
	for(int i =0; i<parentSize; i++){
		while(j>0 && parent[i] !=pattern[j]){
			//��ġ���� �ʾ����� �����ܰ� ������ �̵� 
			j = table[j-1];
			printf("======%d\n", j);
		}
		//��ü ���ڿ��� ��ġ�Ͽ��� �� 
		if(parent[i] ==pattern[j]){
			if(j==patternSize -1){
				printf("%d��°���� ã�ҽ��ϴ�.\n", i-patternSize+2); //2�� �� ���ϳ�
				j = table[j]; //������ ���� j���� //��� ��� ã�ƾ� �ϱ� ������ 
			} else{
				printf("======%d�ͺ�\n", j);
				//�ƴϸ� j���ؼ� ���Ȯ�� 
				j++; //0 1 2 3 // table[2] == 1
			}
		}
	}
}

int main(void){
	string parent = "ababacabacaabacaaba";
	string pattern = "abacaaba";
	KMP(parent, pattern);
	//ã���� �ϴ� ���ڿ��� ���̺� ���� 
	vector<int> table = makeTable(pattern);
	for(int i = 0; i<table.size(); i++){
		printf("%d ", table[i]);
	}
	return 0;
}
 
