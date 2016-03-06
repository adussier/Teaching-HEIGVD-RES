package ch.heigvd.res.io;

import java.io.PrintStream;

/**
 * CSV serializer
 * @author Amel Dussier
 */
public class CsvSerializer implements ISerializer {

    // flag for the CSV header (written only the first time)
    private boolean _headerWritten = false;
    
    @Override
    public void serialize(IData data, PrintStream stream) {
        
        // write header on first time
        if (!_headerWritten) {
            
            // construct header line
            String header = collectionToCsvString(data.getAttributes());

            // print to stream
            stream.println(header);

            _headerWritten = true;
        }
        
        // construct values line
        String values = collectionToCsvString(data.getValues());
        
        // print to stream
        stream.println(values);
    }
    
    /**
     * Converts an iterable collection to a CSV string
     * @param collection An iterable collection with values
     * @return A CSV formatted string
     */
    private String collectionToCsvString(Iterable collection) {
        
        String line = "";
        
        // add values and delimiters to the line
        for (Object o : collection)
            line += o.toString() + ',';
        
        // remove last delimiter
        line = line.substring(0, line.length() - 1);
        
        return line;
    }
}
