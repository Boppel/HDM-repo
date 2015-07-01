//============================================================================
// Name        : C++_chapter01.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cstdio>
#include <cstdlib>
using namespace std;

int main(int nNumberOfArgs, char* pszArgs[]) {

	// temperatur in celsius eingeben
	int celsius;
	cout << "Geben Sie die Temperatur in Celsius ein: ";
	cin >> celsius;

	// umrechenfaktor
	// F = C * (212 - 32) / 100 - 32
	int factor = 212 - 32;

	// temperatur in fahrenheit umrechnen
	int fahrenheit = factor * celsius / 100 + 32;

	// ergebnis ausgeben
	cout << "entspricht in Fahrenheit: ";
	cout << fahrenheit << endl;

	// warten bis der user gelesen & beendet
	cout << "Druecken Sie Enter, um fortzufahren..." << endl;
	cin.ignore(10, '\n');
	cin.get();

	return 0;
}
