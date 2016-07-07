package libloader;

import java.io.File;

import oslib.Arch;
import oslib.OperatingSystem;

/**
 * Load library from {@link java.io#File} path
 */
public class FileLibrary extends Library {
	
	public FileLibrary(String file, OperatingSystem type, Arch architecture) {
		this(new File(file), type, architecture);
	}
		
	public FileLibrary(File file, OperatingSystem type, Arch architecture) {
		super(file.getAbsolutePath(), type, architecture);
	}

	@Override
	public void load() throws Exception {
		System.load(path);
	}

}
