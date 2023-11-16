/*
    Sarcina nr. 15 (Lacurile)
    Realizat: Bacalu Dan
*/

#include <iostream>
#include <iomanip>
#include <fstream>
#include <windows.h>
#include <string.h>
using namespace std;

ifstream fin("Lacuri.in");
ofstream fout("Lacuri.out");
ofstream fout2("MazPozM.txt");

int n, m; // numarul de linii si coloane
int latura;
int A[50][50];
int B[2500];
char C[50][50];
int nrElementeB;
bool ret = true;
int command;
int cnt;
int aa[100000];

void actualizare(int nrLinie, int nrColoana, int valoare) {

    int com;
    A[nrLinie][nrColoana] = valoare;
    cout << "\n\tDoresti sa modifici continutul fisierului de intrare?" << endl;
    cout << "\tDA --- 1" << endl;
    cout << "\tNU --- 2" << endl;
    cout << "\tCommand: ";
    cin >> com;
    if (com == 1) {
        ofstream fout3("Lacuri.in");
        fout3 << n << " " << m << "\n\n";
        for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j)
            fout3 << A[i][j] << " ";
        fout3 << "\n";
    }
        fout3.close();
    }
    cout << "\n\tExecutat cu succes!" << endl;

}

void excludereLinie(int nrLinie) {

    int n2 = n;
    if (nrLinie == 0) {
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                A[i][j] = A[i + 1][j];
            }
    }
    else if (nrLinie > 0 && nrLinie < n - 1) {
        for (int i = nrLinie; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                A[i][j] = A[i + 1][j];
            }
        }
    } else if (nrLinie == n - 1) {
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (i == n - 1) {
                    A[i][j] = 0;
                }
    }

}

void excludereColoana(int nrColoana) {

    int m2 = m;
    if (nrColoana == 0) {
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                A[i][j] = A[i][j + 1];
    } else if (nrColoana > 0 && nrColoana < m - 1) {
        for (int i = 0; i < n; ++i)
            for (int j = nrColoana; j < m; ++j) {
                A[i][j] = A[i][j + 1];
            }
    } else if (nrColoana == m - 1) {
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (j == m - 1) {
                    A[i][j] = 0;
                }
    }

}

void minimAbsolut() {

    int min = A[0][0];
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
            if (A[i][j] < min)
                min = A[i][j];
    cout << "\tMinimul absolut: " << min << "\n";
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
            if (A[i][j] == min) {
                cout << "\tCoordonatele (x, y): " << i << " " << j << "\n";
            }

}

void sort1 (int st, int dr)
{
    if (st >= dr) {
        return;
    }
    else {
        int mij = (st + dr) / 2;
        sort1(st, mij);
        sort1(mij + 1, dr);
        int x,y,z;
        x = st; y = mij + 1; z = 0;
        while (x <= mij && y <= dr) {
            if (B[x] <= B[y]) {
                aa[++z] = B[x++];
            }
            else {
                aa[++z] = B[y++];
            }
        }
        while (x <= mij) {
            aa[++z] = B[x++];
        }

    while (y <= dr) {
            aa[++z] = B[y++];
        }
        for (int i = st; i <= dr; i++) {
            B[i] = aa[i - st + 1];
        }
    }
}

void inaltimeaZonelor() {

    nrElementeB = 0;
    bool oL = true;
    bool oC = true;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            oL = true;
            oC = true;
            if (i == 0) {
                B[nrElementeB] = A[i][j];
                nrElementeB++;
            }
            if (i == n - 1) {
                B[nrElementeB] = A[i][j];
                nrElementeB++;
            }
            if ((i > 0 && i < n) && (j == 0) && (oL == true)) {
                B[nrElementeB] = A[i][j];
                nrElementeB++;
                oL = false;
            }
            if ((i > 0 && i < n) && (j == m - 1) && (oC == true)) {
                B[nrElementeB] = A[i][j];
                nrElementeB++;
                oC = false;
            }
        }
    }
    sort1(0, nrElementeB - 1);

}

void inaltimeaMedie() {

    double medie;
    int count = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; j++) {
            if (i % 2 != 0) {
                medie += A[i][j];
                count++;
            }
        }
    }
    medie /= count;
    cout << "\tInaltimea medie a zonelor situate pe linii impare: ";
    cout << fixed << setprecision(2) << medie << "\n";

}

void elementMaxim() {

    int max = -2000000000;
    int increment = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (A[i][j] > max)
                max = A[i][j];
        }
        if (A[i][m - 1] == max) {
            for (int a = 0; a < m; ++a) {
                fout2 << A[i][a] << " ";
            }
            fout2 << "\n";
        }
        max = -2000000000;
    }

}

void dreptunghiArieMaximala() {

    int S = 0; // aria
    bool gasit = false;
    int cStangaX, cStangaY, cDreaptaX, cDreaptaY;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if ((j >= 0 && j < m - 2) && (i >= 0 && i < n - 2)) {
                if ((A[i + 1][j + 1] < A[i][j]) && (A[i + 1][j + 1] < A[i][j + 1])
                    && (A[i + 1][j + 1] < A[i][j + 2]) && (A[i + 1][j + 1] < A[i + 1][j])
                        && (A[i + 1][j + 1] < A[i + 2][j]) && (A[i + 1][j + 1] < A[i + 2][j + 1])
                            && (A[i + 1][j + 1] < A[i + 2][j + 2]) && (A[i + 1][j + 1] < A[i + 1][j + 2])) {
                                cStangaX = i + 2;
                                cStangaY = j;
                                cDreaptaX = i;
                                cDreaptaY = j + 2;
                                cout << "\tCoordonatele stanga: " << "X: " << cStangaX << " " << "Y: " << cStangaY << endl;
                                cout << "\n";
                                cout << "\tCoordonatele dreapta: " << "X: " << cDreaptaX << " " << "Y: " << cDreaptaY << endl;
                                int lungime, latime;
                                lungime = A[i][j] + A[i][j + 1] + A[i][j + 2];
                                latime = A[i][j] + A[i + 1][j] + A[i + 2][j];
                                S = lungime * latime;
                                cout << "\n\tAria dreptunghiului: " << S << endl;
                                gasit = true;
                                cout << "\n";
                }
            }
        }
    }
    if (gasit == false) {
        cout << "Nu exista un dreptunghi de arie maximala. " << endl;
    }

}

void check(int pozI, int pozJ, int val) {

    int cnt = 1;
    if ((pozI > 0 && pozI < n - 1) && (pozJ > 0 && pozJ < m - 1)) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (pozI == i && pozJ == j) {
                    if ((A[i][j - 1] >= val) && (A[i][j + 1] >= val) && (A[i + 1][j] >= val) && (A[i - 1][j] >= val))
                        C[i][j] = '*';
                    cnt = 1;
                    while ((A[i][j - cnt] <= val) && (j - cnt > 1) && ((A[i - 1][j - cnt] > val) || (C[i - 1][j - cnt] == '*')) && ((A[i + 1][j - cnt] > val) || (C[i + 1][j - cnt] == '*'))) {
                        C[i][j - cnt] = '*';
                        cnt++;
                    }
                    cnt = 1;
                    while ((A[i][j + cnt] <= val) && (j + cnt < m - 1) && ((A[i - 1][j + cnt] > val) || (C[i - 1][j + cnt] == '*')) && ((A[i + 1][j + cnt] > val) || (C[i + 1][j + cnt] == '*'))) {
                        C[i][j + cnt] = '*';
                        cnt++;
                    }
                    cnt = 1;
                    while ((A[i - cnt][j] <= val) && (i - cnt > 1) && ((A[i - cnt][j - 1] > val) || (C[i - cnt][j - 1] == '*')) && ((A[i - cnt][j + 1] > val) || (C[i - cnt][j + 1] == '*'))) {
                        C[i - cnt][j] = '*';
                        cnt++;
                    }
                    cnt = 1;
                    while ((A[i + cnt][j] <= val) && (i + cnt < n - 1) && ((A[i + cnt][j - 1] > val) || (C[i + cnt][j - 1] == '*')) && ((A[i + cnt][j + 1] > val) || (C[i + cnt][j + 1] == '*'))) {
                        C[i + cnt][j] = '*';
                        cnt++;
                    }

                    for (int i = 1; i < n - 1; ++i) {
                        for (int j = 1; j < m - 1; ++j) {
                            if (C[i][j] == '*') {
                                // <
                                if (A[i][j - 1] <= A[i][j]) {
                                    C[i][j - 1] = '*';
                                }
                                if (A[i][j + 1] <= A[i][j]) {
                                    C[i][j + 1] = '*';
                                }
                                if (A[i - 1][j] <= A[i][j]) {
                                    C[i - 1][j] = '*';
                                }
                                if (A[i + 1][j] <= A[i][j]) {
                                    C[i + 1][j] = '*';
                                }

                                // >
                                if ((A[i][j - 1] >= A[i][j]) && (j - 1 > 0) && (A[i][j - 2] > A[i][j - 1]) && (A[i - 1][j - 1] > A[i][j - 1]) && (A[i + 1][j - 1] > A[i][j - 1]))
                                    C[i][j - 1] = '*';
                                if ((A[i][j + 1] >= A[i][j]) && (j + 1 < m - 1) && (A[i - 1][j + 1] > A[i][j + 1]) && (A[i][j + 2] > A[i][j + 1]) && (A[i + 1][j + 1] > A[i][j + 1]))
                                    C[i][j + 1] = '*';
                                if ((A[i + 1][j] >= A[i][j]) && (i + 1 < n - 1) && (A[i + 2][j] > A[i + 1][j]) && (A[i + 1][j - 1] > A[i + 1][j]) && (A[i + 1][j + 1] > A[i + 1][j]))
                                    C[i + 1][j] = '*';
                                if ((A[i - 1][j] >= A[i][j]) && (i - 1 > 0) && (A[i - 1][j - 1] > A[i - 1][j]) && (A[i - 2][j] > A[i - 1][j]) && (A[i - 1][j + 1] > A[i - 1][j]))
                                    C[i - 1][j] = '*';

                            }
                        }
                    }

                }
            }
        }
    }

}

void lacuri() {

    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
            C[i][j] = 'O';
    for (int i = 1; i < n - 1; ++i) {
        for (int j = 1; j < m - 1; ++j) {
            check(i, j, A[i][j]);
        }
    }

}

int main() {

    system("Color 02");
    fin >> n >> m;
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
            fin >> A[i][j];
    while (ret == true) {

        cout << "\n";
        cout << "\tActualizeaza continutul unei linii / coloane --- 1" << endl;
        cout << "\tExclude din planul tabelei o linie / coloana --- 2" << endl;
        cout << "\tAfiseaza lista inaltimilor zonelor --- 3" << endl;
        cout << "\tDetermina minimul absolut --- 4" << endl;
        cout << "\tInaltimea medie a zonelor situate --- 5" << endl;
        cout << "\tInserarea a valorii maxime (MaxPozM) --- 6" << endl;
        cout << "\tDreptunghi de arie maximala --- 7" << endl;
        cout << "\tSarcina nr. 8 (Ploaia) --- 8" << endl;
        cout << "\tAfisarea matricei --- 9" << endl;
        cout << "\tIesirea din program --- 10" << endl;

        cout << "\n";
        cout << "\tCommand: ";
        cin >> command;
        cout << "\n";

        switch (command) {
            case 1: {
                int nrLinie, nrColoana, valoare;
                cout << "\tNumarul liniei pe care se afla numarul: ";
                cin >> nrLinie;
                cout << "\tNumarul coloanei pe care se afla numarul: ";
                cin >> nrColoana;
                cout << "\tValoarea noua: ";
                cin >> valoare;
                actualizare(nrLinie, nrColoana, valoare);
                break;
            }
            case 2: {
                int nrLinie, nrColoana;
                cout << "\t1 - Excluderea unei linii: " << endl;
                cout << "\t2 - Excluderea unei coloane: " << endl;
                cout << "\tValoare: ";
                int val;
                cin >> val;
                if (val == 1) {
                    cout << "\tLinia ce urmeaza a fi exclusa: ";
                    cin >> nrLinie;
                    excludereLinie(nrLinie);
                    n--;
                } else if (val == 2) {
                    cout << "\tColoana ce urmeaza a fi exclusa: ";
                    cin >> nrColoana;
                    excludereColoana(nrColoana);
                    m--;
                } else
                    cout << "\tNu exista aceasta valoare!";
                break;
            }
            case 3: {
                inaltimeaZonelor();
                cout << "\t";
                for (int i = 0; i < nrElementeB; ++i)
                    cout << B[i] << " ";
                break;
            }
            case 4: {
                minimAbsolut();
                break;
            }
            case 5: {
                inaltimeaMedie();
                break;
            }
            case 6: {
                elementMaxim();
                cout << "\tExecutat cu succes!" << endl;
                break;
            }
            case 7: {
                dreptunghiArieMaximala();
                cout << "\tExecutat cu succes!" << endl;
                break;
            }
            case 8: {
                lacuri();
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j)
                        fout << C[i][j] << " ";
                    fout << "\n";
                }
                cout << "\n\tExecutat cu succes!" << endl;
                break;
            }
            case 9: {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j)
                        cout << "\t" << A[i][j] << "  ";
                    cout << "\n\n";
                }
                break;
            }
            case 10: {
                ret = false;
                cout << "\tAi iesit cu succes din program!";
                break;
            }
            default: cout << "\tNu exista!";
        }
        cout << "\n";
    }



    fin.close();
    fout.close();
    fout2.close();

    return 0;

}
