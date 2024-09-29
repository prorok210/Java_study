package lab3;

public class Main {
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable();
        for (int i = 0; i < 33; i++) 
            table.put("key" + i, "value" + i);
            
        table.show();

        System.out.println("\n#######################");

        for (int i = 0; i < 1223; i++) 
            table.put("key" + i, "value" + i);

        table.show();
        System.out.println(table.getCount());

        System.out.println("\n#######################");

        for (int i = 0; i < 1233; i++) {
            table.remove("key" + i);
        }
        table.show();
        System.out.println(table.getCount());

        System.out.println("\n#######################");

        table.clear();

        table.showAll();

        System.out.println("\n#######################");

        table.put("sobaka", "pes");
        table.put("ne znay", "chto napisat");
        table.show();
        System.out.println(table.getCount());
        System.out.println(table.contains("sobaka"));
        System.out.println(table.contains("ne znay"));
        System.out.println(table.contains("ne znay1"));
        System.out.println(table.get("sobaka"));
        System.out.println(table.get("ne znay"));
        System.out.println(table.get("ne znay1"));

        System.out.println("\n#######################");

        PhoneBook phoneBook = new PhoneBook();
        PhoneBook.Contact contact = phoneBook.new Contact("Ivan", "Ivanov", "pes@gmail.com");
        phoneBook.addContact("1234567890", contact);
        System.out.println(phoneBook.getContact("1234567890").toString());
        phoneBook.removeContact("1234567890");
        System.out.println(phoneBook.getContact("1234567890"));
    }

}
