package co.edu.uptc.clinic.enums;

public enum IdentificationEnum {
	CC("Cédula de ciudadanía"), TI ("Tarjeta de identidad"), CE ("Cédula de extranjería"), PA("Pasaporte");
	private final String OfficialName;
	private IdentificationEnum(String OfficialName) {
		this.OfficialName = OfficialName; 
	}
	/**
	 * Método encargado de retornar el valor de officialName.
	 *
	 * @return valor de officialName
	 */
	public String getOfficialName() {
		return OfficialName;
	}
}
