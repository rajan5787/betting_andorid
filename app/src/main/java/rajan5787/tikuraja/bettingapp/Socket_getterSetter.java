package rajan5787.tikuraja.bettingapp;

import android.app.Application;
import android.provider.SyncStateContract;

import java.net.URISyntaxException;
import java.util.logging.SocketHandler;

import io.socket.client.IO;
import io.socket.client.Socket;
/**
 * Created by rajanpipaliya on 08/03/19.
 */

public class Socket_getterSetter extends Application {
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://192.168.0.3:8000");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}