package org.example;

import java.util.Objects;
import java.util.Scanner;

//Prueba 6
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int dia=entrada.nextInt();
         int numH=entrada.nextInt();
         int numM=entrada.nextInt();
         entrada.nextLine();
         boolean activa=true;
        String mensaje=entrada.nextLine();
        Alarma alarma =new Alarma(dia,numH, numM, activa,mensaje);


        String eleccion=entrada.nextLine();
        switch (eleccion){
            case "S": ;
            break;
            case "M": ;
            break;
            case"V":
                break;
        }


AlarmaSonora alarma1 = new AlarmaSonora(dia,numH, numM, activa,mensaje);
        AlarmaVibracion alarma2 = new AlarmaVibracion(dia,numH, numM, activa,mensaje);
AlarmaMusical alarma3=new AlarmaMusical(dia,numH, numM, activa,mensaje);
alarma3.setCancion("Himno de la alegría");

    }
}

class AlarmaSonora extends Alarma {


    @Override
    void sonar() {
        System.out.println("BEEP BEEP");
    }

    public AlarmaSonora(int dia, int numH, int numM, boolean activa, String mensaje) {
        super(dia, numH, numM, activa, mensaje);
    }
}


class AlarmaVibracion extends Alarma{

    @Override
    void sonar() {
        System.out.println("La alarma vibra");
    }

    public AlarmaVibracion(int dia, int numH, int numM, boolean activa, String mensaje) {
        super(dia, numH, numM, activa, mensaje);
    }

    }


    class AlarmaMusical extends Alarma{
       private String cancion;

        @Override
        void sonar() {
            System.out.println("Reproduciendo "+cancion);
        }

        public AlarmaMusical(int dia, int numH, int numM, boolean activa, String mensaje) {
            super(dia, numH, numM, activa, mensaje);
            this.cancion = " ";
        }

        public String getCancion() {
            return cancion;
        }

        public void setCancion(String cancion) {
            this.cancion = cancion;
        }

        @Override
        public String toString() {
            return "AlarmaMusical{" +
                    "cancion='" + cancion + '\'' +
                    '}';
        }
    }

class Alarma {
    private int dia;
    private int numH;
    private int numM;
    private boolean activa;
    private String mensaje;

    public Alarma() {
    }

    public Alarma(int dia, int numH, int numM, boolean activa, String mensaje) {
        this.dia = dia;
        this.numH = numH;
        this.numM = numM;
        this.activa = activa;
        this.mensaje = mensaje;
    }

    public Alarma(Alarma copia) {
        this.dia = copia.dia;
        this.numH = copia.numH;
        this.numM = copia.numM;
        this.activa = copia.activa;
        this.mensaje = copia.mensaje;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getNumH() {
        return numH;
    }

    public void setNumH(int numH) {
        this.numH = numH;
    }

    public int getNumM() {
        return numM;
    }

    public void setNumM(int numM) {
        this.numM = numM;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alarma alarma = (Alarma) o;
        return dia == alarma.dia && numH == alarma.numH && numM == alarma.numM && activa == alarma.activa && Objects.equals(mensaje, alarma.mensaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, numH, numM, activa, mensaje);
    }

    @Override
    public String toString() {
        return "Alarma{" +
                "dia=" + mensajesDia() +
                ", numH=" + numH +
                ", numM=" + numM +
                ", activa=" + mensajes() +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }

     void sonar() {
        System.out.println(" ");
    }


    private String mensajes() {
        String mensaje = "";
        if (this.activa) {
            mensaje = "SI";
        } else {
            mensaje = "NO";
        }
        return mensaje;
    }

    private String mensajesDia() {
        String mensaje = " ";
        switch (this.dia) {
            case 0:
                mensaje = "L";
                break;
            case 1:
                mensaje = "M";
                break;
            case 2:
                mensaje = "X";
                break;
            case 3:
                mensaje = "J";
                break;
            case 4:
                mensaje = "V";
                break;
            case 5:
                mensaje = "S";
                break;
            case 6:
                mensaje = "D";
                break;
        }
        return mensaje;

    }
}

/*
        Se debe incluir el siguiente método en la clase descrita en el Examen presencial RA4

1. Clase Alarma: (2 puntos)

        Crea el método sonar() de manera que las clases que hereden de la clase Alarma estén obligados a sobreescribir este método.
        2. A partir de la clase Alarma, crea las clases AlarmaSonora, AlarmaVibración y Alarma Musical que tendrán los mismos atributos que Alarma (AlarmaMusical ttendrá un atributo más, descrito a continuación) y redefinen el método sonar(). Cada una sonará de la siguiente forma:(4 puntos)

        Cuando suene AlarmaSonora se mostrará el mensaje: BEEP BEEP.
        Cuando suene AlarmaVibración se mostrará el mensaje: La alarma vibra.
        Cuando suene AlarmaMusical se mostrará el mensaje: Reproduciendo Canción.
        - Atributo cancion que será de tipo String, para indicar que canción se reproduce.
        - Método setCancion (String cancion)


3. Crea una clase principal, donde declaremos un objeto Alarma y  solicites al usuario que tipo de alarma quiere crear: AlarmaSonora, AlarmaVibración, AlarmaMusical (S, V, M, respectivamente) (4 puntos)

        A continuación introducen todos los datos de entrada por teclado, excepto el valor del atributo activa, que lo ponemos por defecto a true.

        Posteriormente ejecuta el método setCancion("Himno de la alegría") en caso de crear una alarma de tipo AlarmaMusical y el método sonar()

        IMPRESCINDIBLE: Utilizar polimorfismo

        Ejemplo entrada:
        M
0
        8
        30
        Despertar
        M (Elección de AlarmaMusical - M)
0 (atributo día =  0, L, lunes)
        8 (atributo numH = 8 h)
        30 (atributo numM = 30m)
        Despertar (atributo mensaje = "Despertar"
 */