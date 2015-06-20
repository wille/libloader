package libloader;

import java.io.File;

import com.redpois0n.oslib.Arch;
import com.redpois0n.oslib.OperatingSystem;

/**
 * Load library from {@link java.io#File} path
 */
public class FileLibrary extends Library {
	
	public FileLibrary(String file, OperatingSystem type, Arch architecture) {
		super(file, type, architecture);
	}
		
	public FileLibrary(File file, OperatingSystem type, Arch architecture) {
		super(file.getAbsolutePath(), type, architecture);
	}

	@Override
	public void load() {
		System.load(path);
	}

}
