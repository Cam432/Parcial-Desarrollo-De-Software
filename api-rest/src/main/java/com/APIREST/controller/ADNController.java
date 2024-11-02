package com.APIREST.controller;


import com.APIREST.ADNService;
import com.APIREST.Algoritmo.AlgoritmoADN;
import com.APIREST.model.ADN;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ADNController {

    @Autowired
    private ADNService adnService;

    @PostMapping
    public ADN createADN(ADN adn){
        return adnService.createADN(adn);
    }

    @GetMapping("/ADNs")
    public List <ADN> getAllADN(){
        return adnService.getAllADN();
    }

    @GetMapping("{id}")
    public ADN searchADNByiD(@PathVariable("id") Long id){
        return adnService.getADNById(id);
    }

    @DeleteMapping("{id}")
    public void deleteADNByiD(@PathVariable("id") Long id){
        adnService.deleteADN(id);
    }

    @PostMapping("/mutant")
    public ResponseEntity<String> IsMutant(@RequestBody String data) throws JsonParseException, IOException {
        JsonNode nodo = new ObjectMapper().readTree(data).get("dna");
        if (nodo == null || !nodo.isArray()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("FORBIDDEN");
        }
        ArrayList<String> lista = new ArrayList<String>();
        for (JsonNode n : nodo) {
            lista.add(n.asText());
        }
        String[] stringArray = new String[lista.size()];
        stringArray = lista.toArray(stringArray);
        boolean Resultado = AlgoritmoADN.isMutant(stringArray);
        ADN adn = new ADN();
        adn.setCodigoADN(String.join(",", stringArray));
        adn.setEsMutante(Resultado);
        createADN(adn);
        if (Resultado) {
            return ResponseEntity.ok("OK");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("FORBIDDEN");
        }
    }

}