package com.scrolltest.apidemo.tests;

import com.scrolltest.apidemo.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestPOSTPerson {

    // Init - PersonServiceHelper
    // Assert Create the Person and Verify it


    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }


    @Test
    public void testPOSTCreatePerson(){

        String id = personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id,"person id is not null");

    }






}
