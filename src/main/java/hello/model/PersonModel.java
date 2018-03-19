package hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonModel {

    @Id
    private String name;

    public PersonModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
