package TDA;


import java.util.Comparator;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author nicolassierra
 */
interface List<E> {
    int size();
    
    boolean isEmpty();
    
    Iterator<E> iterator();
    
    boolean add(E e);
    
    boolean remove(E element);
    
    void clear();
    
    E get(int index);
    
    E set(int index, E element);
    
    void add(int index, E element);
    
    E remove(int index);
    
    int indexOf(E element);
    
    int lastIndexOf(E element);
    
    void sort(Comparator<? super E> comparador);
    
    boolean hasNext();
    
    boolean contains(E element);
}
