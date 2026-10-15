# OOP-LABS
REG NUMBER: H250320A
FULL NAME: MASHORO ELSON
DEPARTMENT: COMPUTER SCIENCE

# Appendix B: Viva Questions and Answers

## 1. What is the difference between a class and an object? Where in memory does each live?
A class is a blueprint that defines the properties and behaviours of something, while an object is an actual instance created from that class.
For example, in the Library Management System, Book is a class, while a particular book with ID B001 and title Java Basics is an object.
In memory, the class's runtime representation is maintained by the JVM, typically in the method area or equivalent runtime structures. Objects are normally allocated on the heap. A local variable that refers to an object may live in a stack frame, but the object itself is on the heap.

## 2. Why does Java not allow multiple inheritance of classes, and how do interfaces work around it?
Java does not allow a class to extend multiple classes because it can cause ambiguity. For example, if two parent classes have a method with the same name, Java would need to decide which implementation the child should inherit. Interfaces allow a class to implement multiple contracts without inheriting the full state and implementation of multiple parent classes.
For example:
<img width="490" height="62" alt="image" src="https://github.com/user-attachments/assets/23896f5e-8864-49b2-ac29-e3c82d35414d" />
Here, Book extends one class but can implement multiple interfaces.

