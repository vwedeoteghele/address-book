import java.util.ArrayList;

public class Contacts implements Comparable<Contacts> {
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<String> phoneNumbers;
    public Contacts(String firstName, String lastName, String email, String phoneNumber) {
        this.phoneNumbers = new ArrayList<String>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumbers.add(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumbers(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    @Override
    public int compareTo(Contacts contact) {
      return this.firstName.compareTo(contact.getFirstName());
    }
    @Override
    public String toString() {
        return "firstname: " + firstName + " lastname: " + lastName + " phone: " + phoneNumbers + " email: " + email;
    }
}
