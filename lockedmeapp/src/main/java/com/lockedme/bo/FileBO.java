package com.lockedme.bo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.lockedme.exception.BussinessException;
import com.lockedme.model.Archive;

/**
 * 
 * @author Ricardo R. Rocha Filho
 *
 */
public interface FileBO {

	public List<String> getFileNamesAsc(String rootPath) throws BussinessException;

	public boolean addFile(Archive archive, boolean isRoot) throws IOException, BussinessException;
	
	public boolean deleteFile(Archive archive, boolean isRoot) throws IOException, BussinessException;
	
	public File[] searchFile(Archive archive,boolean isRoot) throws IOException, BussinessException;

	public File[] getRootList() throws IOException;
	
	public File[] getDirectoryList(Archive archive) throws IOException;
	
	public File[] getFilesInDirectoryList(Archive archive) throws IOException;
	
	public void validateArchive(Archive archive, boolean isRoot) throws BussinessException;
	
	public void validateRoot(Archive archive) throws BussinessException;

}