#include <iostream>
using namespace std;

int main (){
	
	//arrays
	int arr[5] = {1,2,3,4,5};
	int arrSize = sizeof(arr) / sizeof(arr[0]);

	// for 
	for(int i=0; i<arrSize; i++){
		cout << arr[i] << endl;
	}

	// while 
	int y = 4;
	while(y >= 0){
		cout << arr[y] << endl;
		y--;
	}

	return 0;
}