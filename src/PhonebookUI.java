import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class PhonebookUI {
    Scanner scanner;
    public PhonebookUI() {
        String fileName = "phonebook.ser";
        Person personToSearchFor = new Person("John", "Doe", 30);

        // Check if the file exists
        File file = new File(fileName);
        if (file.exists()) {
            try {
                // Deserialize the objects from the file
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Object obj;
                boolean objectFound = false;
                // Search for the object
                while ((obj = in.readObject()) != null) {
                    if (obj instanceof Person && obj.equals(personToSearchFor)) {
                        objectFound = true;
                        break;
                    }
                }
                in.close();
                fileIn.close();

                if (objectFound) {
                    System.out.println("Object already exists in file.");
                } else {
                    // Create the object and write it to the file
                    FileOutputStream fileOut = new FileOutputStream(file, true);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(personToSearchFor);
                    out.close();
                    fileOut.close();
                    System.out.println("Object created and added to file.");
                }
            } catch (EOFException e) {
                // End of file reached, continue with creating the object
                try {
                    FileOutputStream fileOut = new FileOutputStream(file, true);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(personToSearchFor);
                    out.close();
                    fileOut.close();
                    System.out.println("Object created and added to file.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // Create the file and write the object to it
            try {
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(personToSearchFor);
                out.close();
                fileOut.close();
                System.out.println("File created and object added to file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


        scanner = new Scanner(System.in);
        menu();

    }

    private void menu() {
        boolean quit = true;
        while (quit) {
            System.out.println("Select an options ");
            System.out.println("1. create new contact");
            System.out.println("2. Add to existing contact");
            System.out.println("3. delete contact");
            System.out.println("4. update contact");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    createContact();
                    quit = false;
                    break;
                case 2:
                    addToExistingContact();
                    quit = false;
                    break;
                case 3:
                    deleteContact();
                    quit = false;
                    break;
                case 4:
                    updateContact();
                    quit = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void createContact() {
        PhoneBook phoneBook = null;

        try {
            FileInputStream fileIn = new FileInputStream("phonebook.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            phoneBook = (PhoneBook) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object deserialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("MyInt = " + obj.myInt);
        System.out.println("MyString = " + obj.myString);

    }


}
