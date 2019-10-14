package testDataGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automation.utilities.DriverInitialization;
import com.aventstack.extentreports.Status;

public class ReadTestData {

	static Map<String, String> data = new HashMap<String, String>();

	public static int rows = 0;
	public static int cols = 0;
	public static String key = null;
	public static String value = null;
	public static String cTestCaseName = null;

	public static File file = null;
	public static FileInputStream fin = null;
	public static XSSFWorkbook wb = null;
	public static XSSFSheet sh = null;

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println(getData("Data", "TC002")); }
	 */

	public static Map<String, String> getData(String sheetName, String testCaseName) {

		try {
			file = new File(System.getProperty("user.dir") + "//TestData//TestData.xlsx");
			fin = new FileInputStream(file);
			wb = new XSSFWorkbook(fin);
			sh = wb.getSheet(sheetName);
			rows = sh.getLastRowNum() - sh.getFirstRowNum();
			cols = sh.getRow(0).getLastCellNum();

			for (int i = 1; i <= rows; i++) {

				cTestCaseName = sh.getRow(i).getCell(0).getStringCellValue();

				if (cTestCaseName != null || !cTestCaseName.isEmpty() || testCaseName != null) {

					if (cTestCaseName.equals(testCaseName)) {

						for (int j = 1; j <cols; j++) {

							key = sh.getRow(0).getCell(j).getStringCellValue();

							if (sh.getRow(i).getCell(j) != null) {

								if (sh.getRow(i).getCell(j).getCellType() == CellType.STRING) {

									value = sh.getRow(i).getCell(j).getStringCellValue();

								} else if (sh.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {

									value = String.valueOf(sh.getRow(i).getCell(j).getNumericCellValue());

								} else {

									value = sh.getRow(i).getCell(j).getRawValue();
								}
							}

							data.put(key, value);
						}

					} else {

						// logger.log(Status.ERROR, "There is not Mathing Test Case Name Available in
						// the Sheet");
					}
				} else {

					// logger.log(Status.ERROR, "Please Provide valid TestCasename "+cTestCaseName+
					// " "+testCaseName);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
