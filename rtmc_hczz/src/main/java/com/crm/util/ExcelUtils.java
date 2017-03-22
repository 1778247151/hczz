package com.crm.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.thoughtworks.xstream.core.util.Fields;

/**
 * 操作Excel工具类
 * 
 * @date 2016-06-28
 * @author xiangtao
 */
public class ExcelUtils {
	private ExcelUtils() {
	}

	private static ExcelUtils instance = null;

	public static ExcelUtils getInstance() {
		if (instance == null) {
			instance = new ExcelUtils();
		}
		return instance;
	}

	public static void main(String[] args) {
		Pojo p = new Pojo();
		p.setAge(11);
		p.setName("张三");
		p.setTime(new Date().getTime());
		List<Pojo> list = new ArrayList<Pojo>();
		list.add(p);

		// export("测试", "", list);
	}

	public static <T> void export(String sheetName, String path, List<T> list, String[] columnArr, String[] attrArr)
			throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		// 创建标题 行
		for (int i = 0; i < columnArr.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(columnArr[i]);
			cell.setCellStyle(style);
		}

		// 遍历list创建数据行
		int rowNum = 1;
		for (T t : list) {
			HSSFRow DataRow = sheet.createRow(rowNum);

			if (Map.class.isAssignableFrom(t.getClass())) {

			} else if (String.class.isAssignableFrom(t.getClass()) || Number.class.isAssignableFrom(t.getClass())) {

			} else {
				for (int i = 0; i < attrArr.length; i++) {
					Field f;
					Object fvalue;
					f = t.getClass().getDeclaredField(attrArr[i]);
					f.setAccessible(true);
					fvalue = f.get(t);
					if (fvalue != null) {
						HSSFCell cell = DataRow.createCell(i);
						if (String.class.isAssignableFrom(f.getType())) {
							cell.setCellValue((String) fvalue);
						} else if (Integer.class.isAssignableFrom(f.getType())) {
							cell.setCellValue((int) fvalue);
						} else if (Double.class.isAssignableFrom(f.getType())) {
							cell.setCellValue((double) fvalue);
						} else if (Long.class.isAssignableFrom(f.getType())) {
							cell.setCellValue((long) fvalue);
						} else if (Date.class.isAssignableFrom(f.getType())) {
							cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format((Date) fvalue));
						}
						cell.setCellStyle(style);
					}
				}
			}
			rowNum++;
		}

		//写入磁盘
		FileOutputStream fout = new FileOutputStream(path/* "E:/students.xls" */);
		wb.write(fout);
		fout.close();
	}
}
