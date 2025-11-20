package org.example.observers;

import java.util.ArrayList;
import java.util.List;

public class Validation implements org.example.observers.Subject {


    private List<Observer> observers;
    private String message;
    private boolean changed;


    public Validation() {
        this.observers = new ArrayList<Observer>();
    }



    @Override
    public void registerObserver(Observer o) {
        if(o == null){
            throw new NullPointerException();
        }else{
            if(!observers.contains(o)) {
                observers.add(o);
            }
        }

    }

    @Override
    public void unregisterObserver(Observer o) {
        if(o == null){
            throw new NullPointerException();
        }else {
            if (observers.contains(o)) {
                observers.remove(o);
            }
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    @Override
    public String getUpdate(Observer o) {
        return this.message;
    }

    public void postMessage(String message) {
        System.out.println(message);
        this.message = message;
        this.changed = true;
        notifyObservers();

    }
}
