package com.jfk.service;


/**
 * @author William Arustamyan
 */


public interface CrudService<Entity, Request> {

    Entity create(Request createRequest);
}
