//14852
//1개는 2개
//2개는 추가로 3가지
//3개만큼이면 추가로 2가지 
//4개만큼이면 추가로 2가지....

int d[1000001];

int dp(int x){
	if(x == 0) return 1;
	if(x == 1) return 2;
	if(x == 2) return 7;
	if(d[x] != 0) return d[x];
	int result = 3 * dp(x-2) + 2*dp(x-1);
	for(int i = 3; i <= x; i++){
		//앞에 있는 것에 2를 곱해주는 것이기 때문에 dp의 개념이 사용될 수 있다 2차원 dp 
		result +=(2 * dp(x-i)) % 1000000007; 
	}
	return d[x] = result % 1000000007;
}

int main(void){
	int x;
	scanf("%d", &x);
	printf("%d", dp(x));
}

