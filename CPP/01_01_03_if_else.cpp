#include<iostream>
using namespace std;

int main(){
	int x;
	cout << "Enter x - "; 
	cin >> x ;
	if (x == 18){
		cout << "Just reached boundary at " << x;
	}
	else if(x > 18 and x <= 40){
		cout << "ELIGIBLE at " << x ;
	}
	else{
		cout << "NOT ELIGIBLE at " << x;
	}
	return 0;
}