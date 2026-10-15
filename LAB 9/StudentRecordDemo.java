public class StudentRecordDemo {
    public static void main(String[] args) {
        Student first = new Student("Tariro", 21);
        Student second = new Student("Tariro", 21);

        // EXPLAIN: Record equality compares component values, not object identity.
        System.out.println(first.equals(second));

        // EXPLAIN: name() accesses the name component of the record.
        System.out.println(first.name());

        // EXPLAIN: Printing a record uses its generated toString() method.
        System.out.println(first);
    }
}

