# step-by-step explanation of the theme of creating your own immutable class:

* *Final class* - no inheritance allowed:
By making your class ***"final,"*** you prevent other classes from inheriting from it.
This ensures that the behavior and state of your class cannot be altered through inheritance,
maintaining immutability.

* No setters, only constructor initialization:
Immutable classes ***should not provide any setter methods to modify their internal state***.
Instead, the initial values of the class's fields are set through the constructor during object creation.
Once the object is instantiated, its state remains unchanged.

* Return deep copy of collection:
If your immutable class contains a collection (such as a List or Set), 
***you should return a deep copy of that collection*** when providing access to it.
This prevents external modification of the internal collection and maintains immutability.

* Return deep clone of any custom (not immutable) objects:
If your immutable class contains fields that are custom objects (which are not already immutable),
you should return deep clones of those objects when providing access to them. 
This ensures that changes made to the returned objects do not affect the internal state of the
immutable class.

* Clone the object and collection in the constructor:
In Java, to ensure immutability, it's common to clone any mutable objects and collections passed into the constructor. This way, changes made to the original objects outside of the class do not impact the internal state of the immutable class.

### By following these steps, you can create your own immutable class that guarantees its state 
### remains unchanged after instantiation, promoting immutability, and providing benefits such 
### as thread-safety and easier reasoning about the code's behavior.


# Example :

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {
    private final int id;
    private final String name;
    private final List<String> items;

    public ImmutableClass(int id, String name, List<String> items) {
        this.id = id;
        this.name = name;
        this.items = new ArrayList<>(items); // Step 5: Clone the collection

        // Step 4: Deep clone any custom objects if necessary
        // Example: If the 'items' list contains mutable objects, clone them here
        for (int i = 0; i < this.items.size(); i++) {
            this.items.set(i, new CustomObject(this.items.get(i)));
        }
    }

    // Step 1: No inheritance allowed, class is marked final

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items); // Step 3: Return deep copy of collection
    }

    // Step 2: No setters, only constructor initialization
}
```

#### In this example, we have an ImmutableClass with three fields: 
* id, 
* name,
* items. 

*Here's how each step is implemented:*

* The class is marked as ***final***, preventing inheritance from other classes.
* There are ***no*** setters for the fields; their values are only initialized through the constructor.
* The ***getItems()*** method returns an unmodifiable list, ensuring that the internal ***items*** collection 
cannot be modified externally. This provides a deep copy of the collection to maintain immutability.
* If the ***items*** list contains mutable objects (in this example, represented by the ***CustomObject class***), 
a deep clone is performed in the constructor to ensure that changes made to the returned objects do not affect the internal 
state of the ImmutableClass.
* The ***items*** collection is cloned in the constructor to prevent external modifications from affecting the internal state.

#### By following these steps, the ImmutableClass remains immutable, guaranteeing that its state cannot be changed after instantiation.


# Example of how you can create a *deep copy* of a collection

```java
import java.util.ArrayList;
import java.util.List;

public class DeepCopyExample {
    public static void main(String[] args) {
        List<MutableObject> originalList = new ArrayList<>();
        originalList.add(new MutableObject("Item 1"));
        originalList.add(new MutableObject("Item 2"));

        // Create a deep copy of the originalList
        List<MutableObject> deepCopyList = new ArrayList<>();
        for (MutableObject obj : originalList) {
            deepCopyList.add(new MutableObject(obj.getName()));
        }

        // Modify the originalList
        originalList.get(0).setName("Modified Item");

        // Verify that the deepCopyList remains unchanged
        System.out.println("Original List: " + originalList);
        System.out.println("Deep Copy List: " + deepCopyList);
    }
}

class MutableObject {
    private String name;

    public MutableObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MutableObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

### In this example, we have a MutableObject class representing an object with a mutable state.
#### To create a deep copy of a collection containing such objects, follow these steps:

* Create a new collection to hold the deep copy.
* Iterate over the original collection.
* For each object in the original collection, create a new object with the same state (deep copy).
* Add the deep copy object to the new collection.

#### By performing these steps, 
you ensure that modifications made to the original objects do not affect the objects
in the deep copy collection. In the example above, the modification of the MutableObject in the originalList does not impact
the corresponding object in the deepCopyList.

*Output:*
```java
Original List: [MutableObject{name='Modified Item'}, MutableObject{name='Item 2'}]
Deep Copy List: [MutableObject{name='Item 1'}, MutableObject{name='Item 2'}]
```


# features and guidelines for working with immutable classes:

* ***Final Class***:
Declare the class as final to prevent it from being subclassed. 
This ensures that the immutability of the class cannot be compromised by inheritance.

* ***Private Fields***: 
Declare the fields of the class as private to encapsulate the state and prevent
direct access to them from outside the class.

* ***No Setters***:
Avoid providing setter methods for the fields.
Instead, initialize the fields through the class constructor or factory methods. 
This ensures that the state of the object is set only during its creation and cannot be modified afterwards.

* ***Immutable Fields***:
Ensure that the fields themselves are also immutable or effectively immutable. 
If a field is a mutable object (e.g., a collection or custom object),
create a deep copy of it during initialization to prevent external modification.

* ***No Mutable Methods***: 
Avoid providing methods that modify the internal state of the object. 
All methods should be designed to return a new instance with the desired changes instead
of modifying the existing instance.

* ***Defensive Copy***: 
If your immutable class accepts mutable objects as constructor arguments,
create defensive copies of those objects to ensure that the original objects remain unmodified.

* ***Thread Safety***:
Immutable classes are inherently thread-safe because their state cannot change after construction.
Multiple threads can safely access and share immutable objects without synchronization concerns.

* ***Equals and HashCode***: Implement the equals() and hashCode() methods based on the class's fields.
Since the object state is fixed, equality can be determined solely by comparing the field values.

* ***Documentation***: 
Clearly document that the class is immutable and explain the benefits and usage guidelines 
to ensure that other developers understand how to work with the class correctly.

### By following these guidelines, you can create immutable classes that provide several advantages, including:

* Thread safety: Immutable objects can be shared among multiple threads without the need for synchronization, reducing the risk of concurrency bugs.
* Security: Immutable objects cannot be modified once created, preventing unauthorized changes to sensitive data.
* Simplicity: Immutable objects have a fixed state, making them easier to reason about and reducing complexity in code that uses them.
* Reusability: Immutable objects can be used as keys in maps or elements in sets, as their state remains constant over time.
* Caching: Immutable objects can be safely cached, as their state does not change.


### Overall, immutable classes promote code reliability, maintainability,
### and make your code more robust in scenarios where immutability is desired.