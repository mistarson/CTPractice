public class Main {
    public static void main(String[] args) {

        Person p=new Person("2NE1");

        PersonService service = new PersonService();

        service.pass1(p);

        System.out.println(p.getName());

        service.pass2(p);

        System.out.println(p.getName());

    }
}
class Person{

    private String name;

    public Person(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

}

class PersonService {

    public void pass1(Person p) {

        p.setName("미쓰에이");

    }

    public void pass2(Person p) {

        p = new Person("소녀시대");

    }
}