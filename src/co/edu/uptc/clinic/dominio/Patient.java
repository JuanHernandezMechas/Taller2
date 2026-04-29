//Se cabmio temporalmente el nombre de la carpeta
package co.edu.uptc.clinic.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import co.edu.uptc.clinic.enums.IdentificationEnums;

/**
 * <b>Descripción </b> clase de modelo que representa la 
 * información del paciente <br>
 * 
 * @author JuanP_Mechas
 * */
public class Patient {
	/**Atributo Enumerativo que determina el tipo de documento de identidad*/
	private IdentificationEnums identificationEnums;
	/**Atributo númerico que determina el id del paciante*/
	private Long idPatient;
	/**Atributo alfanumerico que determina el nombre completo del paciente*/
	private String firstName;
	/**Atributo alfanumerico que determina los apellidos del paciente*/
	private String lastName;
	/**Atributo alfanumerico que ordena y guarda el correo del paciente*/
	private Set<String> email = new LinkedHashSet<String>();
	/**Atributo que ordena y guarda el historial de medicación recetada al paciente 
	 * en orden de inserción*/
	private Set<String> medicationHistory = new LinkedHashSet<String>();
	/**
	 * <b>Description: </b> Constructor vacío de la clase 
	 */
	public Patient() {
		super();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.email, this.medicationHistory);
	}
	/**
	 * <b>Description: </b> Constructor con los atributos de la clase
	 * @param identificationEnums
	 * @param idPatient
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param medicationHistory
	 */
	public Patient(IdentificationEnums identificationEnums, Long idPatient, String firstName, String lastName,
			Set<String> email, Set<String> medicationHistory) {
		super();
		this.identificationEnums = identificationEnums;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.medicationHistory = medicationHistory;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(email, other.email) && Objects.equals(medicationHistory, other.medicationHistory);
	}
	/**
	 * @return the idPatient
	 */
	public Long getIdPatient() {
		return idPatient;
	}
	/**
	 * @param idPatient the idPatient to set
	 */
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public Set<String> getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(Set<String> email) {
		this.email = email;
	}
	/**
	 * @return the medicationHistory
	 */
	public Set<String> getMedicationHistory() {
		return medicationHistory;
	}
	
	/**
	 * @param medicationHistory the medicationHistory to set
	 */
	public void setMedicationHistory(Set<String> medicationHistory) {
		this.medicationHistory = medicationHistory;
	}
	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", medicationHistory=" + medicationHistory + "]";
	}
	
}
