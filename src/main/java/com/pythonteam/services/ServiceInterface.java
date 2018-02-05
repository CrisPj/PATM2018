package com.pythonteam.services;

import javax.ws.rs.core.Response;

public interface ServiceInterface {

    //crud
    Response create();
    Response read();
    Response readAll();
    Response update();
    Response delete();
}
