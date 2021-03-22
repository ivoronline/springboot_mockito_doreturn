package com.ivoronline.springboot_mockito_doreturn.controllers;

import com.ivoronline.springboot_mockito_doreturn.entities.Person;
import com.ivoronline.springboot_mockito_doreturn.respositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyControllerTest {

  //MOCK CLASS
  @Mock PersonRepository personRepositoryMock;

  //INJECT MOCKS (where @autowired is used)
  @InjectMocks MyController myController;

  @Test
  void getPerson() {

    //MOCK REPOSITORY METHOD (getPersonById(1) returns Susan instead John for id=1)
 		doReturn(new Person(1, "Susan", 50)).when(personRepositoryMock).getPersonById(1);

    //TEST CONTROLLER ENDPOINT
    String result = myController.getPerson(1);

    //TEST RESULT
    assertEquals("Susan is 50 years old", result);

  }

}



