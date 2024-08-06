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

//  in C++ switch only works with Integral or ENUM types 
	int day;
	cout << endl << "Enter day - "; 
	cin >> day;
	switch(day)
	{
	case 1:
		cout << "HARSH";
		break;
	case 2:
		cout << "AYUSH";
		break;
	default:
		cout << "MRINAL";
		break;
	}

	return 0;
}