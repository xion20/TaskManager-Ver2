package com.util;

import com.logic.Task;
import com.util.Nodo;

public class List {
    private Nodo root;
    int cant = 0;

    public List() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(Task note) {
        Nodo newnodo = new Nodo(note);
        cant += 1;
        if (isEmpty()) {
            root = newnodo;
        } else {
            Nodo current = root;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newnodo);
        }
    }

    public String[] titles() {
        if (isEmpty()) {
            return null;
        } else {
            String[] Ltitles = new String[cant];
            Nodo aux = root;
            int i = 0;
            while (aux != null) { // Corregir esta línea
                Ltitles[i] = aux.getCont().gettitle();
                i += 1;
                aux = aux.getNext(); // Avanzar al siguiente nodo
            }
            return Ltitles;
        }
    }

    public void deleteByTitle(String titleToDelete) {
        if (isEmpty()) {
            return;
        }
        if (root.getCont().gettitle().equals(titleToDelete)) {
            cant -= 1;
            root = root.getNext();
            return;
        }
        Nodo current = root;
        while (current.getNext() != null) {
            if (current.getNext().getCont().gettitle().equals(titleToDelete)) {
                cant -= 1;
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    public Task DoneNote(String titleToFind) {
        if (isEmpty()) {
            return null;
        }
        if (root.getCont().gettitle().equals(titleToFind)) {
            cant -= 1;
            Task doneNote = root.getCont();
            root = root.getNext();
            return doneNote;
        }
        Nodo current = root;
        while (current.getNext() != null) {
            if (current.getNext().getCont().gettitle().equals(titleToFind)) {
                cant -= 1;
                Task doneNote = current.getNext().getCont();
                current.setNext(current.getNext().getNext());
                return doneNote;
            }
            current = current.getNext();
        }
        return null;
    }

    public Nodo getRoot() {
        return root;
    }

    public Task findNote(String titleToFind) {
        if (isEmpty()) {
            return null;
        }

        Nodo current = root;
        while (current != null) {
            if (current.getCont().gettitle().equals(titleToFind)) {
                // Encuentra la nota por título y la devuelve
                return current.getCont();
            }
            current = current.getNext();
        }

        // Si no se encontró la nota, se devuelve null
        return null;
    }
    
    public void muestra(){
        Nodo temp;		
            if (!isEmpty()){
		temp=this.root;
		while (temp!=null){
                    System.out.println("Elemento " + temp.getCont().gettitle());
                    temp=temp.getNext();
		}			
            }else{
		System.out.println("Error muestra. Lista vacia");
	}		
    }
    
    /*
    Aqui hay que completar estos 2 metodos
    El primero busca la tarea que coincide con el titulo y cambia atributos status a 1, con el metodo setDone();
    El segundo haria lo mismo solo que cambiaria el status a 0, con el metodo setTodo();
    */

    public void setDone(String selectedTitle) {
        
    }

    public void setToDo(String selectedTitle) {
        
    }
}

