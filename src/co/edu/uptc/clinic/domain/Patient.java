//Se cabmio temporalmente el nombre de la carpeta
package co.edu.uptc.clinic.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import co.edu.uptc.clinic.enums.IdentificationEnum;
import co.edu.uptc.clinic.enums.PriorityEnum;

/**
 * <b>Descripción </b> clase de modelo que representa la 
 * información del paciente <br>
 * 
 * @author JuanP_Mechas
 * */
public class Patient {
	/**
	 * Atributo Enumerativo que determina el nivel de prioridad de atencion*/
	private PriorityEnum priorityEnums;
	/**Atributo Enumerativo que determina el tipo de documento de identidad*/
	private IdentificationEnum identificationEnums;
	/**Atributo númerico que determina el id del paciante*/
	private Integer idPatient;
	/**Atributo alfanumerico que determina el nombre completo del paciente*/
	private String firstName;
	/**Atributo alfanumerico que determina los apellidos del paciente*/
	private String lastName;
	/**Atributo alfanumerico que ordena y guarda el correo del paciente*/
	private String email;
	/**Atributo que ordena y guarda el historial de medicación recetada al paciente 
	 * en orden de inserción*/
	private Set<String> medicationHistory = new LinkedHashSet<String>();
	/**
	 * <b>Description: </b> Constructor vacío de la clase 
	 */
	public Patient() {
		super();
	}
	/**
	 * Crea una nueva instancia de Patient.
	 *
	 * @param priorityEnums
	 * @param identificationEnums
	 * @param idPatient
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param medicationHistory Parámetro que determina
	 */
	public Patient(PriorityEnum priorityEnums, IdentificationEnum identificationEnums, Integer idPatient,
			String firstName, String lastName, String email, Set<String> medicationHistory) {
		super();
		this.priorityEnums = priorityEnums;
		this.identificationEnums = identificationEnums;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.medicationHistory = medicationHistory;
	}
	/**
	 * <b>Description: </b>Método encargado de retornar el valor de priorityEnums.
	 *
	 * @return valor de priorityEnums
	 */
	public PriorityEnum getPriorityEnums() {
		return priorityEnums;
	}
	/**
	 *<b>Description: </b>Método encargado de asignar el valor de priorityEnums.
	 * @param priorityEnums nuevo valor de priorityEnums
	 */
	public void setPriorityEnums(PriorityEnum priorityEnums) {
		this.priorityEnums = priorityEnums;
	}
	/**
	 * <b>Description: </b>Método encargado de retornar el valor de identificationEnums.
	 * @return valor de identificationEnums*/
	public IdentificationEnum getIdentificationEnums() {
		return identificationEnums;
	}
	/**
	 * <b>Description: </b>Método encargado de establecer el valor de identificationEnums.
	 *
	 * @param identificationEnums nuevo valor de identificationEnums
	 */
	public void setIdentificationEnums(IdentificationEnum identificationEnums) {
		this.identificationEnums = identificationEnums;
	}
	/**
	 *<b>Description: </b>Método encargado de retornar el valor de el Id asignado al paciente 
	 * @return the idPatient
	 */
	public Integer getIdPatient() {
		return idPatient;
	}
	/**
	 * <b>Description: </b>Método encargado de establecer el valor del id del paciente
	 * @param idPatient the idPatient to set
	 */
	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}
	/**
	 * <b>Description: </b>Método encargado de retornar el valor del nombre del paciente 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * <b>Description: </b>Método encargado de establecer el valor del apellido del paciente
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**<b>Description: </b>Método encargado de retornar el valor del apellido del paciente
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**<b>Description: </b>Método encargado de establecer el valor del apellido del paciente
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**<b>Description: </b>Método encargado de retornar el valor del email del paciente
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**<b>Description: </b>Método encargado de establecer el valor del email del paciente
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**<b>Description: </b>Método encargado de retornar el valor del historial de medicamentos 
	 * @return the medicationHistory
	 */
	public Set<String> getMedicationHistory() {
		return medicationHistory;
	}
	
	/**<b>Description: </b>Método encargado de establecer el valor del historial del medicación del paciente
	 * @param medicationHistory the medicationHistory to set
	 */
	public void setMedicationHistory(Set<String> medicationHistory) {
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
	@Override
	public int hashCode() {
		return Objects.hash(this.email, this.medicationHistory);
	}
	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", medicationHistory=" + medicationHistory + "]";
	}
	
}
