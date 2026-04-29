package co.edu.uptc.clinic.domain;

import java.time.LocalTime;
import java.util.Objects;

/**
 * <b>Descripción: </b> Clase de modelo que representa
 * la información de una cita médica en el sistema <br>
 *
 * @author JuanP_Mechas
 */
public class MedicalAppointment {
	
	/** Atributo que determina el id de la cita médica */
	private Integer idMedicalAppointment;
	
	/** Atributo que determina la hora de la cita médica */
	private LocalTime timeAppointment;
	
	/** Atributo que determina la información del paciente asociado a la cita */
	private Patient patient;
	
	/** Atributo que determina la información del médico asociado a la cita */
	private Doctor doctor;
	
	/**
     * <b>Descripción: </b> Constructor vacío de la clase
     */
	public MedicalAppointment() {
		
	}
	
	/**
     * <b>Descripción: </b> Constructor de la clase <br>
     * @param idMedicalAppointment Parámetro que determina el identificador de la cita
     * @param timeAppointment Parámetro que determina la hora de la cita
     * @param patient Parámetro que determina el paciente de la cita
     * @param doctor Parámetro que determina el médico de la cita
     */
	public MedicalAppointment(Integer idMedicalAppointment, LocalTime timeAppointment, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppointment = idMedicalAppointment;
		this.timeAppointment = timeAppointment;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	/**
     * 
     * @return idMedicalAppointment Identificador de la cita médica
     */
	public Integer getIdMedicalAppointment() {
		return idMedicalAppointment;
	}
	
	/**
     * 
     * @param idMedicalAppointment Nuevo identificador de la cita médica
     */
	public void setIdMedicalAppointment(Integer idMedicalAppointment) {
		this.idMedicalAppointment = idMedicalAppointment;
	}
	
	/**
     *
     * @return timeAppointment Hora de la cita médica
     */
	public LocalTime getTimeAppointment() {
		return timeAppointment;
	}
	/**
     *
     * @param timeAppointment Nueva hora de la cita médica
     */
	public void setTimeAppointment(LocalTime timeAppointment) {
		this.timeAppointment = timeAppointment;
	}
	
	/**
     *
     * @return patient Información del paciente
     */
	public Patient getPatient() {
		return patient;
	}
	
	/**
     * 
     * @param patient Nueva información del paciente
     */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
     *
     * @return doctor Información del médico
     */
	public Doctor getDoctor() {
		return doctor;
	}
	
	/**
     *
     * @param doctor Nueva información del médico
     */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	/**
     * @param obj Objeto a comparar
     * @return true si las citas tienen el mismo ID, false en caso contrario
     */
	@Override
	public boolean equals(Object obj) {
		MedicalAppointment aux = (MedicalAppointment) obj;
		return this.idMedicalAppointment.equals(aux.getIdMedicalAppointment());
	}
	
	/**
     * @return Código hash de la cita médica
     */
	@Override
	public int hashCode() {
		return Objects.hash(this.idMedicalAppointment);
	}
	
	/**
     * @return String con los datos de la cita médica
     */
	@Override
	public String toString() {
		return "MedicalAppointment [idMedicalAppointment=" + idMedicalAppointment + ", timeAppointment="
				+ timeAppointment + ", patient=" + patient.getFirstName() + " " + patient.getLastName() + 
				", doctor=" + doctor.getFirstName() + " " + doctor.getLastName() + "]";
	}
	
}