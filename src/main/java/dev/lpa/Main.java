package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

//        LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);  // [Canberra, Sydney]

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);  // [Alice Springs, Brisbane, Darwin, Canberra, Sydney, Hobart, Melbourne, Toowoomba]

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);  // [Brisbane, Sydney]

        gettingElements(placesToVisit);
//        Retrieved element = Sydney
//        First element = Alice Springs
//        Last element = Toowoomba
//        Darwin is at position: 2
//        Melbourne is at position: 6
//        Element from element() = Alice Springs
//        Element from peek() = Alice Springs
//        Element from peekFirst() = Alice Springs
//        Element from peekLast() = Toowoomba

        printItinerary(placesToVisit);
//        Trip starts at Alice Springs
//        --> From: Alice Springs to Brisbane
//        --> From: Brisbane to Darwin
//        --> From: Darwin to Canberra
//        --> From: Canberra to Sydney
//        --> From: Sydney to Hobart
//        --> From: Hobart to Melbourne
//        --> From: Melbourne to Toowoomba
//        Trip ends at Toowoomba


        printItinerary2(placesToVisit);
//        Trip starts at Alice Springs
//        --> From: Alice Springs to Alice Springs
//        --> From: Alice Springs to Brisbane
//        --> From: Brisbane to Darwin
//        --> From: Darwin to Canberra
//        --> From: Canberra to Sydney
//        --> From: Sydney to Hobart
//        --> From: Hobart to Melbourne
//        --> From: Melbourne to Toowoomba
//        Trip ends at Toowoomba

        printItinerary3(placesToVisit);
//        Trip starts at Alice Springs
//        --> From: Alice Springs to Brisbane
//        --> From: Brisbane to Darwin
//        --> From: Darwin to Canberra
//        --> From: Canberra to Sydney
//        --> From: Sydney to Hobart
//        --> From: Hobart to Melbourne
//        --> From: Melbourne to Toowoomba
//        Trip ends at Toowoomba

        testIterator(placesToVisit);
//       [Alice Springs, Darwin, Canberra, Sydney, Hobart, Melbourne, Toowoomba]
    }

    private static void addMoreElements(LinkedList<String> list) {

        list.addFirst("Darwin");
        list.addLast("Hobart");

        // Queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");

        // stack methods
        list.push("Alice Springs");
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();  // remove first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();  // remove first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();  // remove last element
        System.out.println(s3 + " was removed");

        // Queue/Deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop();
        System.out.println(p4 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list) {

        System.out.println("Retrieved element = " + list.get(4));

        System.out.println("First element = " + list.getFirst());
        System.out.println("Last element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.lastIndexOf("Melbourne"));

        // Queue retrieval method (first in/first out)
        System.out.println("Element from element() = " + list.element());

        // Stack retrieval methods
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
    }


    public static void printItinerary(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1 ; i < list.size() ; i++) {
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list) {
        var iterator = list.listIterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")) {
                iterator.add("Lake Wivenhoe");  // the iterator stops here after replacing the element
            }
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.previous());
    }
}
