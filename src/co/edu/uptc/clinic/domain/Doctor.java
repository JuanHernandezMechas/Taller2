package co.edu.uptc.clinic.domain;

import co.edu.uptc.clinic.enums.*;
import java.util.Objects;

/**
 * <b>Descripción: </b> Clase de modelo que representa
 * la información de un médico en el sistema <br>
 *
 * @author JuanP_Mechas
 */

public class Doctor implements Comparable<Doctor>{
    
	/** Atributo que determina el tipo de identificación del médico */
	private IdentificationEnum identificationEnums;
	
	/** Atributo que determina el id médico */
    private Integer medicalId;
    
    /** Atributo que determina el nombre del médico */
    private String firstName;
    
    /** Atributo que determina los apellidos del médico */
    private String lastName;
    
    /** Atributo que determina la especialidad del médico */
    private String specialty;
    
    /** Atributo que determina los años de experiencia del médico */
    private Integer yearsOfExperience;
    
    /**
     * <b>Descripción: </b> Constructor vacío de la clase
     */
    public Doctor() {
    	
    }
    
    /**
     * <b>Descripción: </b> Constructor de la clase <br>
     * @param identificationType Parámetro que determina el tipo de identificación
     * @param medicalId Parámetro que determina el número de identificación médica
     * @param firstName Parámetro que determina el nombre del médico
     * @param lastName Parámetro que determina los apellidos del médico
     * @param specialty Parámetro que determina la especialidad del médico
     * @param yearsOfExperience Parámetro que determina los años de experiencia
     */
	public Doctor(IdentificationEnum identificationEnum, int medicalId, String firstName, String lastName,
			String specialty, Integer yearsOfExperience) {
		super();
		this.identificationEnums = identificationEnums;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	/**
     * <b>Descripción: </b> Retorna el tipo de identificación del médico <br>
     * @return identificationType Tipo de identificación del médico
     */
	public IdentificationEnum getIdentificationType() {
		return identificationEnums;
	}

	/**
     * <b>Descripción: </b> Asigna el tipo de identificación del médico <br>
     * @param identificationType Nuevo tipo de identificación
     */
	public void setIdentificationType(IdentificationEnum identificationEnum) {
		this.identificationEnums = identificationEnums;
	}
	
	/**
     *
     * @return medicalId Número de identificación médica
     */
	public Integer getMedicalId() {
		return medicalId;
	}

	/**
     * 
     * @param medicalId Nuevo número de identificación médica
     */
	public void setMedicalId(Integer medicalId) {
		this.medicalId = medicalId;
	}
	
	/**
     * 
     * @return firstName Nombre del médico
     */
	public String getFirstName() {
		return firstName;
	}

	/**
     * 
     * @param firstName Nuevo nombre del médico
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
     * 
     * @return lastName Apellidos del médico
     */
	public String getLastName() {
		return lastName;
	}

	/**
     * 
     * @param lastName Nuevos apellidos del médico
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
     * 
     * @return specialty Especialidad del médico
     */
	public String getSpecialty() {
		return specialty;
	}

	/**
     * <b>Descripción: </b> Asigna la especialidad del médico <br>
     * @param specialty Nueva especialidad del médico
     */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	/**
     * <b>Descripción: </b> Retorna los años de experiencia del médico <br>
     * @return yearsOfExperience Años de experiencia del médico
     */
	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}
	
	/**
     * <b>Descripción: </b> Asigna los años de experiencia del médico <br>
     * @param yearsOfExperience Nuevos años de experiencia
     */
	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	/**
     * <b>Descripción: </b> Compara dos médicos primero por años de experiencia
     * y en caso de empate por nombre completo, ambos en orden ascendente <br>
     * @param other Médico con el que se realiza la comparación
     * @return Valor negativo, cero o positivo según el orden
     */
	@Override
	public int compareTo(Doctor o) {
		int porExp = Integer.compare(this.yearsOfExperience, o.yearsOfExperience);
		if(porExp == 0) {
			String fullName = this.firstName + "" + this.lastName;
			String fullNameO = o.firstName + "" + o.lastName;
			return fullName.compareTo(fullNameO);
		}
		return porExp;
	}
	
	/**
     * <b>Descripción: </b> Compara dos médicos por su número de identificación médica <br>
     * @param obj Objeto a comparar
     * @return true si los médicos tienen el mismo ID, false en caso contrario
     */
	@Override 
	public boolean equals(Object obj) {
		Doctor auxDoctor = (Doctor) obj;
		return this.medicalId.equals(auxDoctor.getMedicalId());
	}
	
	/**
     * <b>Descripción: </b> Genera el código hash del médico basado en su ID médico <br>
     * @return Código hash del médico
     */
	@Override 
	public int hashCode() {
		return Objects.hash(this.medicalId);
	}

	/**
     * <b>Descripción: </b> Retorna una representación en texto del médico <br>
     * @return String con los datos del médico
     */
	@Override
	public String toString() {
		return "Doctor [identificationEnums=" + identificationEnums + ", medicalId=" + medicalId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", specialty=" + specialty + ", yearsOfExperience="
				+ yearsOfExperience + "]";
	}
	
}