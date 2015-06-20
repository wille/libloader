package libloader;

import java.util.ArrayList;
import java.util.List;

import com.redpois0n.oslib.Arch;
import com.redpois0n.oslib.OperatingSystem;

public class GlobalLibraries {
	
	private static final List<Library> LIBRARIES = new ArrayList<Library>();
	
	public static void addLibrary(Library lib) {
		LIBRARIES.add(lib);
	}
	
	public static void loadLibraries() {
		OperatingSystem type = OperatingSystem.getOperatingSystem().getType();
		Arch architecture = Arch.getArch();
		
		for (Library lib : LIBRARIES) {
			if (lib.getOperatingSystem() == type && lib.getArchitecture() == architecture) {
				
			}
		}
	}
}
