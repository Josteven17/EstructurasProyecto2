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
public class Cola {

    NodoCola inicio, fin;
    int tamano;
 

    public Cola() {
        inicio = null;
        fin = null;
        tamano = 0;

    }

    public boolean Vacia() {

        return inicio == null;

    }

    public void Agregar(String dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (Vacia()) {
            inicio = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamano++;
    }

    public String Eliminar() {
        String aux = inicio.dato;
        inicio = inicio.siguiente;
        tamano--;
        return aux;
    }

    public int Tamano() {
        return tamano;
    }

}
