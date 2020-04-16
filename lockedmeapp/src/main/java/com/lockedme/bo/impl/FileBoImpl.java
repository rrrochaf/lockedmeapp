package com.lockedme.bo.impl;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import com.lockedme.bo.FileBO;
import com.lockedme.exception.BussinessException;

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

		return listAllFiles;
	}

}
