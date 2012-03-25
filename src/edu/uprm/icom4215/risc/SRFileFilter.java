package edu.uprm.icom4215.risc;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class SRFileFilter extends FileFilter {
	private final static String txt = "txt";
	private final static String sr = "sr";
	
	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
            return true;
        }

        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equals(txt) ||
            	extension.equals(sr)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
	}
	
	 /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

	@Override
	public String getDescription() {
		return ".txt, .sr";
	}

}
