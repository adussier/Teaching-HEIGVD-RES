package ch.heigvd.res.io;

import java.util.Set;

/**
 * Data interface
 * @author Amel Dussier
 */
public interface IData {
    
    // get the names of the data object's attributes
    Set<String> getAttributes();
    
    // get the values of the data object
    Iterable<Object> getValues();
}
