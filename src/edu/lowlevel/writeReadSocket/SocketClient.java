/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lowlevel.writeReadSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiri60
 */

public class SocketClient {

    Socket sock;
    private final int portNumber;
    private final String hostname;
    PrintWriter out;
    Thread t;
    InputStream stream;
    int messagesSent = 0;

    private byte[] data;
    private boolean dataReady;

    protected final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    protected final Lock read = readWriteLock.readLock();

    protected final Lock write = readWriteLock.writeLock();

    public SocketClient(int portNumber, String hostname) {
        this.portNumber = portNumber;
        this.hostname = hostname;
    }

    public boolean isDataReady() {
        read.lock();
        try {
            return dataReady;
        } finally {
            read.unlock();
        }
    }

    public byte[] getData() {
        return data;
    }

    public boolean connect() {
        try {

            sock = new Socket(hostname, portNumber);
           
            stream = sock.getInputStream();

            out = new PrintWriter(sock.getOutputStream(), true);
            t = new Thread(new ClientSocketReadThread());
            t.start();

            System.out.println("Openning the socket Connection");

            return true;
        } catch (IOException ex) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public void close() {
        try {
            stream.close();
            out.close();
            sock.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void write(String s) {
        dataReady = false;
        out.print(s + '\0');         
        out.checkError();        
    }

    private class ClientSocketReadThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    if (stream != null && stream.available() != 0) {

                        data = new byte[100];
                        int count = stream.read(data);
                        
                        write.lock();
                        try {
                            dataReady = true;
                        } finally {
                            write.unlock();
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
