package com.iu.main.file;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.iu.main.Mytest;

public class FileTest extends Mytest{

	@Test
	public void test() {
		File file = new File("C:\\study\\study.txt");
		
		System.out.println(file.exists());
		System.out.println(file.isFile());
		file = new File("C:\\study", "study,txt");
		
		file = new File("c:\\study");
		System.out.println(file.exists());
		
		file = new File("c:\\study");
		
	}

}
