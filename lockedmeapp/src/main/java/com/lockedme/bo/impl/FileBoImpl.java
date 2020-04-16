package com.lockedme.bo.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lockedme.bo.FileBO;
import com.lockedme.exception.BussinessException;
import com.lockedme.model.Archive;

/**
 * 
 * @author Ricardo R. Rocha Filho
 *
 */
public class FileBoImpl implements FileBO {

	public List<String> getFileNamesAsc() throws BussinessException {

		File rootDirectory = new File("C://");

		FileFilter filter = new FileFilter() {

			public boolean accept(File pathname) {

				return pathname.exists();
			}
		};

		File[] listFiles = rootDirectory.listFiles(filter);

		List<String> listAllFiles = new ArrayList<String>(listFiles.length);

		for (File files : listFiles) {
			listAllFiles.add(files.getName());
		}

		Collections.sort(listAllFiles);

		return listAllFiles;
	}

	public boolean addFile(Archive archive, boolean isRoot) throws IOException, BussinessException {

		String path;

		validateArchive(archive, isRoot);

		if (isRoot == false) {
			path = archive.getRoot() + "//" + archive.getDirectory() + "//" + archive.getName() + "."
					+ archive.getExtension();
		} else {
			path = archive.getRoot() + "//" + archive.getName() + "." + archive.getExtension();
		}

		File file = new File(path);

		if (file.createNewFile()) {
			return true;
		} else {
			throw new IOException();
		}

	}

	public boolean deleteFile(Archive archive, boolean isRoot) throws IOException, BussinessException {

		String path = "";

		validateArchive(archive, isRoot);

		if (isRoot == false) {
			path = archive.getRoot() + "://" + archive.getDirectory() + "//" + archive.getName() + "."
					+ archive.getExtension();
		} else {
			path = archive.getRoot() + "//" + archive.getName() + "." + archive.getExtension();
		}

		File file = new File(path);

		if (file.delete()) {
			return true;
		} else {
			throw new IOException();
		}

	}

	public void searchFile(Archive archive) throws BussinessException {

	}

	public void validateArchive(Archive archive, boolean isRoot) throws BussinessException {
		if (archive == null) {
			throw new BussinessException("The path of the file cannot be empty");
		} else if (archive.getRoot() == null || archive.getRoot().isBlank()) {
			throw new BussinessException("The root of the file cannot be empty");
		} else if (isRoot == false) {
			if (archive.getDirectory() == null || archive.getDirectory().isBlank())
				throw new BussinessException("The directory of the file cannot be empty");
		} else if (archive.getName().isBlank()) {
			throw new BussinessException("The extension of the file cannot be empty");
		}
	}

	public File[] getRootList() throws IOException {
		return File.listRoots();

	}

	public File[] getDirectoryList() throws IOException {

		File file = new File("C://");

		FileFilter filter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		};

		return file.listFiles(filter);

	}

	public File[] getFilesInDirectoryList(Archive archive) throws IOException {

		File file = new File(archive.getRoot() + "://"+archive.getDirectory());

		FileFilter filter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.isFile();
			}
		};

		return file.listFiles(filter);

	}
}