package com.java.code.study.nio.channal;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * @author zouw
 * @date 16:26 2018/12/19
 */
public class TestChannal {
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //获取通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream("d:/test/aa.txt");
            fos = new FileOutputStream("d:/test/bb.txt");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //获取缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (inChannel.read(buffer) != -1) {
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws IOException {//2127-1902-1777
        long start = System.currentTimeMillis();
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("d:/test/aa.txt"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("d:/test/cc.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            //内存映射文件
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);
        } catch (IOException e) {
            //
        } finally {
            inChannel.close();
            outChannel.close();
        }

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));
    }


    //通道之间的数据传输(直接缓冲区)
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("d:/test/aa.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("d:/test/cc.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //		inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    @Test
    public void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("d:/test/aa.txt", "rw");

        //1. 获取通道
        FileChannel channel1 = raf1.getChannel();

        //2. 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(10);
        ByteBuffer buf2 = ByteBuffer.allocate(10);

        //3. 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("-----------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //4. 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("d:/test/dd.txt", "rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }


    //得到所有可用的字符集
    @Test
    public void test5() {
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> set = map.entrySet();

        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    //字符集
    @Test
    public void test6() throws IOException {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("尚硅谷威武！");
        cBuf.flip();

        //编码
        ByteBuffer bBuf = ce.encode(cBuf);

        for (int i = 0; i < 12; i++) {
            System.out.println(bBuf.get());
        }

        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());

        System.out.println("------------------------------------------------------");

        Charset cs2 = Charset.forName("GBK");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }
}
