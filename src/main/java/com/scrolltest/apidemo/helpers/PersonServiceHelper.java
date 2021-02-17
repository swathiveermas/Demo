//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
package com.scrolltest.apidemo.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.scrolltest.apidemo.constants.Endpoints;
import com.scrolltest.apidemo.model.Person;
import com.scrolltest.apidemo.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PersonServiceHelper {

    // We need to read the config variables
    // Rest Assured about the URL, Port
    // Make a Get REQUEST on this url and send the data to TestGETPerson

    private static final String BASE_URL = ConfigManager.getInstance( ).getString("base_url");
    private static final String PORT = ConfigManager.getInstance( ).getString("port");

    public PersonServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation( );

    }

    public List<Person> getAllPerson() {

        Response response = RestAssured
                .given( ).log( ).all( )
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_PERSON)
                .andReturn( );

        Type type = new TypeReference<List<Person>>( ) {
        }.getType( );

        assertEquals(response.getStatusCode( ), HttpStatus.SC_OK, "Ok");

        List<Person> personList = response.as(type);
        return personList;

    }


    public Response createPerson() {

        Person person = new Person( );
        person.setId(5);
        person.setFirstName("Amit");
        person.setLastName("Singh");
        person.setPhoneNumbers("9823232323");
        person.setAddress("ga ada s adas");

        // Need to make a Post call
        Response response = RestAssured.given( )
                .contentType(ContentType.JSON)
                .when( )
                .body(person)
                .post(Endpoints.CREATE_PERSON)
                .andReturn( );

        assertEquals(response.getStatusCode( ), HttpStatus.SC_CREATED, "Created");


        return response;
    }

    public Response updatePerson(Integer id){

        Person person = new Person();
        person.setFirstName("Pramod");
        person.setLastName("Dutta");
        person.setAge(34);
        person.setAddress("dasdasdsa");
        person.setPhoneNumbers("987654345");

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",id)
                .when().body(person)
                .patch(Endpoints.UPDATE_PERSON)
                .andReturn();
        assertTrue((response.getStatusCode() == HttpStatus.SC_OK));
        return response;


    }


    public Response deletePerson(Integer id){

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",id)
                .log().all()
                .when().delete(Endpoints.DELETE_PERSON)
                .andReturn();

        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        return response;
    }




}
