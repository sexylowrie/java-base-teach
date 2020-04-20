package xin.sunce.chapter3.io.chapter1.bio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 模拟BIOServer端
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-20
 */
public class Server {

    public static HashMap<String, String> userMap = new HashMap<>(1024);

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9090);
        Socket accept = null;
        System.out.println("等待客户端连接中....");
        while (true) {
            accept = server.accept();
            read(accept);
        }
    }


    public static void read(Socket socket) {
        InputStreamReader reader = null;
        OutputStreamWriter writer = null;
        char[] buffer = new char[10];
        int length = 0;
        try {
            writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            if (null == getUser(socket)) {
                writer.write("输入：[我叫XXX] 可以记录或者修改您的用户名");
                writer.flush();
            }
            reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
            while ((length = reader.read(buffer)) != 0) {
                String context = new String(Arrays.copyOf(buffer, length));
                if (context.contains("我叫")) {
                    addUser(socket, context.split("我叫")[1]);
                }
                System.out.println(String.format("收到[%s]:%s", getUser(socket), context));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据地址+端口获取用户名
     *
     * @param socket
     * @return
     */
    public static String getUser(Socket socket) {
        return userMap.get(socket.getInetAddress().getHostAddress() + socket.getPort());
    }


    public static void addUser(Socket socket, String user) {
        userMap.put(socket.getInetAddress().getHostAddress() + socket.getPort(), user);
    }


}
