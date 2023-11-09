/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic;

/**
 *
 * @author Dante
 */
public class Nodo {
    Note cont;
    Nodo next;

    public Nodo(Note note) {
        cont = note;
        this.next = null;
    }

    public Note getCont() {
        return cont;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getNext() {
        return next;
    }
}

