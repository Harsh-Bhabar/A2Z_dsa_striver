#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

void printVector(vector<int> arr)
{
	// normal
	cout << endl
		 << "Arr - ";
	for (auto it = arr.begin(); it != arr.end(); it++)
	{
		cout << *it << " ";
	}
	// reverse
	cout << endl
		 << "Reversed Arr - ";
	for (auto it = arr.rbegin(); it != arr.rend(); it++)
	{
		cout << *it << " ";
	}
}

void all_vector(){
	// Vector
	vector<int> arr; //= {1,2,3,4,5,6,7,8};
	// -- empty
	if (arr.empty())
	{
		cout << "Arr is empty rn.";
	}
	// -- insert
	for (int i = 0; i < 10; i++)
	{
		arr.push_back(i + 1);
	}
	// -- print
	printVector(arr);
	// -- front
	cout << endl
		 << "front - " << arr.front();
	// -- end
	cout << endl
		 << "back - " << arr.back();
	// -- at
	cout << endl
		 << "at(2) - " << arr.at(2);
	// -- size
	cout << endl
		 << "size - " << arr.size();
	// -- pop_back
	for (int i = 0; i < 5; i++)
	{
		arr.pop_back();
	}
	// -- erase
	cout << endl
		 << "Element at 1 erased";
	arr.erase(arr.begin());
	printVector(arr);
}

void printMap(unordered_map<string, int> mp){
	for (auto x : mp)
	{
		cout << x.first << " " << x.second << endl;
	}
}

void all_map(){
	unordered_map<string, int> mp;
	// insert
	mp["harsh"] = 1;
	mp["mrinal"] = 2;
	mp["ayush"] = 3;
	mp.insert(make_pair("pankaj", 4));

	// print
	printMap(mp);

	// search
	if (mp.find("rakshi") == mp.end())
	{
		cout << "Key not found" << endl;
	}
	if (mp.find("pankaj") != mp.end())
	{
		cout << "Key found" << endl;
	}

	// erase 
	mp.erase("ayush");
	printMap(mp);
}

int main(){
	// Vector
	// all_vector();

	// Map
	all_map();

	return 0;
}