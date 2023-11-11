/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.util;

import com.logic.Task;

/**
 *
 * @author Dante
 */
public class Nodo {
    Task cont;
    Nodo next;

    public Nodo(Task note) {
        cont = note;
        this.next = null;
    }

    public Task getCont() {
        return cont;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getNext() {
        return next;
    }
}

