#include<iostream>
#include<algorithm>

using namespace std;

string a[20001];
int n;

int getSum(string a){
	int length = a.length();
	int sum = 0;
	for(int i = 0; i<length; i++){
		if(a[i]-'0'<=9 && a[i] - '0'>=0){
			
		}
	}
}


bool compare(string a, string b){
	if(a.length() < b.length()){
		return 1;
	}
	if(a.length() > b.length()){
		return 0;
	}
	else{
		int aSum = getSum(string a);
		int bSum = getSum(string b);
		
		if(aSum != bSum){
			return aSum<bSum;
		}else{
			return a<b;
		}
	}
}

int main(void){
	cin >> n;
	
	for(int i = 0; i<n; i++){
		cin >> a[i];
	}
	
	sort(a, a+n, compare);
	
	for(int i=0; i<n; i++){
		if(i>0 && a[i] == a[i-1]){
			continue;
		}
		else{
			cout << a[i] << '\n';
		}
	}
}
