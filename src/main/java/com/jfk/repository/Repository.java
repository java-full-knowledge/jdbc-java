package com.jfk.repository;


import java.sql.SQLException;

/**
 * @author William Arustamyan
 */


public interface Repository<Entity, ID> {

    ID save(Entity entity);
}
