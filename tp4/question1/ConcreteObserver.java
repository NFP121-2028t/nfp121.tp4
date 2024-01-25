package question1;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

public class ConcreteObserver implements Observer {

    private Stack<Observable> senders;
    private Stack<Object> arguments;

    public ConcreteObserver() {
        senders = new Stack<Observable>();
        arguments = new Stack<Object>();
    }

    /**
     * implementation de la seule methode de l'interface java.util.Observer.
     * àchaque execution de cette methode, celle-ci se contente d'empiler les
     * parametres transmis observable et arg respectivement dans 2 piles senders
     * et arguments
     */
    public void update(Observable observable, Object arg) {
        senders.push(observable);
        arguments.push(arg);
    }

    public Stack<Observable> senders() {
        return senders;
    }

    public Stack<Object> arguments() {
        return arguments;
    }
}