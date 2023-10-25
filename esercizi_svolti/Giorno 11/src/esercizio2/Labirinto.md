## Labirinto 2.0 🏍

Implementare l'[esercizio labirinto del modulo 2](../../../../module_02/src/esercizi/labirinto/) utilizzando la OOP per
rappresentare le entità del gioco.

Progettare una classe astratta `Entity` che deve essere estesa da tutte le altre classi del gioco
* `Giocatore`
* `Muro`
* `SpazioVuoto`
* `Uscita`

Aggiungere la classe `Vortice`
* Una casella vortice teletrasporta il giocatore in un'altra casella vortice a caso (ci devono essere almeno 2 caselle vortice nella mappa)


Aggiungere la classe `Mostro`, che insegue il giocatore, e ad ogni turno fa un passo in una direzione casuale


# :skull_and_crossbones: Bonus stage
Il mostro deve muoversi nella miglior direzione per poter raggiungere il giocatore


## Bonus 2
Ideare ed implementare altri tipi di entità del labirinto

## Testo vecchio esercizio 

# Labyrinth

Negli anni 80 molti videogiochi :video_game: avevano una grafica "testuale" e cioè usavano i caratteri base del computer per disegnare a schermo.

![Rogue](Immagini/rogue.png)

Possiamo rappresentare un labirinto come una matrice di caratteri, in cui il carattere "-" rappresenta uno spazio vuoto, la "P" la posizione del giocatore e la "E" l’uscita.


![Possibile labirinto](Immagini/preview.png)



Scrivete un programma che permette ad un utente di giocare al vostro labirinto. Per farlo potrà scrivere sulla console di java le lettere «WASD» per muoversi (come in molti videogiochi per PC). Quando il giocatore raggiunge il traguardo, verrà avvisato di aver vinto e il programma termina.


## Esempio di come funziona

![test](Immagini/laby.gif)


## :smiling_face_with_three_hearts: Bonus stage:

Generate il labirinto randomicamente

# :skull_and_crossbones: Ultra mega bonus stage:
## Io ve lo dico, è difficile...
Fate in modo che il computer sia in grado di risolvere da solo il labirinto.