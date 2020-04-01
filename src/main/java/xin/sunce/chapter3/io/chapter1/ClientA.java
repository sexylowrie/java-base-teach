package xin.sunce.chapter3.io.chapter1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * BIO简介
 *
 * @author lowrie
 * @date 2019-07-24
 */
public class ClientA {


    public static void main(String[] args) {
        Socket client = null;
        try {
            Scanner scanner = new Scanner(System.in);
            client = new Socket("127.0.0.1", 9999);
            OutputStream output = client.getOutputStream();
            System.out.println("client send：");
            while (true) {
                String context = scanner.next();
                output.write(context.getBytes("UTF-8"));
                output.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != client) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
