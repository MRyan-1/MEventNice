package org.myran.eventnicetest.Thread;

import org.mryan.eventnice.annotation.EventReceive;
import org.mryan.eventnice.core.EventContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description： UserThread
 * @Author MRyan
 * @Date 2021/10/8 23:10
 * @Version 1.0
 */
public class MThread extends Thread {

    private Socket connection;

    private EventContext context;

    private BufferedReader in;

    private PrintWriter out;

    public MThread(Socket connection, EventContext context) {
        this.connection = connection;
        this.context = context;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @EventReceive
    public void receiveMessage(String message) {
        if (out != null) {
            out.println(message);
            System.out.println("receiveMessage:" + message);
        }
    }

    @Override
    public void run() {
        try {
            String input;
            while ((input = in.readLine()) != null) {
                context.post(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reached eof
        context.unregister(this);
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        in = null;
        out = null;
    }
}