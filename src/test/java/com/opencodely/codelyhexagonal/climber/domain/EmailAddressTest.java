package com.opencodely.codelyhexagonal.climber.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailAddressTest {

    @Test
    void testEmailValidation() {
        EmailAddress email = new EmailAddress("wrong");
    }

}
