#include <iostream>
#include <conio.h> // Para _getch()

using namespace std;

int main() {
    char opcion;
    string error_log = "Expresión no valida";
    while (true) {
        system("cls");
        cout << "Presiona 'q' para salir, 'c' para continuar, o cualquier otra tecla para ver la opción seleccionada: ";

        opcion = _getch(); // Lee un carácter sin necesidad de presionar Enter

        switch (opcion) {
            case 'q':
            case 'Q':
                cout << "\nSaliendo del programa..." << endl;
                return 0; // Salir del programa

            case 'c':
            case 'C':
                cout << "\nContinuando... (presiona 'q' para salir o 'c' para continuar)" << endl;
                break;

            default:
                cout << "\nOpción seleccionada: " << opcion << endl;
                break;
        }
    }

    return 0;
}
