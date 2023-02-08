//14852
//1���� 2��
//2���� �߰��� 3����
//3����ŭ�̸� �߰��� 2���� 
//4����ŭ�̸� �߰��� 2����....

int d[1000001];

int dp(int x){
	if(x == 0) return 1;
	if(x == 1) return 2;
	if(x == 2) return 7;
	if(d[x] != 0) return d[x];
	int result = 3 * dp(x-2) + 2*dp(x-1);
	for(int i = 3; i <= x; i++){
		//�տ� �ִ� �Ϳ� 2�� �����ִ� ���̱� ������ dp�� ������ ���� �� �ִ� 2���� dp 
		result +=(2 * dp(x-i)) % 1000000007; 
	}
	return d[x] = result % 1000000007;
}

int main(void){
	int x;
	scanf("%d", &x);
	printf("%d", dp(x));
}

