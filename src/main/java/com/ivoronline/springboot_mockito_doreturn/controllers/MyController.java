package com.ivoronline.springboot_mockito_doreturn.controllers;

import com.ivoronline.springboot_mockito_doreturn.entities.Person;
import com.ivoronline.springboot_mockito_doreturn.respositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @Autowired PersonRepository personRepository;

  @ResponseBody
  @RequestMapping("/GetPerson")
  public String getPerson(@RequestParam Integer id) {

    //GET PERSON
    Person person = personRepository.getPersonById(id);

    //GREET PERSON
    return "Hello " + person.name;

  }

}
