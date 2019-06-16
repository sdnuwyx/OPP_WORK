package DB;

import java.io.File;

import jxl.*;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import java.sql.*;
import java.util.*;

public class DBtoExcel {

	public void WriteExcel(ResultSet rs, String filePath, String sheetName, Vector columnName) {
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		int rowNum = 1; // 从第一行开始写入
		try {
			workbook = Workbook.createWorkbook(new File(filePath)); // 创建Excel文件
			sheet = workbook.createSheet(sheetName, 0); // 创建名为 sheetName 的工作簿

			this.writeCol(sheet, columnName, 0); // 首先将列名写入
			// 将结果集写入
			while (rs.next()) {
				Vector col = new Vector(); // 用以保存一行数据
				 System.out.println(columnName.size());
				for (int i = 1; i <= columnName.size(); i++) { // 将一行内容保存在col中
					col.add(rs.getString(i));

				}
				// 写入Excel
				this.writeCol(sheet, col, rowNum++);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				workbook.write();
				workbook.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
	private void writeCol(WritableSheet sheet, Vector col, int rowNum) throws RowsExceededException, WriteException {
		int size = col.size(); // 获取集合大小

		for (int i = 0; i < size; i++) { // 写入每一列
			Label label = new Label(i, rowNum, (String) col.get(i));
			sheet.addCell(label);
		}
	}
}
