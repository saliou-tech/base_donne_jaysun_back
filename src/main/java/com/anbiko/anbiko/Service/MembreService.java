package com.anbiko.anbiko.Service;

import com.anbiko.anbiko.Entity.Membre;

import java.util.List;

public interface MembreService {


    Membre ajoutMembre(Membre membre) ;
    List<Membre> listMembre() ;

    String supprimerMembre(Long id );
    Membre  modifierMembre();
}
