#include <iostream>
#include <string>
#include <conio.h>
#include "nodo.h"
using namespace std;

string primera_entrada(string x) {
    return x;
}

int main() {
    string input;

    while (true) {
        system("cls");
        cout << "> 'exit' SALIDA: ";
        getline(cin, input);

        if (input == "exit") {
            return 0;
        }

        string result = primera_entrada(input);
        cout << "Resultado de primera_entrada: " << result << endl;

        system("pause"); // Pauses the program to allow the user to read the output
    }
}

#ifndef NODO_H_INCLUDED
#define NODO_H_INCLUDED

class nodo{
private:
    int valor;
    nodo* sig;
    nodo* ant;
};

class pila{
public:
    nodo* raiz;
    pila();
};

#endif // NODO_H_INCLUDED
