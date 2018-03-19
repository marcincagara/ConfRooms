package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.dao.HelloDao;
import hello.dto.Person;
import hello.model.PersonModel;

@Service
public class HelloService {

    private HelloDao helloDao;

    @Autowired
    public HelloService(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    public Person getPerson(String name) {
        PersonModel person = helloDao.findById(name)
                .orElse(null);
        if (person == null) {
            person = new PersonModel();
            person.setName(name);
            helloDao.save(person);
        }

        Person result = new Person(person.getName());
        return result;
    }
}
