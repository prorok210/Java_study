package lab3;

import java.util.HashMap;

public class PhoneBook extends HashMap<String, Object> {
    public class Contact {
        String name;
        String surname;
        String email;

        public Contact(String name, String surname, String email) {
            this.name = name;
            this.surname = surname;
            this.email = email;
        }

        @Override
        public String toString() {
            return name + " " + surname + " " + email;
        }
    }

    public PhoneBook() {
        super();
    }

    public PhoneBook(String mobile, Contact contact) {
        put(mobile, contact);
    }

    public void addContact(String mobile, Contact contact) {
        put(mobile, contact);
    }

    public Contact getContact(String mobile) {
        return (Contact) get(mobile);
    }

    public void removeContact(String mobile) {
        remove(mobile);
    }
}