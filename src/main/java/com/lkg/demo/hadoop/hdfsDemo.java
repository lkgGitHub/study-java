package com.lkg.demo.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class hdfsDemo {

    public static void main(String[] args) throws Exception {
        Configuration conf=new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.2.89:8020");
        FileSystem hdfs = FileSystem.get(conf);
        Path path = new Path(args[1]);
        List<String> pathList = listFilesRecursive(hdfs, path);
        int total_count = 0;
        for (String p: pathList){
            total_count += count_lines(hdfs, new Path(p));
        }
    }


    private static int count_lines(FileSystem fs, Path path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(fs.open(path)));
        String line;
        int count = 0;
        System.err.println("===========================================================================");
        while (reader.readLine() != null) {
            count++;
        }
        System.err.println(count);
        System.err.println("===========================================================================");
        reader.close();
        return count;
    }


    /**
     * 递归查看目标文件夹下的所有文件
     */
    public static List<String> listFilesRecursive(FileSystem fileSystem, Path p) throws Exception {
        RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(p, true);
        List<String> pathList = new ArrayList<>();
        while (files.hasNext()) {
            LocatedFileStatus file = files.next();
            String isDir = file.isDirectory() ? "文件夹" : "文件";
            String permission = file.getPermission().toString();
            short replication = file.getReplication();
            long length = file.getLen();
            String path = file.getPath().toString();
            pathList.add(path);
            System.out.println(isDir + "\t" + permission
                    + "\t" + replication + "\t" + length
                    + "\t" + path
            );
        }
        return pathList;
    }

















    private static void count_string(FileSystem fs, String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(fs.open(new Path(path))));
        String line;
        System.err.println("===========================================================================");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.err.println("===========================================================================");
        reader.close();
    }

    private static void create_delete_file() throws IOException {
        // 1、创建Configuration对象
        Configuration conf=new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.136.128:8020");
        // 2、利用FileSystem 的静态get方法获取FileSystem 实例
        FileSystem hdfs = FileSystem.get(conf);
        // 3、调用FileSystem 的方法进行实际的文件操作
        hdfs.mkdirs(new Path("/aaa/bbb"));

        hdfs.deleteOnExit(new Path("/aaa/bbb"));
    }

    /***
     * 递归目录
     */
    public void diguiFiles() throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.default.name", "hdfs://192.168.136.128:9000/");
        FileSystem fileSystem = FileSystem.get(conf);
//        fileSystem.delete(new Path("/input/input2/"),true );
//       FileStatus [] fileStatuses=fileSystem.listStatus(new Path("/input"));

        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("/input/"), true);
        while (iterator.hasNext()) {
            LocatedFileStatus status = iterator.next();
            Path filePath = status.getPath();
            String fileName = filePath.getName();
            System.out.println(fileName);
        }
        System.out.println("---------------------------------");

        // listStatus 可以列出文件和文件夹的信息，但是不提供自带的递归遍历
        FileStatus[] listStatus = fileSystem.listStatus(new Path("/input"));
        recuersionFile(listStatus);
    }
    public void recuersionFile(FileStatus[] listStatus)throws Exception {
        if (listStatus != null) {
            for (FileStatus status : listStatus) {

                if (status.isDirectory()) {
                    Configuration conf = new Configuration();
                    conf.set("fs.default.name", "hdfs://192.168.136.128:9000/");
                    FileSystem fileSystem = FileSystem.get(conf);
                    FileStatus[] listStatus2 = fileSystem.listStatus(new Path(status.getPath().toString()));
                    recuersionFile(listStatus2);
                } else {
                    String name = status.getPath().getName();
                    System.out.println(status.getPath());
                    System.out.println("fileName: " + name);
                }
            }
        }
    }
}


//    /**
//     * 创建HDFS文件夹
//     */
//    @Test
//    public void mkdir() throws Exception {
//        fileSystem.mkdirs(new Path("/hdfsapi/test"));
//    }
//
//    /**
//     * 查看HDFS内容
//     */
//    @Test
//    public void text()throws Exception {
//        FSDataInputStream in = fileSystem.open(new Path("/cdh_version.properties"));
//        IOUtils.copyBytes(in, System.out, 1024);
//    }
//
//    /**
//     * 创建文件
//     */
//    @Test
//    public void create()throws Exception {
////        FSDataOutputStream out = fileSystem.create(new Path("/hdfsapi/test/a.txt"));
//        FSDataOutputStream out = fileSystem.create(new Path("/hdfsapi/test/b.txt"));
//        out.writeUTF("hello pk: replication 1");
//        out.flush();
//        out.close();
//    }
//
//    /**
//     * 测试文件名更改
//     * @throws Exception
//     */
//    @Test
//    public void rename() throws Exception {
//        Path oldPath = new Path("/hdfsapi/test/b.txt");
//        Path newPath = new Path("/hdfsapi/test/c.txt");
//        boolean result = fileSystem.rename(oldPath, newPath);
//        System.out.println(result);
//
//    }
//
//
//    /**
//     * 拷贝本地文件到HDFS文件系统
//     */
//    @Test
//    public void copyFromLocalFile() throws Exception {
//        Path src = new Path("/Users/rocky/data/hello.txt");
//        Path dst = new Path("/hdfsapi/test/");
//        fileSystem.copyFromLocalFile(src,dst);
//    }
//
//    /**
//     * 拷贝大文件到HDFS文件系统：带进度
//     */
//    @Test
//    public void copyFromLocalBigFile() throws Exception {
//
//        InputStream in = new BufferedInputStream(new FileInputStream(new File("/Users/rocky/tmp/software/jdk-8u91-linux-x64.tar.gz")));
//
//        FSDataOutputStream out = fileSystem.create(new Path("/hdfsapi/test/jdk.tgz"),
//                new Progressable() {
//                    public void progress() {
//                        System.out.print(".");
//                    }
//                });
//
//        IOUtils.copyBytes(in, out ,4096);
//
//    }
//
//    /**
//     * 拷贝HDFS文件到本地：下载
//     */
//    @Test
//    public void copyToLocalFile() throws Exception {
//        Path src = new Path("/hdfsapi/test/b.txt");
//        Path dst = new Path("/home/hadoop/software");
//        fileSystem.copyToLocalFile(src, dst);
//    }
//
//
//    /**
//     * 查看目标文件夹下的所有文件
//     */
//    @Test
//    public void listFiles() throws Exception {
//        FileStatus[] statuses = fileSystem.listStatus(new Path("/hdfsapi/test"));
//
//        for(FileStatus file : statuses) {
//            String isDir = file.isDirectory() ? "文件夹" : "文件";
//            String permission = file.getPermission().toString();
//            short replication = file.getReplication();
//            long length = file.getLen();
//            String path = file.getPath().toString();
//
//
//            System.out.println(isDir + "\t" + permission
//                    + "\t" + replication + "\t" + length
//                    + "\t" + path
//            );
//        }
//
//    }