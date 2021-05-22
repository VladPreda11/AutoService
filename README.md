# AutoService

Se va realiza o aplicație pentru gestionarea unui atelier auto. Utilizatorul va avea la dispoziție un meniu
afișat în consolă, prin intermediul căruia se vor realiza operațiile legate de personalul atelierului și de
mașini, astfel:

I. Angajați
Există 3 tipuri de angajați: Director, Mecanic și Asistent. Toti angajații au în comun câmpurile ID, Nume,
Prenume, Data Nașterii, Data Angajării și Coeficient salariat.
Se vor implementa următoarele funcționalități: Afișare angajați, Adăugare angajat, Ștergere angajat,
editare angajat și calcularea salariului unui angajat.
Observații:
- Id-ul trebuie să se incrementeze automat pentru fiecare angajat adăugat.
- Coeficientul salarial nu se setează de la tastatura. (Directorul are coeficientul 2, angajatul 1.5 și asistentul 1).
- Numele și prenumele nu trebuie să fie nule și nu trebuie să depășească 30 de caractere fiecare.
- Angajatul trebuie să aibă peste 18 ani, împliniți inclusiv în ziua angajării.
- Data angajării nu poate fi o dată din viitor.
- Ștergerea, editarea și calcularea salariului unui angajat se fac în baza ID-ului acestuia, introdus de la
tastatura. Dacă ID-ul nu corespunde niciunui angajat, se afișează un mesaj corespunzător și se revine la
introducerea ID-ului.
- Calculul salariului se face dupa formula Ani vechime * coeficient * 1000 lei.

II. Mașini
Există 3 tipuri de mașini: Standard, Autobuz și Camion. Toate mașinile au în comun câmpurile ID,
Numărul de kilometri, Anul fabricației și un indicator dacă este motor Diesel sau nu. Fiecare tip de
mașină în parte are următoarele specificații:
1. Mașinile standard au, în plus (față de câmpurile menționate general pentru toate mașinile), un mod
de transmisie, care poate fi doar Manual sau Automat.
2. Autobuzele au, în plus (față de câmpurile menționate general pentru toate mașinile) un câmp care să
indice Numărul de locuri.
3. Camioanele au, în plus (față de câmpurile menționate general pentru toate mașinile) un câmp care să
indice tonajul.
Fiecare instanță a unei mașini trebuie să expună un mod de a calcula valoarea poliței de asigurare.
Pentru aceasta, se ține cont de următoarele informații:
1. Pentru mașinile standard, polița de asigurare se calculează astfel:
- Este vechimea (exprimată în ani) înmulțită cu 100, la care se adaugă următoarele:
- 500 dacă este motor Diesel;
- 500 dacă a depășit 200 000 de kilometri.
2. Pentru autobuze, polița de asigurare se calculează astfel:
- Este vechimea (exprimată în ani) înmulțită cu 200, la care se adaugă următoarele:
- 1000 dacă este motor Diesel;
- 1000 dacă au fost depășiți 200 000 de kilometri, 500 dacă au fost depășiți doar 100 000 de kilometri.
3. Pentru camioane, polița de asigurare se calculează astfel:
- Este vechimea (exprimată în ani) înmulțită cu 300, la care se adaugă 700 dacă au fost depășiți 800 000
de kilometri.
Formula poate fi apelată standard, sau în modul DISCOUNT, care înseamnă: o reducere de 5% pentru
mașinile standard, de 10% pentru autobuze și de 15% pentru camioane.

III. Activitatea Atelierului
Într-un atelier pot lucra mai mulți angajați, care pot repara mai multe tipuri de mașini, având
următoarele restricții:
1. Trebuie să existe cel puțin un angajat pentru ca atelierul să poată fi considerat deschis.
2. Angajații nu pot fi supraaglomerați: ei pot lua în primire, în total, cel mult 3 mașini normale și cel mult
câte o mașină dintre celelalte două tipuri menționate anterior (maxim 1 autobuz, maxim 1 camion).
3. Pentru a putea gestiona acest lucru, angajații oferă un estimat de timp pentru a repara o mașină, și se
asumă faptul că estimatul este corect.
4. Pe măsură ce un angajat finalizează repararea unei mașini, poate lua în primire și alte mașini,
respectând restricțiile de mai sus.
5. Un nou vehicul venit pentru reparație poate să fie alocat primului angajat disponibil, sau poate solicita
să aștepte strict intrarea la un anumit angajat. Dacă angajatul solicitat nu este disponibil, poate alege să
plece sau să treacă la primul angajat liber.
6. Când toți angajații sunt complet ocupați, un vehicul poate fi pus în așteptare, sau proprietarul poate
decide să plece.
Respectând acest scenariu, permiteți adăugarea de solicitări într-un meniu afișat în consolă, cât și
mesaje specifice punctul în care ați ajuns: nu mai sunt locuri libere la un anumit angajat dorit, nu mai
sunt locuri libere în atelier la niciun angajat etc. Afișați, în cadrul fiecărei operații, coada de așteptare.
