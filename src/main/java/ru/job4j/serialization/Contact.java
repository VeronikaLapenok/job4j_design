package ru.job4j.serialization;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");

        File tmpFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream out = new FileOutputStream(tmpFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(out)) {
            objectOutputStream.writeObject(contact);
        }

        try (FileInputStream in = new FileInputStream(tmpFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(in)) {
            final Contact contactFromFile = (Contact) objectInputStream.readObject();
            System.out.println(contactFromFile);
        }

    }
}
