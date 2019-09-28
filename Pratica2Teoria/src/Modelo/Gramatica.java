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
public class Gramatica {

    private ArrayList<NoTerminal> noTerminales;
    private ArrayList<int[]> prdNoTerminales; // Indice de produccionesn por cada no terminal
    private ArrayList<Terminal> terminales;
    private ArrayList<Produccion> producciones;
    private ArrayList<NoTerminal> noTerminalesAnulables;
    private ArrayList<Integer> produccionesAnulables;

    public Gramatica(ArrayList<NoTerminal> noTerminales, ArrayList<Produccion> producciones) {
        this.noTerminales = noTerminales;
        this.producciones = producciones;
    }

    public ArrayList<Terminal> getConjuntoSeleccion(int i) { //Obtener conjunto de seleccion de la produccion i 
        ArrayList<Terminal> conjuntoSeleccion;
        conjuntoSeleccion = this.producciones.get(i).getConjuntoSeleccion(); //Obtener conjunto seleccion de la produccion "indiceProuccion"
        return conjuntoSeleccion;
    }

    public void agregarNoterminal(ArrayList<NoTerminal> noTerminales) {
        this.noTerminales = noTerminales;
    }

    public void agregarProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }
//    public void imprimirNoTerminales()
//    {
//          for (NoTerminal s : this.noTerminales)
//          {
//              System.out.println("No Terminal:"+s.getNombreNoTerminal()+" es simobolo Inicial"+s.isEsSimoboloInicial());
//          }
//    }

//    public void imprimirProducciones()
//    {   int i=0;
//        for(Produccion p: this.producciones)
//        {
//            System.out.println("Produccion #"+i+p.getLefSide()+"="+p.getRightSide());
//            i++;
//        }
//    }
    public ArrayList<Object> cacularTerminalesAnulables() {
        return null;
    }

    public ArrayList<NoTerminal> getNoTerminales() {
        return noTerminales;
    }

    public void setNoTerminales(ArrayList<NoTerminal> noTerminales) {
        this.noTerminales = noTerminales;
    }

    public ArrayList<int[]> getPrdNoTerminales() {
        return prdNoTerminales;
    }

    public void setPrdNoTerminales(ArrayList<int[]> prdNoTerminales) {
        this.prdNoTerminales = prdNoTerminales;
    }

    public ArrayList<Terminal> getTerminales() {
        return terminales;
    }

    public void setTerminales(ArrayList<Terminal> terminales) {
        this.terminales = terminales;
    }

    public ArrayList<Produccion> getProducciones() {
        return producciones;
    }

    public void setProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }

    public ArrayList<NoTerminal> getNoTerminalesAnulables() {
        return noTerminalesAnulables;
    }

    public void setNoTerminalesAnulables(ArrayList<NoTerminal> noTerminalesAnulables) {
        this.noTerminalesAnulables = noTerminalesAnulables;
    }

    public ArrayList<Integer> getProduccionesAnulables() {
        return produccionesAnulables;
    }

    public void setProduccionesAnulables(ArrayList<Integer> produccionesAnulables) {
        this.produccionesAnulables = produccionesAnulables;
    }

    public ArrayList<Integer> calcularProduccionesAnulables() {
        return null;
    }

    public ArrayList<Terminal> calcularPrimerosTerminal(NoTerminal noTerminal) {
        return null;
    }

    public ArrayList<Terminal> calcularPrimerosProduccion(Produccion produccion) {
        return null;
    }

    public ArrayList<Object> calcularSiguienteTerminal(NoTerminal notoTerminal) {
        return null;
    }

    public ArrayList<Object> calcularSeleccionProduccion(Produccion produccion) {
        return null;
    }

    //************************************
    public boolean esFormaEspecial() {
        int n = this.producciones.size();
        for (int i = 0; i < n; i++) {
            Produccion p = this.producciones.get(i);
            if (p.getLadoDerecho().size() == 2) {
                if (!p.getIndex(0).esTerminal() || p.getIndex(1).esTerminal()) {
                    return false;
                }
            } else if (p.getLadoDerecho().size() > 2 || p.getLadoDerecho().size() == 1) {
                return false;
            }
        }
        return true;
    }

    //compara conjunto de selección de la producion i, con los demas conjunto de selección de ese Terminal  
    //El indice de esos conjunto de selección así como el de i se encuentra en indexProducciones
    private boolean sonDisyuntosConjuntosSeleccion(int[] indexProducciones) {
        int i = 0;
        int n = indexProducciones.length;
        ArrayList<Terminal> conjuntoSeleccioni;
        boolean comparacion;
        while (i < n) {
            int iProduccion = indexProducciones[i];
            //Ahora hay que comparar cada conjunto de selección
            conjuntoSeleccioni = this.getConjuntoSeleccion(iProduccion);
            int k = 0;
            int aux;
            ArrayList<Terminal> conjuntoK;
            while (k < indexProducciones.length) {
                aux= indexProducciones[k];
                conjuntoK = this.getConjuntoSeleccion(aux);
                if (k != i) {//Solo compara con los conjuntos de seleccion diferentes a el 
                    comparacion = this.tieneTerminalIgual(conjuntoK, conjuntoSeleccioni);
                    if (comparacion) {
                        return false;
                    }
                }
                k++;
            }
            i++;
        }
        return true;
    }

    private boolean tieneTerminalIgual(ArrayList<Terminal> a, ArrayList<Terminal> b) {
        int i = 0;
        int k = 0;
        int n = a.size();
        int m = b.size();
        String terminalA;
        String terminalB;
        while (i < n) {
            if (a.get(i) != null) {//Si el simbolo terminal a comparar no es el vacio 
                terminalA = a.get(i).getNombreTermila();
                k = 0;
                while (k < m) {
                    if (b.get(k) != null) {//Si el simbolo terminal a comparar no es el vacio 
                        terminalB = b.get(k).getNombreTermila();
                        if (terminalA.compareTo(terminalB) == 0) {
                            return true;
                        }
                    }
                    k++;
                }
            }
            i++;
        }
        return false;
    }

    public boolean esLinealPorDerecha() {
        int n = this.producciones.size();
        for (int i = 0; i < n; i++) {
            Produccion p = this.producciones.get(i);
            int m = p.getLadoDerecho().size();
            int j = 0;
            while (j < m - 1) {//Pregunta hasta el penultimo elemento
                if (p.getLadoDerecho().size() > 0) {//Pregunta si no es nulo
                    if (!p.getLadoDerecho().get(j).esTerminal()) {//Si los primreos m-1 simbolos no son temrinales retorne false
                        return false;
                    }
                }
                j++;
            }

            if (m != 0) {
                if (p.getLadoDerecho().get(j).esTerminal()) { //Si el ultimo simbolo es terminal retorne false
                    return false;
                }
            }
        }
        return true;
    }

    public boolean esGramaticaLL1() {
        //Determinar 
        int n = this.noTerminales.size();
        boolean sonDisyuntos;
        for (int j = 0; j < n; j++) {//recorrer el Array de NoTerminales que en cada posición contiene las producciones de esa terminal
            int[] produccionesTerminalJ = this.prdNoTerminales.get(j);//producciones por el No terminal j
            sonDisyuntos = this.sonDisyuntosConjuntosSeleccion(produccionesTerminalJ);
            if (!sonDisyuntos) {
                return false;
            }
        }
        return true;
    }

}