package hello.dao;

import org.springframework.data.repository.CrudRepository;

import hello.model.PersonModel;

public interface HelloDao extends CrudRepository<PersonModel, String> {

}
