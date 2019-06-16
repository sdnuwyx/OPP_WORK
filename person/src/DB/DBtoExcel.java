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
		int rowNum = 1; // �ӵ�һ�п�ʼд��
		try {
			workbook = Workbook.createWorkbook(new File(filePath)); // ����Excel�ļ�
			sheet = workbook.createSheet(sheetName, 0); // ������Ϊ sheetName �Ĺ�����

			this.writeCol(sheet, columnName, 0); // ���Ƚ�����д��
			// �������д��
			while (rs.next()) {
				Vector col = new Vector(); // ���Ա���һ������
				 System.out.println(columnName.size());
				for (int i = 1; i <= columnName.size(); i++) { // ��һ�����ݱ�����col��
					col.add(rs.getString(i));

				}
				// д��Excel
				this.writeCol(sheet, col, rowNum++);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر�
				workbook.write();
				workbook.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
	private void writeCol(WritableSheet sheet, Vector col, int rowNum) throws RowsExceededException, WriteException {
		int size = col.size(); // ��ȡ���ϴ�С

		for (int i = 0; i < size; i++) { // д��ÿһ��
			Label label = new Label(i, rowNum, (String) col.get(i));
			sheet.addCell(label);
		}
	}
}