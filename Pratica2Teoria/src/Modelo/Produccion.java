/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Carlos Benavidez
 */
public class Produccion {

    private boolean anulable;
    private Primeros conjuntoPrimeros;
    private ArrayList<Terminal> conjuntoSeleccion;

    private NoTerminal ladoIzquierdo;
    private ArrayList<Simbolo> ladoDerecho;
    private boolean esSimoboloInicial;

    public Simbolo getIndex(int i) {
        return this.ladoDerecho.get(i);
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public Primeros getConjuntoPrimeros() {
        return conjuntoPrimeros;
    }

    public void setConjuntoPrimeros(Primeros conjuntoPrimeros) {
        this.conjuntoPrimeros = conjuntoPrimeros;
    }

    public ArrayList<Terminal> getConjuntoSeleccion() {
        return conjuntoSeleccion;
    }

    public void setConjuntoSeleccion(ArrayList<Terminal> conjuntoSeleccion) {
        this.conjuntoSeleccion = conjuntoSeleccion;
    }

    public NoTerminal getLadoIzquierdo() {
        return ladoIzquierdo;
    }

    public void setLadoIzquierdo(NoTerminal ladoIzquierdo) {
        this.ladoIzquierdo = ladoIzquierdo;
    }

    public ArrayList<Simbolo> getLadoDerecho() {
        return ladoDerecho;
    }

    public void setLadoDerecho(ArrayList<Simbolo> ladoDerecho) {
        this.ladoDerecho = ladoDerecho;
    }

}
