package com.APIREST.Services;

import com.APIREST.controller.ADNController;
import com.APIREST.model.ADN;
import com.APIREST.ADNService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ADNControllerTest {

    @Mock
    private ADNService adnService;

    @InjectMocks
    private ADNController adnController;

    @Test
    public void testIsMutant_Mutant() throws IOException {
        // Arrange
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        String json = "{\"dna\": " + new ObjectMapper().writeValueAsString(dna) + "}";
        when(adnService.createADN(any(ADN.class))).thenReturn(new ADN());

        // Act
        ResponseEntity<String> response = adnController.IsMutant(json);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody());
    }

    @Test
    public void testIsMutant_NotMutant() throws IOException {
        // Arrange
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGATGG", "CGCCTA", "TCACTA"};
        String json = "{\"dna\": " + new ObjectMapper().writeValueAsString(dna) + "}";
        when(adnService.createADN(any(ADN.class))).thenReturn(new ADN());

        // Act
        ResponseEntity<String> response = adnController.IsMutant(json);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals("FORBIDDEN", response.getBody());
    }

    @Test
    public void testIsMutant_MissingDnaField() throws IOException {
        // Arrange
        String json = "{\"invalid\": \"json\"}";

        // Act
        ResponseEntity<String> response = adnController.IsMutant(json);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals("FORBIDDEN", response.getBody());
    }
}
