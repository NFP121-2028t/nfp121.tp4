package question1;

public class PatternObservateur extends junit.framework.TestCase {

    public void testNotify() {
        ConcreteSubject list;
        ConcreteObserver observer;

        list = new ConcreteSubject();           // création d'un "observé" constitué d'une liste
        observer = new ConcreteObserver();      // création d'un observateur
        list.addObserver(observer);             // ajouter cet observateur à la liste
        list.insert("il fait beau, ce matin");  // modification de cette liste, l'observateur doit
                                                // (dervrait) être notifié        
        
        // "vérification" :
        assertFalse(observer.senders().empty());                            // elle ne doit pas être vide,
        assertEquals(list, observer.senders().pop());                       // est-ce le bon émetteur ?
        assertEquals("il fait beau, ce matin", observer.arguments().pop()); // le paramètre reçu est-il correct ?
    }

    // une liste, 2 observateurs
    public void test1() {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteObserver o1 = new ConcreteObserver();
        ConcreteObserver o2 = new ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");

        // V�rifier que les deux observateurs ont bien �t� notifi�s avec les bons parametres
        assertFalse(o1.senders().empty());
        assertFalse(o2.senders().empty());
        
        assertEquals(l1, o1.senders().pop());
        assertEquals(l1, o1.senders().pop());

        assertEquals(l1, o2.senders().pop());
        assertEquals(l1, o2.senders().pop());
        
        assertFalse(o1.arguments().empty());
        assertFalse(o2.arguments().empty());
        
        // premiere notification
        assertEquals(" 1 ", o1.arguments().pop());
        assertEquals(" 1 ", o2.arguments().pop());
        
        // deuxieme notification
        assertEquals("test", o1.arguments().pop());
        assertEquals("test", o2.arguments().pop());
        
        // ne pas modifier ces lignes, dernieres assertions vraies de cette methode
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());
    }

    // deux listes, 1 observateur
    public void test2() {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteSubject l2 = new ConcreteSubject();

        ConcreteObserver o = new ConcreteObserver();
        
        l1.addObserver(o);
        l2.addObserver(o);
        l1.insert("testA");
        l1.insert(" A ");
        l2.insert("testB");
        l2.insert(" B ");

        // verifier que l'observateur a bien ete notife� par les deux listes
        assertFalse(o.senders().empty());
        
        assertEquals(l2, o.senders().pop());
        assertEquals(l2, o.senders().pop());

        assertEquals(l1, o.senders().pop());
        assertEquals(l1, o.senders().pop());

        assertFalse(o.arguments().empty());
        
        assertEquals(" B ", o.arguments().pop());
        assertEquals("testB", o.arguments().pop());
        
        assertEquals(" A ", o.arguments().pop());
        assertEquals("testA", o.arguments().pop());

        // ne pas modifier cette ligne, dernière assertion vraie de cette methode
        assertTrue(o.senders().empty() && o.arguments().empty());
    }

    // deux listes, 2 observateurs
    public void test3() {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteSubject l2 = new ConcreteSubject();
        ConcreteObserver o1 = new ConcreteObserver();
        ConcreteObserver o2 = new ConcreteObserver();
        
        l1.addObserver(o1);
        l1.addObserver(o2);
        l2.addObserver(o1);
        l2.addObserver(o2);

        // vérifier le bon fonctionnement de countObservers(), de deleteObserver() et deleteObservers()
        assertEquals(2, l1.countObservers());
        assertEquals(2, l2.countObservers());

        // Supprimer un Observer de l1
        l1.deleteObserver(o1);
        assertEquals(1, l1.countObservers()); // Seul o2 reste pour l1
        assertEquals(2, l2.countObservers());
    
        // Supprimer un Observer de l2
        l2.deleteObservers();
        assertEquals(1, l1.countObservers());
        assertEquals(0, l2.countObservers());
        l1.deleteObserver(o2);
        
        // ne pas modifier ces lignes, dernières assertions vraies de cette méthode
        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
    }
}