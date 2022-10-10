import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcessorImpl implements Processor {

    @Override
    public void process() {
        try (
                ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                RequestHandler requestHandler = new RequestHandler();
                System.out.println("Запущен поток " + requestHandler.hashCode());
                requestHandler.run(socket);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
