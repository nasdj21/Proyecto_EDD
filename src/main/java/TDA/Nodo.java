/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

/**
 *
 * @author nicolassierra
 */
public class Nodo<E> {

        private E contenido;
        private Nodo<E> sig;
        private Nodo<E> ant;

        public Nodo(Nodo<E> ant, E e, Nodo<E> sig) { //constructor de una lista sin anidar 
            contenido = e;
            this.sig = sig;
            this.ant = ant;
        }

        @Override
        public String toString() {
            return "[Anterior: " + this.ant.contenido + ", Elemento: " + this.contenido + ", Siguiente: " + this.sig.contenido + "]";
        }

    public E getContenido() {
        return contenido;
    }

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    public Nodo<E> getSig() {
        return sig;
    }

    public void setSig(Nodo<E> sig) {
        this.sig = sig;
    }

    public Nodo<E> getAnt() {
        return ant;
    }

    public void setAnt(Nodo<E> ant) {
        this.ant = ant;
    }
        
        
    }
