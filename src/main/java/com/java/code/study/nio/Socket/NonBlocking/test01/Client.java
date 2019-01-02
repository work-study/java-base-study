package com.java.code.study.nio.Socket.NonBlocking.test01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class Client {

    public void clientTest() throws IOException {
        //1、获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //2、设置为非阻塞模式
        socketChannel.configureBlocking(false);
        //3、分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4、发送数据
        buffer.put(new Date().toString().getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
        socketChannel.close();
    }
}
