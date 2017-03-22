package com.crm.util;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 文件保存， 读 写文件， 目录的创建，删除等
 * 
 * 
 */
public class FileUtil {

	/**
	 * 另存为文件
	 * 
	 * @param stream
	 * @param filepath
	 * @throws IOException
	 */
	public static void saveAsFromInputStream(InputStream stream, String filepath) {
		FileOutputStream fs = null;

		try {
			fs = new FileOutputStream(filepath);
			byte[] buffer = new byte[1024 * 1024];
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = stream.read(buffer)) != -1) {
				bytesum += byteread;
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
		} catch (Exception e) {
			System.out.println("保存文件操作出错:" + e.getMessage());
		} finally {
			try {
				if (fs != null) {
					fs.close();
				}
			} catch (IOException e) {
				System.out.println("关闭FileOutputStream时出错:" + e.getMessage());
			}
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				System.out.println("关闭InputStream时出错:" + e.getMessage());
			}
		}
	}

	/**
	 * uniqueName == null 则获取随机文件名 或者 uniqueName.gif
	 * isGenerateRandomFile为是否自动生成文件名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getRandomOrCurrentFileName(String uniqueName,String filename) {
		String ext = "";

		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > 0) && (i < (filename.length() - 1))) {
				ext = filename.substring(i + 1);
				if (ext != null) {
					ext = ext.toLowerCase();
				}
			}else{
				return "none";
			}
		}
		if(!CommonUtil.isImgFile(ext)){	//不是图片类型
			return "none";
		}

		if (uniqueName == null) {
			// 获得当前时间
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			// 转换为字符串
			String formatDate = format.format(new Date());
			// 随机生成文件编号
			int random = new Random().nextInt(10000);

			return new StringBuffer().append(formatDate).append(random).append(
					".").append(ext).toString();
		} else {
			return new StringBuffer().append(uniqueName).append(".")
					.append(ext).toString();
		}

	}

	public static Icon getFixedBoundIcon(String filePath, int height, int width) throws Exception {
		double ratio = 0.0;
		File file = new File(filePath);
		if (!file.isFile()) {
			throw new Exception(file + " is not image file error in getFixedBoundIcon!");
		}
		Icon ret = new ImageIcon(filePath);
		BufferedImage bi = ImageIO.read(file);
		if (bi.getHeight() > height || bi.getWidth() > width) {
			if (bi.getHeight() > bi.getWidth()) {
				ratio = (new Integer(height)).doubleValue() / bi.getHeight();
			} else {
				ratio = (new Integer(width)).doubleValue() / bi.getWidth();
			}
			int lastLength = filePath.lastIndexOf(".");
			String subFilePath = filePath.substring(0, lastLength);
			String fileType = filePath.substring(lastLength);
			File zoomFile = new File(subFilePath + fileType);
			Image temp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
			AffineTransformOp op = new AffineTransformOp(AffineTransform
					.getScaleInstance(ratio, ratio), null);
			temp = op.filter(bi, null);
			ImageIO.write((BufferedImage) temp, "jpg", zoomFile);
			ret = new ImageIcon(zoomFile.getPath());
		}
		return ret;
	}

	/**
	 * 强制用UTF-8 编码读 整个系统编码采用utf-8
	 * 
	 * @param filePathAndName
	 * @return
	 */
	public static String readTxt(String filePathAndName) {
		return readTxt(filePathAndName, "UTF-8");
	}

	/**
	 * 读取文本文件内容
	 * 
	 */
	public static String readTxt(String filePathAndName, String encoding) {
		encoding = encoding.trim();
		StringBuffer str = new StringBuffer("");
		String st = "";
		try {
			FileInputStream fs = new FileInputStream(filePathAndName);
			InputStreamReader isr;
			if (encoding.equals("")) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}
			BufferedReader br = new BufferedReader(isr);
			try {
				String data = "";
				while ((data = br.readLine()) != null) {
					str.append(data + " ");
				}
			} catch (Exception e) {
				str.append(e.toString());
			}
			st = str.toString();
		} catch (IOException es) {
			st = "";
		}
		return st;
	}

	/**
	 * 强制用UTF-8 编码保存 避免因为操作系统不同而编码不同。
	 * 
	 * @param path
	 * @param filename
	 * @param fileContent
	 */
	public static void writeTxt(String path, String filename, String fileContent) {
		writeTxt(path, filename, fileContent, "UTF-8");

	}

	/**
	 * 有编码方式的文件创建
	 */
	public static void writeTxt(String path, String filename,
			String fileContent, String encoding) {

		try {
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			file = new File(path + filename);
			PrintWriter pwrite = null;
			if (encoding != null && !"".equals(encoding)) {
				pwrite = new PrintWriter(file, encoding);
			} else {
				pwrite = new PrintWriter(file);
			}
			pwrite.println(fileContent);
			pwrite.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 拷贝目录树 把一个目录下的所有东西包括子目录 同时拷贝到 另外一个目录
	 * 
	 * @param sourceDir
	 * @param targetDir
	 * @throws Exception
	 */
	public static void copyDir(String sourceDir, String targetDir)
			throws Exception {
		String url1 = sourceDir;
		String url2 = targetDir;
		if (!(new File(url2)).exists()) {
			(new File(url2)).mkdirs();
		}
		File[] file = (new File(url1)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				file[i].toString();
				FileInputStream input = new FileInputStream(file[i]);
				FileOutputStream output = new FileOutputStream(url2
						+ System.getProperty("file.separator")
						+ (file[i].getName()).toString());
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				output.close();
				input.close();
			} else if (file[i].isDirectory()) {
				String url_2_dir = url2 + System.getProperty("file.separator")
						+ file[i].getName();
				copyDir(file[i].getPath(), url_2_dir);
			}
		}
	}

	/**
	 * 新建目录
	 * 
	 * @param folderPath
	 *            目录
	 * @return 返回目录创建后的路径
	 */
	public static String createFolder(String folderPath) {
		String txt = folderPath;
		try {
			java.io.File myFilePath = new java.io.File(txt);
			txt = folderPath;
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
			}
		} catch (Exception e) {
			System.out.println("创建目录操作出错:" + e.getMessage());
		}
		return txt;
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @return Boolean 成功删除返回true遭遇异常返回false
	 */
	public static boolean delFile(String filePathAndName) {
		boolean bea = false;
		try {
			String filePath = filePathAndName;
			File myDelFile = new File(filePath);
			if (myDelFile.exists()) {
				myDelFile.delete();
				bea = true;
			}
		} catch (Exception e) {
			System.out.println("删除文件操作出错:" + e.getMessage());
		}
		return bea;
	}

	/**
	 * 删除文件夹
	 * 
	 * @param folderPath
	 *            文件夹完整绝对路径
	 * @return
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			System.out.println("删除文件夹操作出错:" + e.getMessage());
		}
	}

	/**
	 * 删除指定文件夹下所有文件
	 * 
	 * @param path
	 *            文件夹完整绝对路径
	 * @return
	 * @return
	 */
	public static boolean delAllFile(String path) {
		boolean bea = false;
		File file = new File(path);
		if (!file.exists()) {
			return bea;
		}
		if (!file.isDirectory()) {
			return bea;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPathFile
	 *            准备复制的文件源
	 * @param newPathFile
	 *            拷贝到新绝对路径带文件名
	 * @return
	 */
	public static void copyFile(String oldPathFile, String newPathFile) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPathFile); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPathFile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					// //System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错:" + e.getMessage());
		}
	}

	/**
	 * 移动文件
	 * 
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 移动目录
	 * 
	 * @param oldPath
	 * @param newPath
	 * @return
	 * @throws Exception
	 */
	public static void moveFolder(String sourceDir, String targetDir)
			throws Exception {
		copyDir(sourceDir, targetDir);
		delFolder(sourceDir);
	}

}