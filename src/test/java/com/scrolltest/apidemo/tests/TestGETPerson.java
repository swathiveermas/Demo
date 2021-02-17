package com.scrolltest.apidemo.tests;

import com.scrolltest.apidemo.helpers.PersonServiceHelper;
import com.scrolltest.apidemo.model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import java.util.List;

public class TestGETPerson {

        private PersonServiceHelper personServiceHelper;

        @BeforeClass
        public void init(){
                personServiceHelper = new PersonServiceHelper();
        }

        @Test
        public void testGetAllPerson(){
                List<Person> personList = personServiceHelper.getAllPerson();
                assertNotNull(personList,"Person List is not Empty");
                assertFalse(personList.isEmpty(),"Person List is not True");

        }

}
