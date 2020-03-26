package xin.sunce.io.chapter1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO简介
 *
 * @author lowrie
 * @date 2019-07-24
 */
public class ServerB {


    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9999);
            System.out.println("Server is waiting for connecting....");
            while (true) {
                Socket accept = server.accept();
                new ServerThread(accept).start();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (null != server) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
