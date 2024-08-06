#include<iostream>
using namespace std;

int passByValue(int a){
	a = a+1; // works with a Copy 
	return a;
}

int passByReference(int &b){
	b = b+2; // modifies the actual var
	return b;
}

int main(){
	int value = 5;
	cout << passByValue(value) <<endl;
	cout<< "passByValue: " << value <<endl; // gives 5
	cout << passByReference(value) <<endl;
	cout << "passByReference: " << value <<endl; // gives 7
	return 0;
}