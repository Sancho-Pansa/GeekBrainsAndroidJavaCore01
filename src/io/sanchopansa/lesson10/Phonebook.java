package io.sanchopansa.lesson10;

import java.util.ArrayList;
import java.util.List;

public class Phonebook<T extends String, E extends String> {
    private final List<T> phones;
    private final List<E> names;

    public Phonebook() {
        this.phones = new ArrayList<>();
        this.names = new ArrayList<>();
    }

    public void add(T phone, E name) {
        this.phones.add(phone);
        this.names.add(name);
    }

    public void get(E name) {
        for(int i = 0; i < names.size(); i++) {
            if(names.get(i).equals(name))
                System.out.println(this.phones.get(i));
        }
    }
}
