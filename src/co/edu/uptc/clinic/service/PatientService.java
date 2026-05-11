package co.edu.uptc.clinic.service;

import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.repository.PatientRepository;
import java.util.HashMap;

/**
 * <b>Descripción: </b> Clase de servicio que gestiona la lógica de negocio
 * relacionada con los pacientes del sistema <br>
 *
 * @author JuanP_Mechas
 */
public class PatientService {

	/** Atributo que determina el repositorio de pacientes */
	private PatientRepository patientRepository;

	/**
     * <b>Descripción: </b> Constructor de la clase
     */
	public PatientService() {
		super();
		this.patientRepository = new PatientRepository();
	}

	/**
     * <b>Descripción: </b> Valida que los datos obligatorios del paciente sean correctos
     * y que no exista ya un registro con el mismo identificador (regla de negocio) <br>
     * @param patient Parámetro que determina el paciente a validar
     * @return true si los datos son válidos, false en caso contrario
     */
	private boolean validate(Patient patient) {
		if (patient.getFirstName() == null || patient.getFirstName().isBlank()) {
			return false;
		}
		if (patient.getLastName() == null || patient.getLastName().isBlank()) {
			return false;
		}
		if (patient.getEmail() == null || patient.getEmail().isBlank()) {
			return false;
		}
		if (patient.getIdPatient() == null || patient.getIdPatient() <= 0) {
			return false;
		}
		if (patientRepository.existsById(patient.getIdPatient())) {
			return false;
		}
		return true;
	}

	/**
    * <b>Descripción: </b> Registra un paciente en el sistema previa validación
    * de sus datos. La unicidad del email se valida en esta capa como regla de negocio <br>
    * @param patient Parámetro que determina el paciente a registrar
    * @return true si el paciente fue registrado, false si los datos no son válidos
    * o ya existe un registro con el mismo id o email
    */
	public boolean addPatient(Patient patient) {
		if (!validate(patient)) {
			return false;
		}
		if (!patientRepository.addEmail(patient.getEmail())) {
			return false;
		}
		return patientRepository.addPatient(patient);
	}

	/**
     * <b>Descripción: </b> Retorna todos los pacientes registrados en el sistema <br>
     * @return HashMap con todos los pacientes registrados
     */
	public HashMap<Integer, Patient> findAll() {
		return patientRepository.findAll();
	}

	/**
     * <b>Descripción: </b> Busca y retorna un paciente por su número de identificación <br>
     * @param idPatient Parámetro que determina el número de identificación del paciente
     * @return El paciente encontrado, o null si no existe
     */
	public Patient findById(Integer idPatient) {
		return patientRepository.findById(idPatient);
	}

	/**
     * <b>Descripción: </b> Agrega un medicamento al historial de un paciente
     * validando que el medicamento no sea nulo ni vacío <br>
     * @param idPatient Parámetro que determina el id del paciente
     * @param medication Parámetro que determina el medicamento a agregar
     * @return true si el medicamento fue agregado, false en caso contrario
     */
	public boolean addMedication(Integer idPatient, String medication) {
		if (medication == null || medication.isBlank()) {
			return false;
		}
		return patientRepository.addMedication(idPatient, medication);
	}
}