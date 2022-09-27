package com.anbiko.anbiko.Service.implementation;

import com.anbiko.anbiko.Entity.Membre;
import com.anbiko.anbiko.Exception.InvalidCredentialException;
import com.anbiko.anbiko.Repository.Membrerepository;
import com.anbiko.anbiko.Service.MembreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class MembreServiceImpl implements MembreService {
    @Autowired
    Membrerepository membrerepository;


    @Override
    public Membre ajoutMembre(Membre membre) {


        Optional<Membre> membreExist =membrerepository.findByTelephone(membre.getTelephone());

        if(!membreExist.isEmpty()){
           throw new RuntimeException("Le numéro " +" " +membreExist.get().getTelephone()+ " existe déja");
        }else{
             return  membrerepository.save(membre);
        }



    }

    @Override
    public List<Membre> listMembre() {
        return membrerepository.findAll();
    }

    @Override
    public String supprimerMembre(Long id) {
        return null;
    }

    @Override
    public Membre modifierMembre() {
        return null;
    }
}
