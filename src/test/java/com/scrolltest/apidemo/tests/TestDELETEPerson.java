package com.scrolltest.apidemo.tests;

import com.scrolltest.apidemo.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestDELETEPerson {


    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init() {
        personServiceHelper = new PersonServiceHelper( );
    }

    @Test
    public void testDeletePerson() {

        personServiceHelper.deletePerson(3);
    }
}
