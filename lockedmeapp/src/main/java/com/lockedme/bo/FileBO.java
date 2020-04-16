package com.lockedme.bo;

import java.util.List;

import com.lockedme.exception.BussinessException;
import com.lockedme.model.Archive;

/**
 * 
 * @author Ricardo R. Rocha Filho
 *
 */
public interface FileBO {
	
	public List<String> getFileNamesAsc() throws BussinessException;
}
