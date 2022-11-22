package tennisgame;

import java.util.Scanner;

public class TennisGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nombre del TORNEO: ");
        String torneo = sc.nextLine();

        System.out.println("Nombre Jugador1: ");
        String jugador1 = sc.nextLine();
        System.out.println("Nombre Jugador2: ");
        String jugador2 = sc.nextLine();
        // pregunto a cuantos SETS Y DEPENDIENDO nueva variable para establecer cuantos sets hay qe ganar
        System.out.println("a Cuantos Sets? (3 o 5)");
        int cuantosSets = sc.nextInt();
        
        int ganaACuantosSets=0;
        if (cuantosSets == 3) {
            ganaACuantosSets = 2;
        } else if (cuantosSets == 5) {
            ganaACuantosSets = 3;
        }
        
        
        //mejorar para que no pueda ingresar valor mayor a 100
        System.out.println("Probablidad que gane el Jugador 1: " + jugador1);
        int probabJug1 = sc.nextInt();
        String saltoDeLinea = sc.nextLine();
        
        int Jugador1Sets=0, Jugador2Sets=0;
        int set = 1;
        boolean si;
        //valores Sets
        int set1J1=0, set1J2=0, set2J1=0, set2J2=0, set3J1=0, set3J2=0, set4J1=0, set4J2=0, set5J1=0, set5J2=0;
        
        do {            
            partido (Jugador1Sets, Jugador2Sets, set, set1J1, set1J2, set2J1, set2J2, set3J1, set3J2, set4J1, set4J2, set5J1, set5J2, probabJug1, jugador1, jugador2, ganaACuantosSets, cuantosSets, torneo);
            System.out.println("juga revancha?");    
            String revancha = sc.nextLine();
            si = revancha.equalsIgnoreCase("si");
            
        } while (si);
        
        

        
        
        

            
        

    }
    
    public static int puntosGame(int probabjug1){
        
        int punto = (int)(Math.random()*100+1);
        
        if(punto < probabjug1){
            return 1;
        }
        else {
            return 2;       
        }
    }
    
    public static int sumarPuntosGame(int probabJug1, String jugador1, String jugador2){
        
        int ptosJ1=0, ptosJ2=0, ventajaJ1=0, ventajaJ2=0;
        
        do {
            int quienGano = puntosGame(probabJug1);
            // gana punto j1 con ventaja
            if (quienGano == 1 && ptosJ1 == 4 && ptosJ2 == 3) {
                System.out.println("**************************");
                System.out.println(jugador1 + " GANO EL PUNTO");
                ventajaJ1 = 1;
                
            // gana putno j2 con ventaja    
            } else if (quienGano == 2 && ptosJ2 == 4 && ptosJ1 == 3) {
                System.out.println("**************************");
                System.out.println(jugador2 + " GANO EL PUNTO");
                ventajaJ2 = 1;
            // empates     
            } else if (quienGano == 2 && ptosJ1 == 4 && ptosJ2 == 3) {
                System.out.println("**************************");
                System.out.println(jugador2 + " GANO EL PUNTO"); 
                ptosJ1 = 3;
            // empates    
            } else if (quienGano == 1 && ptosJ2 == 4 && ptosJ1 == 3) {
                System.out.println("**************************");
                System.out.println(jugador1 + " GANO EL PUNTO"); 
                ptosJ2 = 3;
            

            } else if (!(ptosJ1 == 4 && ptosJ2 <=2) || !(ptosJ2 == 4 && ptosJ1 <=2) ) {
                if (quienGano == 1) {
                    ptosJ1 = ptosJ1+1;
                    System.out.println("**************************");
                    System.out.println(jugador1 + " GANO EL PUNTO");
                } else {
                    ptosJ2 = ptosJ2+1;
                    System.out.println("**************************");
                    System.out.println(jugador2 + " GANO EL PUNTO");
                } 
            }

            if (ptosJ1 == 4 && ptosJ2 <= 2 ) {
                System.out.println("EL GAME TERMINO ASI");
                System.out.println(puntosEnLetras(ptosJ1-1));    
                System.out.println(puntosEnLetras(ptosJ2));
            } else if (ptosJ2 == 4 && ptosJ1 <= 2 ){
                System.out.println("EL GAME TERMINO ASI");
                System.out.println(puntosEnLetras(ptosJ1));    
                System.out.println(puntosEnLetras(ptosJ2-1));
            } else if(ventajaJ1 == 1){
                System.out.println("EL GAME TERMINO ASI");
                System.out.println(puntosEnLetras(ptosJ1));    
                System.out.println(puntosEnLetras(ptosJ2));
            } else if(ventajaJ2 == 1){
                System.out.println("EL GAME TERMINO ASI");
                System.out.println(puntosEnLetras(ptosJ1));    
                System.out.println(puntosEnLetras(ptosJ2));
            
            } else {
                System.out.println("PARCIAL GAME");
                System.out.println(puntosEnLetras(ptosJ1));    
                System.out.println(puntosEnLetras(ptosJ2));
            }
                 
        } while (  !(   (ptosJ1 == 4 && ptosJ2 <=2) || (ptosJ2 == 4 && ptosJ1 <=2) || (ventajaJ1 == 1) || (ventajaJ2 == 1)        ));
        
        if (ptosJ1 == 4) {
            
            System.out.println(jugador1 + " GANO el game");
        } else {
            System.out.println(jugador2 + " GANO el game");    
        }
        
        
        if ((ptosJ1 == 4 && ptosJ2 <=2) || (ventajaJ1 == 1)) {
            
            return 1;
        }
            
        if ((ptosJ2 == 4 && ptosJ1 <=2) || (ventajaJ2 == 1)) {
            return 2;   
        }
        return 0;
        
    }
    
    public static String puntosEnLetras(int a){
        String puntoEnLetras = "";
        switch(a){
            case 0:
                puntoEnLetras= "00";
                break;
            case 1:
                puntoEnLetras = "15";
                break;
            case 2:
                puntoEnLetras = "30";
                break;
            case 3:
                puntoEnLetras = "40";
                break;
            case 4:
                puntoEnLetras = "Ventaja";
                break;
            
        }
        return puntoEnLetras;
    }
    
    public static int sumarSets(int probabJug1, String jugador1, String jugador2, int ganaACuantosSets, int set, int Jugador1Sets, int Jugador2Sets ){
        
        int gamesJ1=0, gamesJ2=0;
        
        
        do {
            int quienGano= sumarPuntosGame(probabJug1, jugador1, jugador2);
            if (quienGano == 1) {
                gamesJ1++;
            } else {
                gamesJ2++;
            }
            
            if ((gamesJ1 >= 5 && gamesJ2 >= 5) && (Math.abs((gamesJ1 - gamesJ2)) == 2))  {
               
                
            }
            

        } while (!((gamesJ1 == 6 && gamesJ2 <=4) || (gamesJ2 == 6 && gamesJ1 <=4) || ((gamesJ1 >= 5 && gamesJ2 >= 5) && (Math.abs((gamesJ1 - gamesJ2)) == 2)))                 );
        
        System.out.println("****************************");
        System.out.println("SET N°: " + set);
        
        if (gamesJ1 > gamesJ2) {
            System.out.println("GANO EL SET " + jugador1);
            System.out.println(gamesJ1 +" Games " + jugador1);
            System.out.println(gamesJ2 +" Games " + jugador2);
            System.out.println("**************************");
            String stringGamesj1 = String.valueOf(gamesJ1);
            String stringGamesj2 = String.valueOf(gamesJ2);
            String total = stringGamesj1+stringGamesj2;
            int resultado = Integer.parseInt(total);
            int ganoSet = 1;
            System.out.println("PARCIAL SETS: ");
            System.out.println((ganoSet + Jugador1Sets) + jugador1 );
            System.out.println((Jugador2Sets) + jugador1 );
            
            
            return resultado;
            
        } else {
            System.out.println("GANO EL SET " + jugador2);
            System.out.println(gamesJ1 +" Games " + jugador1);
            System.out.println(gamesJ2 +" Games " + jugador2);
            System.out.println("**************************");
            String stringGamesj1 = String.valueOf(gamesJ1);
            String stringGamesj2 = String.valueOf(gamesJ2);
            String total = stringGamesj1+stringGamesj2;
            int resultado = Integer.parseInt(total);
            int ganoSet = 1;
            System.out.println("PARCIAL SETS: ");
            System.out.println((Jugador1Sets) + jugador1 );
            System.out.println((ganoSet + Jugador2Sets) + jugador2 );
            
            return resultado;
        }
        
    } 
    
    public static void partido (int Jugador1Sets, int Jugador2Sets, int set, int set1J1, int set1J2, int set2J1, int set2J2, int set3J1, int set3J2, int set4J1, int set4J2, int set5J1, int set5J2, int probabJug1, String jugador1, String jugador2, int ganaACuantosSets, int cuantosSets, String torneo  ) {
        
        
        do {
            
            
            int quienGanoSet = sumarSets(probabJug1, jugador1, jugador2, ganaACuantosSets, set, Jugador1Sets, Jugador2Sets);
            
            String quienGanoSetArray = String.valueOf(quienGanoSet);
            char[] digits1 = quienGanoSetArray.toCharArray();
            int valor1 = Character.getNumericValue(digits1[0]);
            int valor2 = Character.getNumericValue(digits1[1]);
            
            if (valor1 > valor2) {
                Jugador1Sets++;
            } else if(valor2 > valor1) {
                Jugador2Sets++;
            }
           
            switch (set) {
                case 1:
                    set1J1 = valor1;
                    set1J2 = valor2;
                    break;
                case 2:
                    set2J1 = valor1;
                    set2J2 = valor2;
                    break;
                case 3:
                    set3J1 = valor1;
                    set3J2 = valor2;
                    break;
                case 4:
                    set4J1 = valor1;
                    set4J2 = valor2;
                    break;
                case 5:
                    set5J1 = valor1;  
                    set5J2 = valor2;  
                    break;
            }
           
            set++;
            
            
            
                        
            
            
        } while (!((Jugador1Sets == ganaACuantosSets) || (Jugador2Sets == ganaACuantosSets))   );
        
        if (Jugador1Sets == ganaACuantosSets) {
            System.out.println("");
            System.out.println("---  GANO *** "+ jugador1 + " *** EL PARTIDO ---");
            System.out.println("");
            
        } else {
            System.out.println("");
            System.out.println("---  GANO *** "+ jugador2 + " *** EL PARTIDO ---");
            System.out.println("");
            
            
        }
        System.out.println("RESULTADO PARTIDO");
        System.out.println("TORNEO: " + torneo);
        if (cuantosSets == 5 ) {
            System.out.println("SETS | GAMES");
            System.out.println(Jugador1Sets+"   ||  |"+set1J1+ "|"+"|"+set2J1+ "|"+"|"+set3J1+ "|"+"|"+set4J1+ "|"+"|"+set5J1+ "|"+jugador1);
            System.out.println(Jugador2Sets+"   ||  |"+set1J2+ "|"+"|"+set2J2+ "|"+"|"+set3J2+ "|"+"|"+set4J2+ "|"+"|"+set5J2+ "|"+jugador2);
        } else if (cuantosSets == 3){
            System.out.println("SETS | GAMES");
            System.out.println(Jugador1Sets+"   ||  |"+set1J1+ "|"+"|"+set2J1+ "|"+"|"+set3J1+ "|"+jugador1);
            System.out.println(Jugador2Sets+"   ||  |"+set1J2+"|"+"|"+set2J2+ "|"+"|"+set3J2+ "|"+jugador2);
        }
        
          
        

        
}
           
}





