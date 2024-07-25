#include <iostream>
using namespace std;

void print_number(long a)
{
	cout << "Number is " << a << endl;
}

void print_name(string name)
{
	cout << "Name is " << name << endl;
}

void take_input(){
	long a;
	cout << "Enter a number pls" << endl;
	cin >> a;
	cin.ignore(100, '\n');
	
	print_number(a);
	string name;
	cout << "Enter a name pls" << endl;
	getline(cin, name);
	print_name(name);
}

int main(){
	take_input();
	return 0;
}