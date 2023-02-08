//��� ī�� �˰���
//�Ϲ����� ��� ������ �۵�
//�ؽñ��
//��¡�ϴ� �����ͷ� �ٲپ� ó���Ѵ�
//�ܼ� �ؽ� �˰����� ���� �ӵ��� O(1)
//�� ������ �ƽ�Ű �ڵ� ���� 2�� ���� ���� ���ʴ�� ���Ͽ� �����ش�.
//�ſ� ���� Ȯ���� �ؽð��� �ٸ��� ���´�.
//���ڿ��� �޶����� ����� �ؽð��� �ٲ�� ���� �� �� �ִ�.
//�ؽð��� �ߺ��Ǵ� �ؽð� �浹�� �Ͼ���� �߻����� ���� �ʴ�.
//������ �⵹�� �Ͼ�� �����͸� �̿��� ���� �ڷᱸ���� ���̿��Ͽ� �ذ�
//�������� ���ڿ� �� �ؽð� ��, �ؽð��� ��ġ�ϴ� ��쿡�� ���ڿ� ��
//��� ī�� �˰��� �ð����⵵ == O(N)
//�ؽ� �� ��ġ ���θ� �����ϱ� ���� ������ ����(MOD)�� ����ϴ� ��찡 ����.
//�Ϲ������� �����÷ο찡 �߻��ص� �ؽ� �� ��ü�� �����ϱ� ������ ���� ������ ������ ������� �ʾƵ� �ȴ�.
//������ �������� ����Ѵٸ� ������������ ����϶�
 
 
#include<iostream>

using namespace std;

void findString(string parent, string pattern) {
	int parentSize = parent.size();
	int patternSize = pattern.size();
	int parentHash = 0, patternHash = 0, power = 1; //power�� �������� �ǹ��Ѵ�. 
	//��ü��ġ���� �ϳ��� �˻縦 �ϰڴٴ� �� 
	for(int i = 0; i<=parentSize - patternSize; i++) {
		//i�� 0�϶��� j�� �̿��ؼ� �ؽð��� �����. 
		if(i ==0) {
			for(int j = 0; j<patternSize; j++) {
				parentHash += parent[patternSize -1 - j] * power;
				patternHash +=pattern[patternSize-1-j] * power;
				if(j<patternSize -1 ) power *= 2;
			}
		} else{
			//���� ���� �� ���� 2������ 
			parentHash = 2 * (parentHash - parent[i-1]*power) + parent[patternSize - 1 + i];
			printf("%d   %d\n", parentHash, patternHash);
		}
		if(parentHash == patternHash){
			bool finded = true;
			for(int j = 0; j<patternSize; j++) {
				if(parent[i+j] != pattern[j]){
					finded = false;
					break;
				}
			}
			if(finded){
				printf("%d��°���� ã�ҽ��ϴ�!\n", i+1);
			}
		}
	}
}

int main(void) {
	string parent = "ababacabacaabacaaba";
	string pattern = "abacaaba";
	findString(parent, pattern);
	return 0;
}
