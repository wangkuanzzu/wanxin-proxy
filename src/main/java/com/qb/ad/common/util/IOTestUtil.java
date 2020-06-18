package com.qb.ad.common.util;

import java.io.FileReader;
import java.io.IOException;

public class IOTestUtil {

	public static void main(String[] args) {
		fileReader();
	}

	public static void fileReader() {
		FileReader fileReader = null;
		// 获取文件流
		try {
			fileReader = new FileReader("D:/佩恩六道/登场/地狱道.txt");
			char[] a = new char[1024];
			int ch = 0;
			// 判断是否读取到文件末尾
			while ((ch = fileReader.read(a)) != -1) {
				System.out.println(new String(a, 0, ch));
			}
		} catch (IOException e) {
			System.err.println("读取文件异常");
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.err.println("关闭读取流异常");
			}
		}
	}
}
