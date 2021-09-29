package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.Identity;

public class DocumentalId extends Identity {
    private DocumentalId(String id){
        super(id);
    }

    public DocumentalId of(String id){
        return new DocumentalId(id);
    }
}
