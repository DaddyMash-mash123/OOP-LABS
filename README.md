# OOP-LABS
REG NUMBER: H250320A
FULL NAME: MASHORO ELSON
DEPARTMENT: COMPUTER SCIENCE

# Appendix B: Viva Questions and Answers

## 1. What is the difference between a class and an object? Where in memory does each live?
A class is a blueprint that defines the properties and behaviours of something, while an object is an actual instance created from that class.
For example, in the Library Management System, Book is a class, while a particular book with ID B001 and title Java Basics is an object.
In memory, the class's runtime representation is maintained by the JVM  in the method area or equivalent runtime structures. Objects are normally allocated on the heap. A local variable that refers to an object may live in a stack frame, but the object itself is on the heap.

## 2. Why does Java not allow multiple inheritance of classes, and how do interfaces work around it?
Java does not allow a class to extend multiple classes because it can cause ambiguity.  
For example, if two parent classes have a method with the same name, Java would need to decide which implementation the child should inherit. Interfaces allow a class to implement multiple contracts without inheriting the full state and implementation of multiple parent classes.

## 3. Explain the difference between overloading and overriding with an example of each.
Overloading means having methods with the same name but different parameter lists in the same class or inheritance hierarchy for example 
```
void print(int number) { }
void print(String text) { }
```
Here Java chooses the appropriate method based on the argument supplied.  
While overriding happens when a subclass provides its own implementation of an inherited method. For example
```
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}
```
When sound() is called on a Cat object, the overridden version runs.

### 4. What happens if a superclass has no no-argument constructor and the subclass omits super(...)?
Java automatically tries to insert a call to super() as the first statement of the subclass constructor. If the parent class has no accessible no-argument constructor, compilation fails. It is demonstrated in lab 4 with the constructor inheritance example. If Animal only has Animal(String name), then Dog must explicitly call the matching constructor
```
class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}
```
This passes the name to the parent constructor.

### 5. When would you choose an abstract class over an interface?
I would choose an abstract class when related classes need to share common fields, constructors, or implemented methods, while still leaving some behaviour for subclasses to define. For example, the LibraryItem abstract class contains common properties such as the item ID, title and availability. Book and Dvd inherit those properties but provide their own loan periods.  
I would choose an interface when I want different classes to follow the same contract, even if they are not closely related by inheritance. The Borrowable interface defines borrowing and returning operations.

### 6. Why must hashCode() be overridden whenever equals() is overridden?
Because Java requires objects that are equal according to equals() to return the same hash code.
Collections such as HashSet and HashMap use hash codes to help locate objects. If two equal objects have different hash codes, a collection might treat them incorrectly.  
In the Lab 9 work, when we compared books using their ISBN, both needed equals() and hashCode() were needed to use the ISBN. This allowed a HashSet to recognize two books with the same ISBN as duplicates.

### 7. What is the difference between checked and unchecked exceptions? Give two examples of each.
Checked exceptions are checked by the compiler. A method must catch them or declare that it throws them.  
Examples:  
- ```
  IOException
  ```
- ```
  SQLException
  ```
Unchecked exceptions are subclasses of RuntimeException. The compiler does not require us to catch or declare them.  
Examples:
- ```
  ArithmeticException
  ```
- ```
  ArrayIndexOutOfBoundsException
  ```

### 8. Why can generics not be used with primitive types, and what is type erasure?
Java generics work with reference types, not primitive types. That is why we write ArrayList<Integer> rather than ArrayList<int>.
We use wrapper classes for primitive values:
```
- int becomes Integer
- double becomes Double
- char becomes Character
```
Type erasure means that Java generally removes generic type information during compilation, replacing type parameters with their bounds or Object where appropriate. This is one reason generic types cannot simply be primitive types.

### 9. What does final mean on a variable, a method and a class?
The meaning depends on where it is used.  
- Final variable: It can be assigned only once. If it is an object reference, the reference cannot be reassigned, although the object's contents might still change.
- Final method: A subclass cannot override that method.
- Final class: Another class cannot extend it.
For example
```
final int MAX_LOANS = 3;
```
### 10. Explain dynamic method dispatch. Why are fields and static methods not polymorphic?
Dynamic method dispatch is when Java decides at runtime which overridden instance method to execute, based on the actual object type rather than just the reference type.  
For example:
```
Animal animal = new Cat();
animal.sound();
```
Even though the reference type is Animal, Java executes Cat's sound() method.  
Fields behave differently: field access depends on the reference's declared type. Static methods are associated with classes and are hidden rather than overridden, so they do not use dynamic dispatch in the same way as instance methods.

### 11. What is a functional interface, and how does a lambda relate to it?
A functional interface is an interface with exactly one abstract method. It can be implemented using a lambda expression, which provides a concise way to supply that method's behaviour.

### 12. How do try-with-resources differ from try/finally?
Try-with-resources automatically closes resources that implement AutoCloseable, such as many file readers and writers, when the try block finishes, including when an exception occurs.  
A traditional try/finally uses a finally block to run cleanup code whether an exception occurs or not.
