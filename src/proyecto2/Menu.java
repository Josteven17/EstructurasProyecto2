/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author josep
 */
import javax.swing.JOptionPane;

public class Menu {

    byte contador;
    Cola cajero1 = new Cola();
    Cola cajero2 = new Cola();
    Cola cajero3 = new Cola();
    Cola cajero4 = new Cola();

    public void Menu() {
        int opcion = 0;
        String dato = "***Opciones Banco***\n";
        dato += "1. Estado de cajeros\n";
        dato += "2. Ingresar Cliente\n";
        dato += "3. Despachar Cliente\n";
        dato += "4. Salir";

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, InformacionCajeros());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, InformacionCajeros());
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
                        if (VerificarDiferentes()) {
                            int CajeroMenor = CajeroMenosPersonas();
                            IngresarCliente(CajeroMenor, nombre);
                            JOptionPane.showMessageDialog(null, "Se ingreo a " + nombre + " en el cajero numero" + CajeroMenor);
                        } else {
                            int CajeroMenosPersonas = CajeroMenorRepetidos();
                            String informacionCajeros = CajerosIguales(CajeroMenosPersonas);
                            if (contador > 1) {

                                int Numerocajero = Integer.parseInt(JOptionPane.showInputDialog(null, informacionCajeros + "\nEscoja el numero de cajero que desee"));
                                IngresarCliente(Numerocajero, nombre);
                                JOptionPane.showMessageDialog(null, "Se ingreo a " + nombre + " en el cajero numero" + Numerocajero);
                            } else {
                                int CajeroMenor = CajeroMenosPersonas();
                                IngresarCliente(CajeroMenor, nombre);
                                JOptionPane.showMessageDialog(null, "Se ingreo a " + nombre + " en el cajero numero" + CajeroMenor);
                            }

                        }
                        break;
                    case 3:
                        if (VerificarClientes()) {
                            Despachar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Los cajeros estan vacios");
                        }

                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getLocalizedMessage() + "Ingrese el numero del cajero");
            }

        } while (opcion != 4);

    }

    public int CajeroMenosPersonas() {
        int cajero = 0;
        if (cajero1.tamano < cajero2.tamano & cajero1.tamano < cajero3.tamano & cajero1.tamano < cajero4.tamano) {
            cajero = 1;
        } else if (cajero2.tamano < cajero1.tamano & cajero2.tamano < cajero3.tamano & cajero2.tamano < cajero4.tamano) {
            cajero = 2;
        } else if (cajero3.tamano < cajero1.tamano & cajero3.tamano < cajero2.tamano & cajero3.tamano < cajero4.tamano) {
            cajero = 3;
        } else {
            cajero = 4;
        }
        return cajero;
    }

    public int CajeroMenorRepetidos() {
        int cajero = 0;
        if (cajero1.tamano <= cajero2.tamano & cajero1.tamano <= cajero3.tamano & cajero1.tamano <= cajero4.tamano) {
            cajero = cajero1.tamano;
        } else if (cajero2.tamano <= cajero1.tamano & cajero2.tamano <= cajero3.tamano & cajero2.tamano <= cajero4.tamano) {
            cajero = cajero2.tamano;
        } else if (cajero3.tamano <= cajero1.tamano & cajero3.tamano <= cajero2.tamano & cajero3.tamano <= cajero4.tamano) {
            cajero = cajero3.tamano;
        } else {
            cajero = cajero4.tamano;
        }
        return cajero;
    }


    public String CajerosIguales(int a) {
        contador = 0;
        String informacion = "Los siguientes cajeros tienen la misma cantidad de personas";
        if (cajero1.tamano == a) {
            informacion += "\nCajero 1";
            contador++;
        }
        if (cajero2.tamano == a) {
            informacion += "\nCajero 2";
            contador++;
        }
        if (cajero3.tamano == a) {
            informacion += "\nCajero 3";
            contador++;
        }
        if (cajero4.tamano == a) {
            informacion += "\nCajero 4";
            contador++;
        }

        return informacion;
    }

    public boolean VerificarDiferentes() {
        return cajero1.tamano != cajero2.tamano & cajero1.tamano != cajero3.tamano & cajero1.tamano != cajero4.tamano
                & cajero2.tamano != cajero3.tamano & cajero2.tamano != cajero4.tamano
                & cajero3.tamano != cajero4.tamano;
    }

    public boolean VerificarClientes() {
        return cajero1.tamano > 0 || cajero2.tamano > 0 || cajero3.tamano > 0 || cajero4.tamano > 0;
    }

    public void IngresarCliente(int a, String n) {
        switch (a) {
            case 1:
                cajero1.Agregar(n);
                break;
            case 2:
                cajero2.Agregar(n);
                break;
            case 3:
                cajero3.Agregar(n);
                break;
            case 4:
                cajero4.Agregar(n);
                break;
        }
    }

    public void Despachar() {
        int numero = ((int) (Math.random() * (5 - 1) + 1));
        switch (numero) {
            case 1:
                if (cajero1.tamano > 0) {
                    JOptionPane.showMessageDialog(null, "Se despacho a " + cajero1.Eliminar() + "del cajero 1");
                } else {
                    Despachar();
                }
                break;
            case 2:
                if (cajero2.tamano > 0) {
                    JOptionPane.showMessageDialog(null, "Se despacho a " + cajero2.Eliminar() + "del cajero 2");
                } else {
                    Despachar();
                }
                break;
            case 3:
                if (cajero3.tamano > 0) {
                    JOptionPane.showMessageDialog(null, "Se despacho a " + cajero3.Eliminar() + "del cajero 3");
                } else {
                    Despachar();
                }
                break;
            case 4:
                if (cajero4.tamano > 0) {
                    JOptionPane.showMessageDialog(null, "Se despacho a " + cajero4.Eliminar() + "del cajero 4");
                } else {
                    Despachar();
                }
                break;

        }
    }

    public String InformacionCajeros() {
        String dato = "Cantidad de personas en los cajeros\n"
                + "\nCajero 1: " + cajero1.tamano
                + "\nCajero 2: " + cajero2.tamano
                + "\nCajero 3: " + cajero3.tamano
                + "\nCajero 4: " + cajero4.tamano;
        return dato;
    }

}
