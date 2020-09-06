import org.junit.Test;

import java.io.*;

public class TestMian {


    private File file;
    private File file2;
    private File file3;

    private StringBuilder sb = new StringBuilder();


    {
        file = new File("aa/aa.txt");
        if (!file.exists()) {
            file.mkdir();
        }

        file2 = new File("aa/bb.txt");
        if (!file.exists()) {
            file.mkdir();
        }
        file3 = new File("aa/220621199801300035单昭铮.jpg");
        if (!file.exists()) {
            file.mkdir();
        }
    }


    /**
     * 字符流
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        //输入
        FileReader fileReader = new FileReader(file2);
        char[] data = new char[5];
        int len;
        while ((len = fileReader.read(data)) != -1) {
            sb.append(data, 0, len);
        }
        //处理
        System.out.println(sb.toString());
        sb.append("哈哈");
        fileReader.close();
        //输出
        FileWriter fileWriter = new FileWriter(file2);
        fileWriter.write(sb.toString());
        fileWriter.flush();
    }

    /**
     * 字符流复制文件
     *
     * @throws IOException
     */
    @Test
    public void test31() throws IOException {
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(new File("aa/cpaa.txt"));
        char[] data = new char[10];
        int len;
        while ((len = fileReader.read(data)) != -1) {
            fileWriter.write(data, 0, len);
        }
        fileWriter.flush();
        fileReader.close();
    }


    /**
     * 字节数组流
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //输入
        String str = "写代码一定要笑!";
        byte[] bytes = str.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        byteArrayInputStream.close();
        //输出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bytes);
        byteArrayOutputStream.writeTo(new FileOutputStream(file));
        byteArrayOutputStream.flush();
    }


    /**
     * BufferedInputStream 复制图片
     */
    @Test
    public void test2() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file3), 1024 * 2);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("aa/cp.jpg"));
        byte[] byteArray = new byte[1024];
        int len = -1;
        while ((len = bis.read(byteArray)) != -1) {
            bos.write(byteArray, 0, len);
            System.out.println("每次读取字节数量:" + len);
            System.out.println("文件中剩余字节数:" + bis.available());
        }
        bos.close();
        bis.close();
    }


    /**
     * 转换流编码解码
     *
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        //解码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("aa/gbkaa.txt"), "GBK");
        char[] data = new char[5];
        int len;
        while ((len = isr.read(data)) != -1) {
            osw.write(data, 0, len);
        }
        osw.close();
        isr.close();
    }

    @Test
    public void test5() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("aa/data.txt"));
        dos.writeInt(1);
        dos.writeBoolean(true);
        dos.writeByte(1);
        dos.close();
    }

    @Test
    public void test6() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("aa/data.txt"));
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readByte());
        dis.close();
    }


    /**
     * oos 对象序列化存储
     * @throws IOException
     */
    @Test
    public void test7() throws IOException {
        User user = new User();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aa/user.bat"));
        oos.writeObject(user);
        oos.close();
    }

    @Test
    public void test8() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aa/user.bat"));
        User user = (User)ois.readObject();
        System.out.println(user.getName());
    }

    @Test
    public void test9() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("aa/cp.jpg"), "r");
        RandomAccessFile waf = new RandomAccessFile("aa/cp2.jpg", "rw");
        byte [] b = new byte[1024];
        int len;
        while ((len = raf.read(b)) != -1){
            waf.write(b,0,len);
        }
        waf.close();
        raf.close();
    }

    @Test
    public void test10() throws IOException {
        RandomAccessFile r = new RandomAccessFile("aa/bb.txt", "rw");
        r.seek(4);
        r.write("1231".getBytes());
        r.close();
    }

}
