## **Esercitazione Pattern **

Si vuole creare un mini-gestionale per la segreteria di ateneo. Le entità da gestire sono "Studente" e "Corso" con i seguenti attributi: 

 - Studente: 
	 - ID (generato automaticamente)
	-  Nome
	-  Cognome
	-  Data di nascita
- Corso: 
	- ID (generato automaticamente)
	- Titolo del corso 
	- Nome docente 
	- Crediti

**Punti richiesti:** 

- Utilizzando il Pattern DAO, implementare i metodi di base per l'accesso ai dati, come inserimento, aggiornamento, eliminazione e recupero. 
- Creare un metodo per ottenere tutti i corsi di uno studente specifico (join tra Student e Corso).
- Prevedere una corretta gestione delle eccezioni

Prevedere una classe per ognuno di questi punti:
1. Utilizzare una classe dummyDatabase con una Collection interna per archiviare i dati.
2. Leggere i dati da un file di testo (estensione del file a vostro piacimento) 
3. Caricare i dati in memoria da un file senza fonte esterna.
