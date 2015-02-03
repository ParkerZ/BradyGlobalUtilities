package utilityClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileList {

	private static String folderPath = "InfoFiles/";
	private static ArrayList<String> wordList = new ArrayList<String>();

	public static void main(String[] args) {

	}

	public FileList(String fileName) {
		// TODO Auto-generated constructor stub
		setFileList(fileName);
	}

	public static String checkFileName(String fileName) {

		if (fileName.indexOf('.') == -1) {

			fileName = fileName.concat(".txt");
		}
		return fileName;

	}

	public static String getFilePath(String fileName) {

		return folderPath + fileName;

	}

	public static ArrayList<String> setFileList(String fileName) {

		String filePath = getFilePath(fileName);
		ArrayList<String> wordList = new ArrayList<String>();
		Scanner input;
		try {
			input = new Scanner(new File(filePath));
			while (input.hasNext()) {
				wordList.add(input.next());
			}
			input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return wordList;

	}

	public static void writeToFile(String fileName) {

		PrintWriter fileWriter;
		String filePath = getFilePath(fileName);
		try {
			fileWriter = new PrintWriter(new FileWriter(filePath));

			for (String line : wordList) {

				fileWriter.println(line);

			}

			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeToFile(String fileName, String newLine) {

		PrintWriter fileWriter;
		String filePath = getFilePath(fileName);
		wordList.add(newLine);

		try {
			fileWriter = new PrintWriter(new FileWriter(filePath));

			for (String line : wordList) {

				fileWriter.println(line);

			}

			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeToFile(String fileName, ArrayList<String> newLine) {

		PrintWriter fileWriter;
		String filePath = getFilePath(fileName);
		wordList.addAll(newLine);

		try {
			fileWriter = new PrintWriter(new FileWriter(filePath));

			for (String line : wordList) {

				fileWriter.println(line);

			}

			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String[] get() {

		return getArray();
	}

	public static String[] getArray() {

		String[] list = new String[wordList.size()];
		wordList.toArray(list);

		return list;
	}

	public static ArrayList<String> getFileList() {

		return wordList;
	}

}
