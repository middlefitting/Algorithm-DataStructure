//��������
//����ǰ� ������ ���ɼ��� ����.
// �־��� ��쿡�� O(NlogN)�� �����Ѵ�.
// �ϴ� ������ ������ ���߿� ���ļ� �����ϴ� �˰���
#include <stdio.h>

int number = 8;
int sorted[8]; //���� �迭�� �ݵ�� ���� ������ ����
//�߰����� �迭�� �ʿ��ѵ� �ʿ��� ������ �迭�� �����ϸ� ��ȿ�����̱� ���� 

void merge(int a[], int m, int middle, int n){
	int i = m; //�迭 ���� ��ġ
	int j = middle + 1;
	int k = m; //�������� k�� i�� ������ ��ġ
	//���� ������� �迭�� ���� 
	while(i <= middle && j<=n) {
		if(a[i] <= a[j]){ //i�ִ� ���� j�ִ� ������ ������ 
			sorted[k] = a[i]; //k�� i�� �ִ� �� �־��ش� 
			i++;
		}
		else{
			sorted[k] = a[j];
			j++;
		}
		k++; //���� ���ҿ� ���� ���� �� �ֵ��� ���ش�.
	}
	//���� �����͵� ����
	if(i>middle){ //i�� ���� ������ 
		for(int t = j; t<=n; t++){
			sorted[k] = a[t];
			k++;
		}
	}
	else{
		for(int t = i; t<=middle; t++){
			sorted[k] = a[t];
			k++;
		}
	} 
	//a�� ���������� sorted�� �־�� �Ѵ�. ���ĵ� �迭�� ����
	for(int t = m; t<=n; t++){
		a[t] = sorted[t];
	}	 
}

void mergeSort(int a[], int m, int n){ //�迭, ����, �� 
	//ũ�Ⱑ 1���� ū ��츸 ���� �� �ֵ��� 
	if(m<n){
		int middle = (m + n) / 2;  
		mergeSort(a, m, middle); //���� �������� ���� 
		mergeSort(a, middle + 1, n); //������ �������� ����
		merge(a, m, middle, n); //���߿� ��ģ��. 
	}
}

int main(void) {
	int array[number] = {7,6,5,8,3,5,9,1};
	mergeSort(array, 0, number - 1);
	for(int i = 0; i< number; i++){
		printf("%d\n", array[i]);
	}
}
 
 
 
