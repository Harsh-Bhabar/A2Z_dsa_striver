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

	// 3 - pyramid
	for (int i = 1; i <= n; ++i)
	{
		// Print leading spaces
		for (int j = 0; j < n - i; ++j)
		{
			// cout << "#";
			cout << " ";
		}
		// Print asterisks
		for (int k = 0; k < (2 * i - 1); ++k)
		{
			cout << "*";
		}
		// Move to the next line
		cout << endl;
	}

	return 0;
}