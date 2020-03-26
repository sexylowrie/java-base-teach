package xin.sunce.io.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author lowrie
 * @date 2019-07-24
 */
public class ServerThread extends Thread {
    private Socket socket = null;
    private BufferedReader reader = null;
    private InputStream inputStream = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String name = socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
            System.out.println("client:" + name);
//            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            System.out.println(name + ":" + reader.readLine());
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            System.out.println(name + ":" + new String(bytes, "UTF-8").trim());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
