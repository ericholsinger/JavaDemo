import java.util.ArrayList;

public class Demo {
    // just a runnable class
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.run();
    }
    private void run() {
        ObjectOne objectOne = new ObjectOne();
        ObjectTwo objectTwo = new ObjectTwo();

        int listSize = 10;

        // just make a list of the Thing types
        ArrayList<Thing> thingList = makeThingList(listSize);

        // pass the list to ObjectOne
        objectOne.setThings(thingList);
        checkLength("objectOne", objectOne.getThings(), listSize);

        // get the list from objectOne and pass it to objectTwo
        objectTwo.setThings(objectOne.getThings());
        checkLength("objectTwo", objectTwo.getThings(), listSize);

        printThings("testList", objectOne.getThings());
        printThings("objectOne", objectOne.getThings());
        printThings("objectTwo", objectOne.getThings());

        // remove an item of a the list in objectOne
        objectOne.getThings().remove(0);

        // show that it is the same list everywhere and all size changed
        checkLength("thingList", thingList, listSize);
        checkLength("objectOne", objectOne.getThings(), listSize);
        checkLength("objectTwo", objectTwo.getThings(), listSize);

    }

    private void checkLength(String listName, ArrayList<Thing> things, int listSize) {
        if (listSize != things.size()) {
            System.err.println(String.format("%s doesn't have the expected list size! Expected: %d, but was %d.", listName, listSize, things.size()));
        }
    }

    private void printThings(String listName, ArrayList<Thing> things) {
        int i = 0;
        for (Thing thing: things) {
            System.out.println(String.format("%s [%d] id = %d", listName, i++, thing.id));
        }
    }

    private ArrayList<Thing> makeThingList(int size) {
        ArrayList<Thing> thingList = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            Thing thing = new Thing();
            thing.id = i;
            thingList.add(thing);
        }
        return thingList;
    }
}
