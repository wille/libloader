package libloader;

import com.redpois0n.oslib.Arch;
import com.redpois0n.oslib.OperatingSystem;

public class Library {

	private OperatingSystem type;
	private Arch architecture;
	
	public Library(OperatingSystem type, Arch architecture) {
		this.type = type;
		this.architecture = architecture;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Library) {
			Library lib = (Library) o;
			
			return lib.type.equals(this.type) && lib.architecture.equals(this.architecture);
		}
		
		return this == o;
	}
}
