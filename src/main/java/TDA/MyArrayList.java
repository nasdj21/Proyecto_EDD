package TDA;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nicolassierra
 */
public class MyArrayList<E> implements List<E> {
    private E[] elementos;
    private int size;
    private int capacidad = 50;
    
    public MyArrayList() {
        elementos = (E[]) new Object[capacidad];
        this.size = 0;
    }
    
    public MyArrayList(int capacidad) {
        elementos = (E[]) new Object[capacidad];
        this.size = 0;
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.size; i++) {
            s.append(this.get(i).toString());
            if (i < this.size - 1) {
                s.append(", ");
            }
        }

        return s.toString();
    }
 
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iter = new Iterator<>(){
            int index = 0;
        
            @Override
            public boolean hasNext(){
                return index<size();
            }
        
            @Override
            public E next(){
                E result = get(index);
                index++;
                return result;
            }

            @Override
            public void remove(){
                MyArrayList.this.remove(index-1);
                index--;
            }
        };
        return iter;
    }

    
    private void addCapacity() {
        E[] nuevoArray = (E[]) new Object[capacidad*2];
        for (int i = 0; i < size; i++) {
            nuevoArray[i] = elementos[i];
        }
        this.elementos = nuevoArray;
        this.capacidad = capacidad*2;
    }

    @Override
    public boolean add(E e) {
        if (size == capacidad)
            addCapacity();
        elementos[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (this.get(i).equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

   

    @Override
    public void clear() {
        //los elementos quedan como basura
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException();
        
        return elementos[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException();
        
        E prev = elementos[index];
        elementos[index] = element;
        return prev;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException();
        if (size == capacidad)
            addCapacity();
        for (int i = size; i > index; i--) {
            elementos[i] = elementos[i-1];
        }
        size++;
        elementos[index] = element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException();
        if (size == capacidad)
            addCapacity();
        E elem = elementos[index];
        for (int i = index; i < size; i++) {
            elementos[i] = elementos[i+1];
        }
        size--;
        return elem;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
           if (this.get(i).equals(element))
               return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.get(i).equals(element))
                index = i;
        }
        return index;
    }

 
    
    @Override
    public void sort(Comparator<? super E> comparador) {
        Arrays.sort(elementos, 0, size, comparador);
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(E element) {
        boolean c = false;
        if(element==null) return c;
        if(isEmpty()) return c;
        int i = 0;
        while(i<size){
            if(elementos[i]==element){
                c = true;
                i=size;
            }
            i++;
        }
        return c;
    }
}
