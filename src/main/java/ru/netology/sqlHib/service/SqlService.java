
package ru.netology.sqlHib.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.sqlHib.entity.City;
import ru.netology.sqlHib.entity.Person;
import ru.netology.sqlHib.repository.CityRepository;
import ru.netology.sqlHib.repository.PersonRepository;

import java.util.List;

@Service
public class SqlService {

    private final CityRepository cityRepository;
    private final PersonRepository personRepository;

    public SqlService(CityRepository cityRepository, PersonRepository personRepository) {
        this.cityRepository = cityRepository;
        this.personRepository = personRepository;
    }

    public City readCityByName(String name) throws Exception {
        return cityRepository.readByName(name);
    }

    public List<City> readAllCityThanOrderByName() {
        return cityRepository.findAll(Sort.by("name").ascending());
    }

    public City createCity(String name) throws Exception {
        return cityRepository.createCity(name);
    }

    List<Person> findByCityName(String cityName) {
        return null;
    }


    public List<Person> readAllPersonThanOrderByAge() {
        return personRepository.findAll(Sort.by("personalData.age").ascending());
    }


}