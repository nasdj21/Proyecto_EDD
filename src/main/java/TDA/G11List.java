/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TDA;

/**
 *
 * @author nicolassierra
 */
public interface G11List<E> {
    boolean addFirst(E e);
    
    boolean addLast(E e);
    
    int indexOf(E e);
    
    int size();

    boolean removeLast();

    boolean removeFirst();    
   
    boolean isEmpty();
        
    boolean contains(E e);
    
    boolean remove(int index);
}
