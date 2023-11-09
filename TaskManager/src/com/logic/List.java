package com.logic;

public class List {
    private Nodo root;
    int cant = 0;

    public List() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(Note note) {
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

    public Note DoneNote(String titleToFind) {
        if (isEmpty()) {
            return null;
        }
        if (root.getCont().gettitle().equals(titleToFind)) {
            cant -= 1;
            Note doneNote = root.getCont();
            root = root.getNext();
            return doneNote;
        }
        Nodo current = root;
        while (current.getNext() != null) {
            if (current.getNext().getCont().gettitle().equals(titleToFind)) {
                cant -= 1;
                Note doneNote = current.getNext().getCont();
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

    public Note findNote(String titleToFind) {
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
}

