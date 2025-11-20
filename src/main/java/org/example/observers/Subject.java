package org.example.observers;

public interface Subject {


    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
    public String getUpdate(Observer o);
}
