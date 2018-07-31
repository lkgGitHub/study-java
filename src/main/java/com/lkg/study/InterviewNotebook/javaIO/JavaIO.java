package com.lkg.study.InterviewNotebook.javaIO;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkg on 2018/7/31
 */
public class JavaIO {
	
	public static void main(String[] args) throws IOException {
//		List<File> files = listAllFiles(new File("D:\\tmp\\share\\upland\\lkg"));
//		files.forEach(System.out::println);

	}

	public static void fastCopy(String src, String dist) throws IOException{
		FileInputStream fin = new FileInputStream(src);      /* 获取源文件的输入字节流 */
		FileChannel fcin = fin.getChannel();                 /* 获取输入字节流的文件通道 */
		FileOutputStream fout = new FileOutputStream(dist);  /* 获取目标文件的输出字节流 */
		FileChannel fcout = fout.getChannel();               /* 获取输出字节流的通道 */
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024); /* 为缓冲区分配 1024 个字节 */
		while (true) {
			int r = fcin.read(buffer);                       /* 从输入通道中读取数据到缓冲区中 */
			if (r == -1) {                                   /* read() 返回 -1 表示 EOF */
				break;
			}
			buffer.flip();                                   /* 切换读写 */
			fcout.write(buffer);                             /* 把缓冲区的内容写入输出文件中 */
			buffer.clear();                                  /* 清空缓冲区 */
		}
	}

	/**
	 * 可以直接从 URL 中读取字节流数据。
	 * @throws IOException
	 */
	public static void readByUrl() throws IOException {
		URL url = new URL("http://www.baidu.com");
		// 字节流
		InputStream inputStream = url.openStream();
		// 字符流
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;
		while ((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}
		bufferedReader.close();
	}

	/**
	 * 递归地输出一个目录下所有文件
	 * @param file file
	 * @return list
	 */
	public static List<File> listAllFiles(File file){
		List<File> files = new ArrayList<>();
		if (file == null || !file.exists()){
			return null;
		}
		if (file.isFile()){
			files.add(file);
			return files;
		}
		for (File f: file.listFiles()){
			files.addAll(listAllFiles(f));
		}
		return files;
	}

	/**
	 * 使用字节流操作进行文件复制：
	 * @param src 待复制文件
	 * @param dist 复制后的文件路径
	 * @throws IOException IO异常
	 */
	public static void copyFile(String src, String dist) throws IOException {
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dist);

		byte[] buffer = new byte[1024 * 20];
		// read() 最多读取 buffer.length 个字节
		// 返回的是实际读取的个数
		// 返回 -1 的时候表示读到 eof，即文件尾
		while (in.read(buffer, 0, buffer.length) != -1){
			out.write(buffer);
		}

		in.close();
		out.close();
	}

	/**
	 * 逐行输出文本文件的内容：
	 * @param filePath 文件路径
	 * @throws IOException IO异常
	 */
	public static void readFileContent(String filePath) throws IOException {
		FileReader reader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		while ((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}

		// 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
		// 在调用 BufferedReader 的 close() 方法时会去调用 fileReader 的 close() 方法
		// 因此只要一个 close() 调用即可
		bufferedReader.close();
	}


}
