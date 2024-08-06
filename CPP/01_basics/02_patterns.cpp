#include<iostream>
using namespace std;

int main(){

	int n ;
	cout << "Enter n : ";
	cin >> n ;

	// 1 - basic
	for(int i=0; i<n; i++){
		for(int j=0; j<=i; j++){
			cout << "*";
			// cout << j+1;
			// cout << i+1;
		}cout << endl;
	}

	// 2 - reverse
	for(int i=n; i>0; i--){
		for(int j=0; j<i; j++){
			// cout << "*";
			cout << j+1;
			// cout << i;
		}cout << endl;
	}



	return 0;
}