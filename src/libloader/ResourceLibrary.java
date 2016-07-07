package libloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import oslib.Arch;
import oslib.OperatingSystem;

/**
 * Load library from resource
 */
public class ResourceLibrary extends Library {
	
	public ResourceLibrary(String res, OperatingSystem type, Arch architecture) {
		super(res, type, architecture);
	}

	/**
	 * Write resource to temporary file, and load it
	 */
	@Override
	public void load() throws Exception {
		System.out.println("Loading " + path);
		InputStream in = ResourceLibrary.class.getResourceAsStream(path);
		
		String name = path;
		
		if (path.contains("/")) {
			name = path.substring(path.lastIndexOf("/") + 1, path.length());
		}
		
		File temp = File.createTempFile(name, ".dat");
		FileOutputStream fos = new FileOutputStream(temp);
		byte[] buffer = new byte[1024];
		int read;
		
		while ((read = in.read(buffer)) != -1) {
			fos.write(buffer, 0, read);
		}
		
		in.close();
		fos.close();
		
		System.load(temp.getAbsolutePath());
		
		temp.deleteOnExit();
	}

}
