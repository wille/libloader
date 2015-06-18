package libloader;

import com.redpois0n.oslib.Arch;
import com.redpois0n.oslib.OperatingSystem;

public abstract class Library {

	protected String path;
	
	private OperatingSystem type;
	private Arch architecture;
	
	public Library(String path, OperatingSystem type, Arch architecture) {
		this.path = path;
		this.type = type;
		this.architecture = architecture;
	}
	
	public abstract void load();
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Library) {
			Library lib = (Library) o;
			
			return lib.type.equals(this.type) && lib.architecture.equals(this.architecture);
		}
		
		return this == o;
	}
}
