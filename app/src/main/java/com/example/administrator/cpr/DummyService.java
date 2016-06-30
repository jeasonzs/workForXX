package com.example.administrator.cpr;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/6/30.
 */
public class DummyService extends Service{
    public static final String TAG = "DummyService";
    public DummyBinder dummyBinder = null;
    private SocketThread socketThread;
    private OutputStream sendStream;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG,"====onCreate====");
        dummyBinder = new DummyBinder();
        socketThread = new SocketThread();
        socketThread.start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG,"====onBind====");
        return dummyBinder;
    }

    @Override
    public void onDestroy() {
        Log.v(TAG,"====onDestroy====");
        super.onDestroy();
    }


    public class DummyBinder extends Binder {
        public DummyService getService() {
            return DummyService.this;
        }
    }

    private void writeData(byte[] data) {
        try {
            sendStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startCpr() {
        Log.v(TAG,"====startCpr====");
        byte[] data = new byte[2];
        data[0] = 123;
        data[1] = 23;
        writeData(data);
    }


    private class SocketThread extends Thread
    {
        Socket socket;
        @Override
        public void run()
        {
            Log.v(TAG,"====SocketThread.run====");
            while (true) {
                Log.v(TAG,"connect to server....");
                try {
                    socket = new Socket();
                    SocketAddress socAddress = new InetSocketAddress("10.0.2.2", 60000);
                    socket.connect(socAddress, 1000);
//                    socket = new Socket("10.0.2.2", 60000);
                    InputStream readStream = socket.getInputStream();
                    sendStream = socket.getOutputStream();
                    byte[] recvData = new byte[1024];
                    while (readStream.read(recvData) != -1) {
                        Log.v(TAG, new String(recvData));
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
