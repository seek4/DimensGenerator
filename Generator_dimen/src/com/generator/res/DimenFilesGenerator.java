package com.generator.res;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DimenFilesGenerator {

	// public class ScreenDimen {
	// public int width = 0;
	// public int height = 0;
	// }
	//
	// public class ScreenDp {
	// public int width = 0;
	// public int height = 0;
	// }

	private static final String DIR_RES = "./res";
	
	private int mStandardDimenWidth = 0;
	private int mStandardDimenHeight = 0;
	private final static String WTemplateDimen = "<dimen name=\"x{0}\">{1}px</dimen>\n";
	private final static String HTemplateDimen = "<dimen name=\"y{0}\">{1}px</dimen>\n";
	private final static String DIR_TEMPLATE_DIMEN = "values-{0}x{1}";

	/**
	 * 会把基准dp px都设置为传进来的值
	 * @param width
	 * @param height
	 */
	public DimenFilesGenerator(int width, int height) {
		this.mStandardDimenWidth = width;
		this.mStandardDimenHeight = height;
		this.mStandardDpWidth = width;
		this.mStandardDpHeight = height;
	}

	public void setStandardDimen(int width, int height) {
		this.mStandardDimenHeight = height;
		this.mStandardDimenWidth = width;
	}

	private int mStandardDpWidth = 0;
	private int mStandardDpHeight = 0;
	private final static String WTemplateDp = "<dimen name=\"x{0}\">{1}dp</dimen>\n";
	private final static String HTemplateDp = "<dimen name=\"y{0}\">{1}dp</dimen>\n";
	private final static String DIR_TEMPLATE_DP = "values-w{0}dpxh{1}dp";
	public void setStandardDp(int width, int height) {
		this.mStandardDpWidth = width;
		this.mStandardDpHeight = height;
	}

	public float change(float a) {
		int temp = (int) (a * 100);
		return temp / 100f;
	}
	
	public void generateDimenFile(int w, int h) {
		if (mStandardDimenHeight == 0 || mStandardDimenWidth == 0) {
			return;
		}
		File resDir = new File(DIR_RES);
		if(!resDir.exists()){
			resDir.mkdir();
		}
		StringBuffer sbForWidth = new StringBuffer();
		sbForWidth.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sbForWidth.append("<resources>\n");
		float cellw = w * 1.0f / mStandardDimenWidth;

		System.out.println("width : " + w + "," + mStandardDimenWidth + "," + cellw);
		for (int i = 1; i < mStandardDimenWidth; i++) {
			sbForWidth.append(WTemplateDimen.replace("{0}", i + "").replace("{1}", change(cellw * i) + ""));
		}
		sbForWidth.append(WTemplateDimen.replace("{0}", mStandardDimenWidth + "").replace("{1}", w + ""));
		sbForWidth.append("</resources>");

		StringBuffer sbForHeight = new StringBuffer();
		sbForHeight.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sbForHeight.append("<resources>\n");
		float cellh = h * 1.0f / mStandardDimenHeight;
		System.out.println("height : " + h + "," + mStandardDimenHeight + "," + cellh);
		for (int i = 1; i < mStandardDimenHeight; i++) {
			sbForHeight.append(HTemplateDimen.replace("{0}", i + "").replace("{1}", change(cellh * i) + ""));
		}
		sbForHeight.append(HTemplateDimen.replace("{0}", mStandardDimenHeight + "").replace("{1}", h + ""));
		sbForHeight.append("</resources>");


		File fileDir = new File(DIR_RES + File.separator + DIR_TEMPLATE_DIMEN.replace("{0}", w + "")//
				.replace("{1}", h + ""));
		fileDir.mkdir();

		File layxFile = new File(fileDir.getAbsolutePath(), "lay_x.xml");
		File layyFile = new File(fileDir.getAbsolutePath(), "lay_y.xml");
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(layxFile));
			pw.print(sbForWidth.toString());
			pw.close();
			pw = new PrintWriter(new FileOutputStream(layyFile));
			pw.print(sbForHeight.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void generateDpFile(int w, int h) {
		if (mStandardDpHeight == 0 || mStandardDpWidth == 0) {
			return;
		}
		File resDir = new File(DIR_RES);
		if(!resDir.exists()){
			resDir.mkdir();
		}
		StringBuffer sbForWidth = new StringBuffer();
		sbForWidth.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sbForWidth.append("<resources>\n");
		float cellw = w * 1.0f / mStandardDpWidth;

		System.out.println("width : " + w + "," + mStandardDpWidth + "," + cellw);
		for (int i = 1; i < mStandardDpWidth; i++) {
			sbForWidth.append(WTemplateDp.replace("{0}", i + "").replace("{1}", change(cellw * i) + ""));
		}
		sbForWidth.append(WTemplateDp.replace("{0}", mStandardDpWidth + "").replace("{1}", w + ""));
		sbForWidth.append("</resources>");

		StringBuffer sbForHeight = new StringBuffer();
		sbForHeight.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sbForHeight.append("<resources>\n");
		float cellh = h * 1.0f / mStandardDpHeight;
		System.out.println("height : " + h + "," + mStandardDpHeight + "," + cellh);
		for (int i = 1; i < mStandardDpHeight; i++) {
			sbForHeight.append(HTemplateDp.replace("{0}", i + "").replace("{1}", change(cellh * i) + ""));
		}
		sbForHeight.append(HTemplateDp.replace("{0}", mStandardDpHeight + "").replace("{1}", h + ""));
		sbForHeight.append("</resources>");


		File fileDir = new File(DIR_RES + File.separator + DIR_TEMPLATE_DP.replace("{0}", w + "")//
				.replace("{1}", h + ""));
		fileDir.mkdir();

		File layxFile = new File(fileDir.getAbsolutePath(), "lay_x.xml");
		File layyFile = new File(fileDir.getAbsolutePath(), "lay_y.xml");
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(layxFile));
			pw.print(sbForWidth.toString());
			pw.close();
			pw = new PrintWriter(new FileOutputStream(layyFile));
			pw.print(sbForHeight.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
