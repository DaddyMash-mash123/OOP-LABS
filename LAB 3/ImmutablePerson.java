public final class ImmutablePerson {
    // EXPLAIN: Private final fields can only be assigned during initialization.
    private final String name;
    private final int age;

    // EXPLAIN: The constructor initializes all fields when the object is created.
    public ImmutablePerson(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name.trim();
        this.age = age;
    }
    // EXPLAIN: Getters allow callers to read the fields without changing them.
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    // EXPLAIN: Display the object's information without exposing its fields.
    @Override
    public String toString() {
        return "ImmutablePerson{name='" + name + "', age=" + age + "}";
    }
    public static void main(String[] args) {
        // EXPLAIN: Create an immutable object with valid information.
        ImmutablePerson person = new ImmutablePerson("Tariro", 21);
        // EXPLAIN: Read the information through public getter methods.
        System.out.println(person);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}


