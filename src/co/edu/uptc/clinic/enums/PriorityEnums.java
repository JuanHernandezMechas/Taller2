package co.edu.uptc.clinic.enums;

public enum PriorityEnums {
	LOW (0), MEDIUM (1), HIGH(2), CRITICAL(3);

	private int Level;

	PriorityEnums(int Level) {
		this.Level= Level;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return Level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		Level = level;
	}
	
}
