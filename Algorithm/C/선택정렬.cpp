//���� ������ ���� ���� ���� �����ؼ� ���� ������ �����ڴ� ��
//�ð� ���⵵�� O(N^2) ==> N*(N+1)/2 ==> O(N*N)
//��� ǥ����� �����ϰ� ���ϸ� Ư�� �˰����� ����ð��� ���� �����ϰ� ǥ���ϴ� ���� ���Ѵ�.
//N^2�� �ſ� ��ȿ������ �˰��� 
#include <stdio.h>

int main(void){
	int i,j,min,index,temp;
	int numArray[10] = {10,9,8,7,6,5,4,3,2,1};
	
	for(i=0;i<10;i++){
		min = 9999;
		for(j=i;j<10;j++){
			if(min > numArray[j]){
				min = numArray[j];
				index = j;
			}
		}
		//������ 
		temp = numArray[i];
		numArray[i] = numArray[index];
		numArray[index] = temp;
	}
	
	for(i=0; i<10; i++){
		printf("%d\n", numArray[i]);
	}
	
	return 0;
}
