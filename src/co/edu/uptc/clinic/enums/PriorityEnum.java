package co.edu.uptc.clinic.enums;

public enum PriorityEnum {
	LOW (0), MEDIUM (1), HIGH(2), CRITICAL(3);

	private int level;

	PriorityEnum(int level) {
		this.level= level;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

}
