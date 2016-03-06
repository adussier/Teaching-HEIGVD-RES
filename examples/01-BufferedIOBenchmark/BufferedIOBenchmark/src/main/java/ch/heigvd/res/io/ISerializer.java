package ch.heigvd.res.io;

import java.io.PrintStream;

/**
 * Serializer interface
 * @author Amel Dussier
 */
public interface ISerializer {
    
    // serialize some data to a given stream
    void serialize(IData data, PrintStream stream);
}
