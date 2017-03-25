package com.generator.res;

public class Test {

	private static final String SUPPORT_DIMESION = "800,480;960,540;1280,720;1920,1080;1280,400;1200,400;1280,720;2048,"
			+ "1536;1600,480;1280,480;854,480;480,272;800,432;1200,480;710,440;800,440;1920,480;980,400;1280,408;1280,352;1280,408;694,480;650,480;1184,384;1024,600;1024,720;";

	
	public static void main(String[] args) {
		DimenFilesGenerator generator = new DimenFilesGenerator(800, 480);
		generator.generateDimenFile(800, 480);
		generator.generateDpFile(920, 400);
	}

}
