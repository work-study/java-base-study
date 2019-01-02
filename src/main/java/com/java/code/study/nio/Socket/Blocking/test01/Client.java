package com.java.code.study.nio.Socket.Blocking.test01;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zouw
 * @date 15:06 2018/12/20
 */
public class Client {
    //客户端
    @Test
    public void client() throws IOException {
        //1. 获取通道
        SocketChannel sChannel = null;
        FileChannel inChannel = null;
        try {
            sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

            inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

            //2. 分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //3. 读取本地文件，并发送到服务端
            while (inChannel.read(buf) != -1) {
                buf.flip();
                sChannel.write(buf);
                buf.clear();
            }
        } finally {
            //4. 关闭通道
            inChannel.close();
            sChannel.close();
        }


    }
}
