package ch.heigvd.res.io;

/**
 * Recorder interface
 * @author Amel Dussier
 */
public interface IRecorder {
    
    // initialize the recorder
    void init();
    
    // record some data
    void record(IData data);
    
    // close properly the recorder
    void close();
}
