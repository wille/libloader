package libloader;

import java.util.ArrayList;
import java.util.List;

public class GlobalLibraries {
	
	private static final List<Library> LIBRARIES = new ArrayList<Library>();
	
	public static void addLibrary(Library lib) {
		LIBRARIES.add(lib);
	}
	
	public static void loadLibraries() {		
		for (Library lib : LIBRARIES) {
			if (lib.isLoadable()) {
				try {
					lib.load();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
