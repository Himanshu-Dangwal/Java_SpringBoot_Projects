package co.newtonschool.contactmanager.repository;

import co.newtonschool.contactmanager.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactRepository {
    private int id = 1;
    private final Map<Integer, Person> personMap = new HashMap<>();

    {
        Person person1 = new Person();
        person1.setFirstName("Sagar");
        person1.setLastName("Kumar");
        person1.setCompany("Newton School");

        person1.setLandline("260164");
        person1.setMobile("9876543210");
        person1.setEmail("sagar.kumar@gmail.com");

        personMap.put(id, person1);
    }

    public Person getPersonById(int id) {
        return personMap.get(id);
    }

    public Map<Integer, Person> getPersonMap() {
        return personMap;
    }

    public int getId() {
        setId(++id);
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
