import java.io.Serializable;
import java.util.*;

public class PhoneBook implements Serializable {
    Map<String, Contacts> allContacts;
    private String email;
    private String firstName;
    private String lastName;

    public PhoneBook(String firstName, String lastName, String email) {
        allContacts = new HashMap<>();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Map<String, Contacts> getAllContacts() {
        return allContacts;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * display all contacts by alphabets
     * search contacts
     * get phone number, get email
     * delete contact
     * add contact - either by creating new contact or add to existing contact
     * edit contacts
     * */
    void displayContacts() {
        Map<String, Contacts> newTreeMap = new TreeMap<>(allContacts);
        Map<String, Contacts> sortedHashMap = new HashMap<>();
        sortedHashMap.putAll(newTreeMap);
        sortedHashMap.values().stream().forEach(contact -> System.out.println(contact));

    }
    public List<Contacts> searchContacts(String searchPhrase) {
        List<Contacts> searchResult = new ArrayList<>();
        Set<String> keySet = allContacts.keySet();
        for(String key : keySet) {
            if(key.contains(searchPhrase)) {
                searchResult.add(allContacts.get(key));
            }
        }
        return searchResult;
    }
    public Map<String, Contacts> deleteContact(String email) {
        allContacts.remove(email);
        return allContacts;
    }

    public void addContact(String email, String firstName, String lastName, String phoneNumber) {
        Contacts contact = new Contacts(firstName, lastName, email, phoneNumber);
        allContacts.put(contact.getEmail(), contact);
    }

    public void addToExistingContact(String email, String phoneNumber) {
        Contacts contact = allContacts.get(email);
        if(contact != null) {
            contact.setPhoneNumbers(phoneNumber);
        }
    }
    public  void displayPhoneNumbers(String email) {
        Contacts contact = allContacts.get(email);
        List<String> allPhoneNumbers = contact.getPhoneNumbers();
        for(String number : allPhoneNumbers) {
            System.out.println(number);
        }
    }
}
