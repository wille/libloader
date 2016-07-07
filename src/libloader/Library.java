package libloader;

import oslib.Arch;
import oslib.OperatingSystem;

public abstract class Library {

	protected String path;
	
	private boolean loaded;
	
	private OperatingSystem type;
	private Arch architecture;
	
	public Library(String path, OperatingSystem type, Arch architecture) {
		this.path = path;
		this.type = type;
		this.architecture = architecture;
	}
	
	public abstract void load() throws Exception;
	
	public OperatingSystem getOperatingSystem() {
		return this.type;
	}
	
	public Arch getArchitecture() {
		return this.architecture;
	}
	
	@Override
	public final boolean equals(Object o) {
		if (o instanceof Library) {
			Library lib = (Library) o;
			
			return lib.type.equals(this.type) && lib.architecture.equals(this.architecture);
		}
		
		return this == o;
	}
	
	/**
	 * If this library is loadable on this operating system and architecture
	 * @return
	 */
	public final boolean isLoadable() {
		OperatingSystem type = OperatingSystem.getOperatingSystem().getType();
		Arch architecture = Arch.getArch();
		
		return this.type == type && this.architecture == architecture;
	}
	
	public final boolean isLoaded() {
		return this.loaded;
	}
	
	public final void setLoaded(boolean b) {
		this.loaded = b;
	}
}
