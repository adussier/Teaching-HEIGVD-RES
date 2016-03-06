package ch.heigvd.res.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a file recorder
 * @author Amel Dussier
 */
public class FileRecorder implements IRecorder {
    
    // the path to the output file
    private final String _filePath;
    
    // the serializer used to convert incoming data
    private final ISerializer _serializer;
    
    // the stream used by the serializer
    private PrintStream _printStream;
    
    /**
     * Consttructor
     * @param filePath The path to the output file
     * @param serializerthe The serializer used to convert incoming data
     */
    public FileRecorder(String filePath, ISerializer serializer) {
        
        _filePath = filePath;
        _serializer = serializer;
    }

    @Override
    public void init() {
        // create file
        File outputFile = new File(_filePath);
        
        // create print stream
        try {
            _printStream = new PrintStream(outputFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void record(IData data) {
        _serializer.serialize(data, _printStream);
    }

    @Override
    public void close() {
        _printStream.close();
    }
}
