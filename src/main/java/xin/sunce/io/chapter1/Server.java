package xin.sunce.io.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO简介
 *
 * @author lowrie
 * @date 2019-07-24
 */
public class Server {


    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9999);
            System.out.println("Server is waiting for connecting....");
            Socket accept = server.accept();
            System.out.println("client:" + accept.getInetAddress().getHostAddress() + ":" + accept.getPort());
            while (true) {
                InputStream inputStream = accept.getInputStream();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                String content = reader.readLine();
//                if (content != null) {
//                    System.out.println("client:" + content);
//                }

                byte[] bytes = new byte[1024];
                inputStream.read(bytes);
                System.out.println("client:" + new String(bytes, "UTF-8").trim());
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
