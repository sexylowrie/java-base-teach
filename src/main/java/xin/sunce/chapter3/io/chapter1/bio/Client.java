package xin.sunce.chapter3.io.chapter1.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Copyright (C), 2010-2020, sun ce. Personal.
 * <p>
 * 测试客户端
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-20
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = null;
        OutputStream out = null;
        try {
            client = new Socket("127.0.0.1", 9090);
            out = client.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入您的聊天内容：");
            while (scanner.hasNext()) {
                String read = scanner.nextLine();
                out.write(read.getBytes("UTF-8"));
                out.flush();
            }
        } finally {
            if (client != null) {
                client.close();
            }
            if (out != null) {
                out.close();
            }
        }


    }
}
