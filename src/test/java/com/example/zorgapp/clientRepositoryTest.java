package com.example.zorgapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class clientRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClientRepository clientRepository;



    @Test
    void testFindById(){
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("HonHon");
        entityManager.persist(client);
        entityManager.flush();


        Optional<Client> optionalClient = clientRepository.findById(1L);
        var found = optionalClient.get();

        String expected = "HonHon";
        String actual = found.getFirstName();
        assertEquals(expected,actual);
    }
}