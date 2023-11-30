/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

import java.util.Comparator;
import java.util.Iterator;


/**
 *
 * @author nicolassierra
 */
public class LinkedListCircular<E> implements List<E> {

    private Nodo<E> first;
    private Nodo<E> last;
    private int size;

    

//    private class Iterador implements Iterator<E> {
//
//        private int itr = 0;
//
//        @Override
//        public boolean hasNext() {
//            return itr < size;
//        }
//
//        @Override
//        public Object next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }
//            Nodo<E> f = first;
//            for (int i = 0; i < itr; i++) {
//                f = f.sig;
//            }
//            itr++;
//            return f.contenido;
//        }
//
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
    
    public E getFirst(){
        if(this.first == null || this.first.getContenido() == null){
            return null;
        }else{
            return this.first.getContenido();
        }
    }

    @Override
    public boolean contains(E element) {
        if (element == null || isEmpty()) {
            return false;
        }
        for (Nodo<E> i = first; i != null; i = i.getSig()) {
            if (i.getContenido().equals(element)) {
                return true;
            }
        }
        return false;
    }

   

    @Override
    public boolean add(E e) {
        Nodo<E> tmp = new Nodo(last, e, first);
        if (isEmpty()) {
            first = tmp;
            last = tmp;
            tmp.setSig(tmp);
            tmp.setAnt(tmp); 
            size++;
            return true;
        }
        Nodo<E> nodo = last;
        last = tmp;
        tmp.setSig(first);
        nodo.setSig(tmp);
        size++;
        return true;
    }
    
     private Nodo<E> getPrevious(Nodo<E> nodo) {
        if (nodo == first) {
            return null;
        }
        for (Nodo<E> i = first; i != null; i = i.getSig()) {
            if (i.getSig() == nodo) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            return false;
        } else if (first.getContenido().equals(element)) {
            removeFirst();
            return true;
        } else if (last.getContenido().equals(element)) {
            removeLast();
            return true;
        }

        for (Nodo<E> i = first; i != null; i = i.getSig()) {
            if (i.getContenido().equals(element)) {
                Nodo<E> previo = getPrevious(i);
                previo.setSig(i.getSig());
                i.setSig(null);
                return true;
            }
        }
        return false;
    }

    

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
//        if (index < 0 || index > size - 1)
//            throw new ArrayIndexOutOfBoundsException();
        Nodo<E> tmp = first;
        if (index > 0) {
            for (int i = 0; i < index; i++) {
                tmp = tmp.getSig();
            }
            return tmp.getContenido();
        } else if (index < 0) {
            return this.get(size - index);
        }
        return tmp.getContenido();
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        if (index <= 0 || index > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index != 0) {
            Nodo<E> tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getSig();
            }
            Nodo<E> tmpAnt = tmp.getAnt();
            Nodo<E> nuevoNodo = new Nodo(tmpAnt, element, tmp);
            tmpAnt.setSig(nuevoNodo);
            tmp.setAnt(nuevoNodo);
        } else {
            Nodo<E> nuevoNodo = new Nodo(last, element, first);
            first.setAnt(nuevoNodo);
            last.setSig(nuevoNodo);
            first = nuevoNodo;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index != 0 && index != size - 1) {
            Nodo<E> nodo = first;
            for (int i = 0; i < index; i++) {
                nodo = nodo.getSig();
            }
            Nodo<E> tmpSig = nodo.getSig();
            Nodo<E> tmpAnt = nodo.getAnt();
            tmpSig.setAnt(tmpAnt);
            tmpAnt.setSig(tmpSig);
            size--;
            return nodo.getContenido();
        } else if (index == 0) {
            return removeFirst();
        } else {
            return removeLast();
        }
    }

    public E removeLast() {
        E elem = first.getContenido();
        first.setAnt(last.getAnt());
        last.getAnt().setSig(first);
        last = last.getAnt();
        size--;
        return elem;
    }

    public E removeFirst() {
        E elem = last.getContenido();
        last.setSig(first.getSig());
        first.getSig().setAnt(last);
        first = first.getSig();
        size--;
        return elem;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Nodo<E> x = first; x != null; x = x.getSig()) {
                if (x.getContenido() == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Nodo<E> x = first; x != null; x = x.getSig()) {
                if (o.equals(x.getContenido())) {
                    return index;
                }
                index++;
            }
        }
        return -1; 
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sort(Comparator<? super E> comparador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
