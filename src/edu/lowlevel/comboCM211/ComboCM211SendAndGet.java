/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lowlevel.comboCM211;



import edu.lowlevel.writeReadSocket.SocketClient;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author luiri60
 */
public class ComboCM211SendAndGet {

    private String hostName = "192.168.1.200";
    private int port = 50000;
    protected SocketClient csc;

    protected final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    protected final Lock read = readWriteLock.readLock();

    protected final Lock write = readWriteLock.writeLock();

    public ComboCM211SendAndGet() {
        System.out.println("Warning: Using default constructor with hostname " + hostName + " port " + port);
        csc = new SocketClient(port, hostName);
    }

    public ComboCM211SendAndGet(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
        csc = new SocketClient(port, hostName);
    }

    public boolean connectToSystem() {
        return csc.connect();
    }

    public void disconnectFromSystem() {
        csc.close();
    }

    protected void sendCommand(String command) {
        write.lock();
        try {
            csc.write(command);            
            while (!csc.isDataReady()) {
                try {
                    Thread.sleep(1);                   
                } catch (InterruptedException ex) {
                    Logger.getLogger(ComboCM211SendAndGet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } finally {
            write.unlock();
        }
    }

    protected byte[] getData() {
        write.lock();
        try {
            csc.write("getio");
            while (!csc.isDataReady()) {
                Thread.sleep(1);
            }
            return csc.getData();
        } catch (InterruptedException ex) {
            Logger.getLogger(ComboCM211SendAndGet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            write.unlock();
        }
        return null;
    }

}
