/*
	Lucrare nr. 15
	Realizat: Bacalu Dan
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();
	
	static ArrayList<Achitari> achitari = new ArrayList();
	static ArrayList<Agent> agent = new ArrayList();
	static ArrayList<Apartment> apartment = new ArrayList();
	static ArrayList<Company> company = new ArrayList();
	static ArrayList<Service> service = new ArrayList();
	
	public static void menu() throws IOException, FileNotFoundException {
		
		int command = 0;
		while (command != 6) {
			
			System.out.print("\n");
			System.out.println("\tCrearea unei inregistrari --- 1");
			System.out.println("\tAfisarea inregistrarilor --- 2");
			System.out.println("\tSerializarea datelor --- 3");
			System.out.println("\tDeserializarea datelor --- 4");
			System.out.println("\tMetode pentru executie --- 5");
			System.out.println("\tIesirea din program --- 6");
			
			System.out.print("\n");
			System.out.print("\tCommand: ");
			command = scanner.nextInt();
			
			switch(command) {
			case 1: {
				menuInregistrari(); 
				break;
			}
			case 2: {
				menuAfisare(); 
				break;
			}
			case 3: {
				menuSerializare(); 
				break;
			}
			case 4: {
				menuDeserializare(); 
				break;
			}
			case 5: {
				menuMetode();
				break;
			}
			case 6: {
				System.out.println("\tAi iesit cu succes din program!"); 
				break;
			}
			default: System.out.println("\tNu exista aceasta optiune!"); break;
			}
			System.out.print("\n");
		}
	}
	
	public static void menuInregistrari() throws IOException {
		
		System.out.print("\n");
		int command = 0;
		while (command != 6) {
			
			System.out.println("\tCrearea unei inregistrari (Achitari) --- 1");
			System.out.println("\tCrearea unei inregistrari (Agent) --- 2");
			System.out.println("\tCrearea unei inregistrari (Apartament) --- 3");
			System.out.println("\tCrearea unei inregistrari (Company) --- 4");
			System.out.println("\tCrearea unei inregistrari (Service) --- 5");
			System.out.println("\tRevenirea la meniu --- 6");
			
			System.out.print("\n");
			System.out.print("\tCommand: ");
			command = scanner.nextInt();
			
			switch(command) {
			case 1: {
				
				int nrApartament;
				String serviciul;
				String dataAchitarii;
				
				System.out.print("\n\tNumarul apartamentului: ");
				nrApartament = scanner.nextInt();
				System.out.print("\tServiciul: ");
				serviciul = scanner.next();
				System.out.print("\tData achitarii: ");
				dataAchitarii = scanner.next();
				Achitari a = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(a);
				break;
			}
			case 2: {
				
				String nume;
				String prenume;
				String cod;
				String adresa;
				String telefon;
				
				System.out.print("\n\tNume: ");
				nume = scanner.next();
				System.out.print("\tPrenume: ");
				prenume = scanner.next();
				System.out.print("\tCod personal: ");
				cod = scanner.next();
				System.out.print("\tAdresa: ");
				adresa = scanner.next();
				System.out.print("\tTelefon: ");
				telefon = scanner.next();
				
				Agent ag = new Agent(nume, prenume, cod, adresa, telefon);
				agent.add(ag);
				break;			
			}
			case 3: {
				
				int nrApartament;
				String numeProprietar;
				int nrCamere;
				int nrLocatari;
				int suprafata;
				System.out.print("\n\tNumar apartament: ");
				nrApartament = scanner.nextInt();
				System.out.print("\tNume proprietar: ");
				numeProprietar = scanner.next();
				System.out.print("\tNumar camere: ");
				nrCamere = scanner.nextInt();
				System.out.print("\tNumar locatari: ");
				nrLocatari = scanner.nextInt();
				System.out.print("\tSuprafata: ");
				suprafata = scanner.nextInt();
				
				Apartment ap = new Apartment(nrApartament, numeProprietar, nrCamere, nrLocatari, suprafata);
				apartment.add(ap);
				break;
			}
			case 4: {
				
				String denumire;
				String adresa;
				String telefon;
				System.out.print("\n\tDenumire companie: ");
				denumire = scanner.next();
				System.out.print("\tAdresa: ");
				adresa = scanner.next();
				System.out.print("\tTelefon: ");
				telefon = scanner.next();
				Company cp = new Company(denumire, adresa, telefon);
				company.add(cp);
				break;
			}
			case 5: {
				
				int nrApartament;
				String numeProprietar;
				int nrCamere;
				int nrLocatari;
				int suprafata;
				String serviciiAcordate;
				int cost;
				System.out.print("\n\tNumar apartament: ");
				nrApartament = scanner.nextInt();
				System.out.print("\tNume proprietar: ");
				numeProprietar = scanner.next();
				System.out.print("\tNumar camere: ");
				nrCamere = scanner.nextInt();
				System.out.print("\tNumar locatari: ");
				nrLocatari = scanner.nextInt();
				System.out.print("\tSuprafata: ");
				suprafata = scanner.nextInt();
				System.out.print("\tServicii acordate: ");
				serviciiAcordate = scanner.next();
				System.out.print("\tCost: ");
				cost = scanner.nextInt();
				Service sv = new Service(nrApartament, numeProprietar, nrCamere, nrLocatari, suprafata, serviciiAcordate, cost);
				service.add(sv);
				break;
			}
			case 6: {
				menu();
				break;
			}
			default: System.out.println("\tNu exista aceasta optiune."); break;
			}
			System.out.print("\n");
	}
		
	}
	
	public static void menuAfisare() throws IOException {
		int command = 0;
		System.out.print("\n");
		while (command != 6) {
			
			System.out.println("\tAfisarea inregistrarilor (Achitari) --- 1");
			System.out.println("\tAfisarea inregistrarilor (Agent) --- 2");
			System.out.println("\tAfisarea inregistrarilor (Apartament) --- 3");
			System.out.println("\tAfisarea inregistrarilor (Company) --- 4");
			System.out.println("\tAfisarea inregistrarilor (Service) --- 5");
			System.out.println("\tRevenirea la meniu --- 6");
			
			System.out.print("\n");
			System.out.print("\tCommand: ");
			command = scanner.nextInt();
			
			switch(command) {
			case 1: {
				System.out.println(achitari.toString());
				break;
			}
			case 2: {
				System.out.println(agent.toString());
				break;
			}
			case 3: {
				System.out.println(apartment.toString());
				break;
			}
			case 4: {
				System.out.println(company.toString());
				break;
			}
			case 5: {
				System.out.println(service.toString());
				break;
			}
			case 6: {
				 menu(); 
				 break;
			}
			default: System.out.println("\tNu exista aceasta optiune."); break;
			}
			System.out.print("\n");	
		}
	}
	
	public static void menuSerializare() throws IOException{
		int command = 0;
		System.out.print("\n");
		while (command != 6) {
			
			System.out.println("\tSerializare (Achitari) --- 1");
			System.out.println("\tSerializare (Agent) --- 2");
			System.out.println("\tSerializare (Apartament) --- 3");
			System.out.println("\tSerializare (Company) --- 4");
			System.out.println("\tSerializare (Service) --- 5");
			System.out.println("\tRevenirea la meniu --- 6");
			
			System.out.print("\n");
			System.out.print("\tCommand: ");
			command = scanner.nextInt();
			
			switch(command) {
			case 1: {
				try {
				FileOutputStream fos = new FileOutputStream("achitari.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(achitari);
				fos.close();
				oos.close();
				System.out.println("\tSerializat cu succes!");
				} catch(FileNotFoundException e) {
					System.out.println("\tNu exista fisierul.");
				}
				break;
			}
			case 2: {
				try {
					FileOutputStream fos = new FileOutputStream("agent.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(agent);
					fos.close();
					oos.close();
					System.out.println("\tSerializat cu succes!");
					} catch(FileNotFoundException e) {
						System.out.println("\tNu exista fisierul.");
					}
				break;
			}
			case 3: {
				try {
					FileOutputStream fos = new FileOutputStream("apartment.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(apartment);
					fos.close();
					oos.close();
					System.out.println("\tSerializat cu succes!");
					} catch(FileNotFoundException e) {
						System.out.println("\tNu exista fisierul.");
					}
				break;
			}
			case 4: {
				try {
					FileOutputStream fos = new FileOutputStream("company.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(company);
					fos.close();
					oos.close();
					System.out.println("\tSerializat cu succes!");
					} catch(FileNotFoundException e) {
						System.out.println("\tNu exista fisierul.");
					}
				break;
			}
			case 5: {
				try {
					FileOutputStream fos = new FileOutputStream("service.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(service);
					fos.close();
					oos.close();
					System.out.println("\tSerializat cu succes!");
					} catch(FileNotFoundException e) {
						System.out.println("\tNu exista fisierul.");
					}
				break;
			}
			case 6: {
				menu();
				break;
			}
			default: System.out.println("\tNu exista aceasta optiune. "); break;
			}
			System.out.print("\n");
		}
	}
	
	public static void menuDeserializare() throws IOException {
		int command = 0;
		System.out.print("\n");
		while (command != 6) {
			
			System.out.println("\tDeserializare (Achitari) --- 1");
			System.out.println("\tDeserializare (Agent) --- 2");
			System.out.println("\tDeserializare (Apartament) --- 3");
			System.out.println("\tDeserializare (Company) --- 4");
			System.out.println("\tDeserializare (Service) --- 5");
			System.out.println("\tRevenirea la meniu --- 6");
			
			System.out.print("\n");
			System.out.print("\tCommand: ");
			command = scanner.nextInt();
			
			switch(command) {
			case 1: {
				try {
					FileInputStream fis = new FileInputStream("achitari.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					achitari = (ArrayList) ois.readObject();
					ois.close();
					fis.close();
					System.out.println("\tDeserializat cu succes!");
					} catch (IOException e) {
						e.printStackTrace();
						return;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						return;
					}
				break;
			}
			case 2: {
				try {
					FileInputStream fis = new FileInputStream("agent.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					agent = (ArrayList) ois.readObject();
					ois.close();
					fis.close();
					System.out.println("\tDeserializat cu succes!");
					} catch (IOException e) {
						e.printStackTrace();
						return;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						return;
					}
				break;
			}
			case 3: {
				try {
					FileInputStream fis = new FileInputStream("apartment.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					apartment = (ArrayList) ois.readObject();
					ois.close();
					fis.close();
					System.out.println("\tDeserializat cu succes!");
					} catch (IOException e) {
						e.printStackTrace();
						return;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						return;
					}
				break;
			}
			case 4: {
				try {
					FileInputStream fis = new FileInputStream("company.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					company = (ArrayList) ois.readObject();
					ois.close();
					fis.close();
					System.out.println("\tDeserializat cu succes!");
					} catch (IOException e) {
						e.printStackTrace();
						return;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						return;
					}
				break;
			}
			case 5: {
				try {
					FileInputStream fis = new FileInputStream("service.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					service = (ArrayList) ois.readObject();
					ois.close();
					fis.close();
					System.out.println("\tDeserializat cu succes!");
					} catch (IOException e) {
						e.printStackTrace();
						return;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						return;
					}
				break;
			}
			case 6: {
				menu();
				break;
			}
			default: System.out.println("\tNu exista aceasta optiune. "); break;
			}
			System.out.print("\n");
			
		}
	}
	
	public static void menuMetode() throws FileNotFoundException, IOException {
		int command = 0;
		System.out.print("\n");
		while (command != 10) {
			
			System.out.println("\tConvertirea pretului in alta valuta --- 1");
			System.out.println("\tApelarea metodei din clasa abstracta --- 2");
			System.out.println("\tTratarea exceptiilor aritmetice --- 3");
			System.out.println("\tTratarea exceptiilor cu tablouri --- 4");
			System.out.println("\tInserati automat 20 de inregistrari --- 5");
			System.out.println("\tCalculul sumelor lunare pentru intretinere --- 6");
			System.out.println("\tCalculul sumelor lunare pentru agentie --- 7");
			System.out.println("\tCalculul sumelor lunare pentru un agent --- 8");
			System.out.println("\tCalculul neachitarii la timp (0.1% pe zi) --- 9");
			System.out.println("\tRevenirea la meniu --- 10");
			
			System.out.print("\n");
			System.out.print("\tCommand: ");
			command = scanner.nextInt();
			
			switch (command) {
			case 1: {
				double val, unitate;
				System.out.println("\tValuta curenta (valoare): ");
				val = scanner.nextDouble();
				System.out.println("\tValoarea unei unitati din cealalta valuta: ");
				unitate = scanner.nextDouble();
				Service sv = new Service();
				System.out.println("\tConvertirea: " + sv.convertMoney(val, unitate));
				break;
			}
			case 2: {
				useAbstractClass uas = new useAbstractClass();
				uas.show();
				break;
			}
			case 3: {
				try {
					int a, b;
					System.out.print("\tIntroduceti primul numar: ");
					a = scanner.nextInt();
					System.out.print("\tIntroduceti al doilea numar: ");
					b = scanner.nextInt();
					int divide;
					if (a >= b)
						divide = a / b;
					else
						divide = b / a;
					System.out.println("\n\tImpartirea numerelor: " + divide);
					System.out.println("\n\tRadical din " + a + ": " + Math.sqrt(a));
					System.out.println("\n\tRadical din " + b + ": " + Math.sqrt(b));
				} catch (ArithmeticException e) {
					System.out.println("\n\tTratarea exceptiei. Nu este permisa impartirea la 0. ");
				} finally {
					System.out.println("\n\tExecutat cu succes!");
				}
				break;
			}
			case 4: {
				int n;
				int A[] = new int[100];
				System.out.print("\tIntroduceti numarul de elemente (maxim 100): ");
				n = scanner.nextInt();
				for (int i = 0; i < n; ++i) {
					System.out.print("\tElementul de pe pozitia " + i + ": ");
					A[i] = scanner.nextInt();
				}
				try {
					int numar;
					System.out.println("\tIntroduceti pozitia din tabloul unidimensional: ");
					numar = scanner.nextInt();
					System.out.println(A[numar]);
				} catch (IndexOutOfBoundsException e){
					System.out.println("\tA fost accesata o pozitie inexistenta.");
				}
				break;
			}
			case 5: {
				int nrApartament;
				String serviciul;
				String dataAchitarii;
				
				// inregistrare nr. 1
				nrApartament = 1;
				serviciul = "Service 1";
				dataAchitarii = "13.09.2017";
				
				Achitari a = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(a);
				
				// inregistrare nr. 2
				nrApartament = 2;
				serviciul = "Service 2";
				dataAchitarii = "01.09.2018";
				
				Achitari b = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(b);
				
				// inregistrare nr. 3
				nrApartament = 3;
				serviciul = "Service 3";
				dataAchitarii = "07.12.2019";
				
				Achitari c = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(c);
				
				// inregistrare nr. 4
				nrApartament = 4;
				serviciul = "Service 4";
				dataAchitarii = "10.10.2020";
				
				Achitari d = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(d);
				
				// inregistrare nr. 5
				nrApartament = 5;
				serviciul = "Service 5";
				dataAchitarii = "10.09.2021";
				
				Achitari e = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(e);
				
				// inregistrare nr. 6
				nrApartament = 6;
				serviciul = "Service 6";
				dataAchitarii = "08.09.2011";
				
				Achitari f = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(f);
				
				// inregistrare nr. 7
				nrApartament = 7;
				serviciul = "Service 7";
				dataAchitarii = "01.01.2021";
				
				Achitari g = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(g);
				
				// inregistrare nr. 8
				nrApartament = 8;
				serviciul = "Service 8";
				dataAchitarii = "13.02.2017";
				
				Achitari h = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(h);
				
				// inregistrare nr. 9
				nrApartament = 9;
				serviciul = "Service 9";
				dataAchitarii = "04.02.2018";
				
				Achitari i = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(i);
				
				// inregistrare nr. 10
				nrApartament = 10;
				serviciul = "Service 10";
				dataAchitarii = "23.05.2022";
				
				Achitari j = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(j);
				
				// inregistrare nr. 11
				nrApartament = 11;
				serviciul = "Service 11";
				dataAchitarii = "08.09.2021";
				
				Achitari k = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(k);
				
				// inregistrare nr. 12
				nrApartament = 12;
				serviciul = "Service 12";
				dataAchitarii = "10.10.2021";
				
				Achitari l = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(l);
				
				// inregistrare nr. 13
				nrApartament = 13;
				serviciul = "Service 13";
				dataAchitarii = "03.03.2022";
				
				Achitari m = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(m);
				
				// inregistrare nr. 14
				nrApartament = 14;
				serviciul = "Service 14";
				dataAchitarii = "07.08.2019";
				
				Achitari n = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(n);
				
				// inregistrare nr. 15
				nrApartament = 15;
				serviciul = "Service 15";
				dataAchitarii = "17.05.2020";
				
				Achitari o = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(o);
				
				// inregistrare nr. 16
				nrApartament = 16;
				serviciul = "Service 16";
				dataAchitarii = "23.04.2022";
				
				Achitari p = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(p);
				
				// inregistrare nr. 17
				nrApartament = 17;
				serviciul = "Service 17";
				dataAchitarii = "13.09.2016";
				
				Achitari q = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(q);
				
				// inregistrare nr. 18
				nrApartament = 18;
				serviciul = "Service 18";
				dataAchitarii = "05.04.2021";
				
				Achitari r = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(r);
				
				// inregistrare nr. 19
				nrApartament = 19;
				serviciul = "Service 19";
				dataAchitarii = "01.02.2022";
				
				Achitari s = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(s);
				
				// inregistrare nr. 20
				nrApartament = 20;
				serviciul = "Service 20";
				dataAchitarii = "01.01.2010";
				
				Achitari w = new Achitari(nrApartament, serviciul, dataAchitarii);
				achitari.add(w);
				
				int ch;
				System.out.println("\tDatele au fost introduse cu succes in lista Achitari!");
				System.out.print("\tDoriti sa afisati la consola datele introduse? (1 - DA / 0 - NU): ");
				ch = scanner.nextInt();
				System.out.print("\n");
				if (ch == 1) {
					System.out.println(achitari.toString());
				} else 
					if (ch == 0) {
						System.out.println("\tDatele nu vor fi afisate.");
					}
		
				break;
			}
			case 6: {
				
				String serviciiAcordate;
				int cost;
				
				System.out.print("\n");
				System.out.print("\tServicii acordate: ");
				serviciiAcordate = scanner.next();
				System.out.print("\tCost pentru o zi: ");
				cost = scanner.nextInt();
				System.out.print("\n");
				
				Service sv = new Service(serviciiAcordate, cost);
				System.out.println("\tCalculul sumelor lunare pentru intretinere: " + sv.sumeLunare(cost));
				System.out.print("\n");
				break;
			}
			case 7: {
				
				String denumire;
				String adresa;
				String telefon;
				double cost;
				System.out.print("\tDenumire companie: ");
				denumire = scanner.next();
				System.out.print("\tAdresa: ");
				adresa = scanner.next();
				System.out.print("\tTelefon: ");
				telefon = scanner.next();
				System.out.println("\tCost pentru o zi: ");
				cost = scanner.nextDouble();
				System.out.print("\n");
				
				Company com = new Company(denumire, adresa, telefon, cost);
				System.out.println("\tCalculul sumelor lunare pentru intretinere: " + com.costLunar(cost));
				System.out.print("\n");
				break;
			}
			case 8: {
				
				String nume;
				String prenume; 
				double salariu;
				System.out.print("\tNume: ");
				nume = scanner.next();
				System.out.print("\tPrenume: ");
				prenume = scanner.next();
				System.out.print("\tSalariu pentru o zi: ");
				salariu = scanner.nextDouble();
				System.out.print("\n");
				
				Agent ag = new Agent(nume, prenume, salariu);
				System.out.println("\tCalculul sumelor lunare pentru un agent: " + ag.salariuLunar(salariu));
				System.out.print("\n");
				break;
			}
			case 9: {
				
				String serviciiAcordate;
				int cost;
				int zileIntarziate;
				System.out.print("\tServicii acordate: ");
				serviciiAcordate = scanner.next();
				System.out.print("\tCost pentru o zi: ");
				cost = scanner.nextInt();
				System.out.print("\tZile intarziate: ");
				zileIntarziate = scanner.nextInt();
				System.out.print("\n");
				
				Service s = new Service(serviciiAcordate, cost, zileIntarziate);
				System.out.println("\tPenalizarea constituie: " + s.penalizare(cost, zileIntarziate));
				System.out.print("\n");
				break;
			}
			case 10: {
				menu();
				break;
			}
			default: {
				System.out.println("\tNu exista aceasta optiune. "); break;
			}
			}
			System.out.print("\n");
			
		}
	}
	
	public static void main(String[] args) throws IOException {

		menu();
		
	}

}
