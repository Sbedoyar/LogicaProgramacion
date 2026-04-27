package com.packages.game;

public class TriquiTaller {

    public Triqui triqui;

    public TriquiTaller() {
        triqui = new Triqui();
        triqui.tablero = new char[3][3];
        inicializarTablero();
    }

    // Método para inicializar el tablero con espacios vacíos
    public void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                triqui.tablero[i][j] = ' ';
            }
        }
    }

    //Punto a.
    public void ingresarUsuarios(String jugador1, char simbolo1, String jugador2, char simbolo2) {

        if (simbolo1 == simbolo2) {
            System.out.println("Los símbolos no pueden ser iguales.");
            return;
        }

        triqui.jugador1 = jugador1;
        triqui.jugador2 = jugador2;

        triqui.simbolo1 = simbolo1;
        triqui.simbolo2 = simbolo2;

        triqui.usuariosIngresados = true; //Se marcan los usuarios como ingresados
        triqui.juegoIniciado = false; // Se inicia el juego después de ingresar los usuarios
        triqui.juegoPausado = false; // Se asegura de que el juego no esté pausado al ingresar los usuarios
        triqui.turnoActual = 0; // Se establece el turno actual en 0 (jugador 1)

        inicializarTablero();

        System.out.println("Usuarios ingresados correctamente. La partida anterior fue anulada.");
    }

    //Punto b.

    public void mostrarTablero() {
        System.out.println("\nTablero actual:");
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");

            for (int j = 0; j < 3; j++) {
                System.out.print(triqui.tablero[i][j] + " | ");
            }

            System.out.println();
            System.out.println("-------------");
        }
    }
    
    public void sortearInicio() {

        if (!triqui.usuariosIngresados) {
            System.out.println("Primero debe ingresar los usuarios.");
            return;
        }

        int sorteo = (int)(Math.random() * 2) + 1;

        inicializarTablero();

        triqui.juegoIniciado = true;
        triqui.juegoPausado = false;
        triqui.turnoActual = sorteo;

        if (triqui.turnoActual == 1) {
            System.out.println("Inicia " + triqui.jugador1 + " con el símbolo " + triqui.simbolo1);
        } else {
            System.out.println("Inicia " + triqui.jugador2 + " con el símbolo " + triqui.simbolo2);
        }

        mostrarTablero();
    }

    //Punto c.
    public void mostrarEstadoJuego() {
        if (!triqui.usuariosIngresados) {
            System.out.println("Primero debe ingresar los usuarios.");
            return;
        }

        System.out.println("\n--- Estado del juego ---");
        System.out.println("Jugador 1: " + triqui.jugador1 + " | Símbolo: " + triqui.simbolo1);
        System.out.println("Jugador 2: " + triqui.jugador2 + " | Símbolo: " + triqui.simbolo2);

        if (!triqui.juegoIniciado) {
            System.out.println("El juego aún no ha iniciado. Debe realizar el sorteo.");
        } else if (triqui.turnoActual == 1) {
            System.out.println("Turno actual: " + triqui.jugador1 + " | Símbolo: " + triqui.simbolo1);
        } else {
            System.out.println("Turno actual: " + triqui.jugador2 + " | Símbolo: " + triqui.simbolo2);
        }
    }

    //Punto d.
    public void modificarNombres(int numeroJugador, String nuevoNombre, char nuevoSimbolo) {
        if (!triqui.usuariosIngresados) {
            System.out.println("Primero debe ingresar los usuarios.");
            return;
        }

        if (numeroJugador == 1) {
            if (nuevoSimbolo == triqui.simbolo2) {
                System.out.println("El símbolo no puede ser igual al del jugador 2. Por favor, elija un símbolo diferente.");
                return;
            }
            triqui.jugador1 = nuevoNombre;
            triqui.simbolo1 = nuevoSimbolo;

            System.out.println("Nombre y símbolo del jugador 1 actualizados correctamente.");

        } else if (numeroJugador == 2) {
            if (nuevoSimbolo == triqui.simbolo1) {
                System.out.println("El símbolo no puede ser igual al del jugador 1. Por favor, elija un símbolo diferente.");
                return;
            }
            
            triqui.jugador2 = nuevoNombre;
            triqui.simbolo2 = nuevoSimbolo;

            System.out.println("Nombre y símbolo del jugador 2 actualizados correctamente.");

        } else {
            System.out.println("Número de jugador inválido. Debe ser 1 o 2.");
        }
        System.out.println("Nombres de jugadores actualizados correctamente.");
    }

    //punto e.
    public void jugarTurno(int fila, int columna) {

        if (triqui.turnoActual == 1) {
            triqui.tablero[fila][columna] = triqui.simbolo1;
            System.out.println("Jugada realizada por " + triqui.jugador1);
            mostrarTablero();

            if (verificarGanador(triqui.simbolo1)) {
                mostrarLetreroGanador(triqui.simbolo1, triqui.jugador1);
                triqui.juegoIniciado = false;
                return; 
            }
            
            triqui.turnoActual = 2;

        } else {
            triqui.tablero[fila][columna] = triqui.simbolo2;
            System.out.println("Jugada realizada por " + triqui.jugador2);
            mostrarTablero();

            if (verificarGanador(triqui.simbolo2)) {
                mostrarLetreroGanador(triqui.simbolo2, triqui.jugador2);
                triqui.juegoIniciado = false;
                return; 
            }
            triqui.turnoActual = 1;
        }
        mostrarEstadoJuego();
    }

    //punto f.
    public void cancelarJuego() {
        if (!triqui.juegoIniciado) {
            System.out.println("No hay una partida en curso para cancelar.");
            return;
        }

        inicializarTablero();

        triqui.juegoIniciado = false;
        triqui.juegoPausado = false;
        triqui.turnoActual = 0;

        System.out.println("La partida fue cancelada correctamente.");
    }

    //punto g.
    public void pausarJuego() {
        if(!triqui.juegoIniciado) {
            System.out.println("No hay una partida en curso para pausar.");
        }else if(triqui.juegoPausado){
            System.out.println("El juego ya está pausado.");
        } else {
            triqui.juegoPausado = true;
            System.out.println("La partida fue pausada correctamente.");
        }
    }

    public void reanudarJuego() {
        if(!triqui.juegoIniciado){
            System.out.println("No hay un juego iniciado para reanudar.");
        } else if (!triqui.juegoPausado) {
            System.out.println("El juego no está pausado. No es necesario reanudar.");
        } else {
            triqui.juegoPausado = false;
            System.out.println("La partida fue reanudada correctamente.");
            mostrarTablero();
            mostrarEstadoJuego();
        }
    }

    //punto h. (opcional)
    public boolean verificarGanador(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (triqui.tablero[i][0] == simbolo &&
                triqui.tablero[i][1] == simbolo &&
                triqui.tablero[i][2] == simbolo) {
                return true;
            }

            if (triqui.tablero[0][i] == simbolo &&
                triqui.tablero[1][i] == simbolo &&
                triqui.tablero[2][i] == simbolo) {
                return true;
            }
        }

        if (triqui.tablero[0][0] == simbolo &&
            triqui.tablero[1][1] == simbolo &&
            triqui.tablero[2][2] == simbolo) {
            return true;
        }

        if (triqui.tablero[0][2] == simbolo &&
            triqui.tablero[1][1] == simbolo &&
            triqui.tablero[2][0] == simbolo) {
            return true;
        }

        return false;
    }

    public void mostrarLetreroGanador(char simbolo, String nombre) {
        String s = String.valueOf(simbolo);

        System.out.println();
        System.out.println(s+s+s+s+s+s+s+"   "+s+s+s+s+s+"   "+s+s+s+s+s+"   "+s+s+s+s+s+"   "+s+"   "+s+"   "+s+s+s+s+s);
        System.out.println("   "+s+"      "+s+"   "+s+"   "+s+"       "+s+"   "+s+"   "+s+"   "+s+"   "+s);
        System.out.println("   "+s+"      "+s+s+s+s+s+"   "+s+"       "+s+"   "+s+"   "+s+"   "+s+"   "+s);
        System.out.println("   "+s+"      "+s+" "+s+"     "+s+"       "+s+"   "+s+"   "+s+"   "+s+"   "+s);
        System.out.println("   "+s+"      "+s+"  "+s+"    "+s+s+s+s+s+"   "+s+s+s+s+s+"   "+s+s+s+s+s+"   "+s+s+s+s+s);

        System.out.println("\n¡Felicitaciones " + nombre + ", ganaste la partida!");
    }
}