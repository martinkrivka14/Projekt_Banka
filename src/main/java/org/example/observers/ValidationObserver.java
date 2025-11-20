package org.example.observers;

import javax.security.auth.Subject;

public class ValidationObserver implements Observer {

    public String name;
    public Validation subject;
    public ValidationObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = subject.getUpdate(this);
        if(message != null) {
            System.out.println("Message for you is" + message);
        }else{
            System.out.println("Did not receive any update");
        }
    }

    @Override
    public void setSubject(Validation subject) {
        this.subject = subject;
    }
}
