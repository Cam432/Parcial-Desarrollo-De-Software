package com.APIREST;

import com.APIREST.model.ADN;
import com.APIREST.repository.ADNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ADNService {
    @Autowired
    private ADNRepository adnRepository;

    public ADN createADN(ADN adn){
        return adnRepository.save(adn);
    }

    public ADN getADNById(Long id){
        Optional <ADN> optionalADN = adnRepository.findById(id);
        return optionalADN.get();
    }

    public List <ADN> getAllADN(){
        return adnRepository.findAll();
    }

    public void deleteADN(Long id){
        adnRepository.deleteById(id);
    }
}
