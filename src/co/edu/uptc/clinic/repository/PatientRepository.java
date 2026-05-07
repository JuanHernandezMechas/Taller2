package co.edu.uptc.clinic.repository;

import co.edu.uptc.clinic.domain.Patient;
import java.util.HashMap;
import java.util.HashSet;

/**
 * <b>Descripción: </b> Clase repositorio que gestiona el almacenamiento
 * y consulta de los pacientes del sistema <br>
 *
 * @author JuanP_Mechas
 */
public class PatientRepository {

	/** Atributo que determina el mapa de pacientes registrados en el sistema */
	private HashMap<Integer, Patient> patients;

	/** Atributo que determina el conjunto de correos electrónicos ya registrados */
	private HashSet<String> registeredEmails;

	/**
     * <b>Descripción: </b> Constructor de la clase
     */
	public PatientRepository() {
		super();
		this.patients = new HashMap<>();
		this.registeredEmails = new HashSet<>();
	}

	/**
     * <b>Descripción: </b> Agrega un paciente al sistema. La validación de
     * unicidad de ID y email es responsabilidad de la capa de servicio <br>
     * @param patient Parámetro que determina el paciente a registrar
     * @return true cuando el paciente es insertado en la estructura
     */
	public boolean addPatient(Patient patient) {
		patients.put(patient.getIdPatient(), patient);
		return true;
	}

	/**
     * <b>Descripción: </b> Registra un correo electrónico en el conjunto de
     * emails. Retorna false si el email ya estaba registrado <br>
     * @param email Parámetro que determina el correo electrónico a registrar
     * @return true si el email fue agregado, false si ya existía
     */
	public boolean addEmail(String email) {
		return registeredEmails.add(email);
	}

	/**
     * <b>Descripción: </b> Verifica si ya existe un paciente registrado con
     * el identificador dado <br>
     * @param id Parámetro que determina el identificador a verificar
     * @return true si el ID ya existe, false en caso contrario
     */
	public boolean existsById(Integer id) {
		return patients.containsKey(id);
	}

	/**
     * <b>Descripción: </b> Retorna todos los pacientes registrados en el sistema <br>
     * @return HashMap con todos los pacientes registrados
     */
	public HashMap<Integer, Patient> findAll() {
		return patients;
	}

	/**
     * <b>Descripción: </b> Busca y retorna un paciente por su número de identificación <br>
     * @param idPatient Parámetro que determina el número de identificación del paciente
     * @return El paciente encontrado, o null si no existe
     */
	public Patient findById(Integer idPatient) {
		return patients.get(idPatient);
	}

	/**
     * <b>Descripción: </b> Agrega un medicamento al historial de un paciente
     * validando que el paciente exista y que el medicamento no esté ya registrado <br>
     * @param idPatient Parámetro que determina el ID del paciente
     * @param medication Parámetro que determina el medicamento a agregar
     * @return true si el medicamento fue agregado, false si el paciente no existe o el medicamento ya estaba
     */
	public boolean addMedication(Integer idPatient, String medication) {
		Patient patient = findById(idPatient);
		if (patient == null) {
			return false;
		}
		return patient.getMedicationHistory().add(medication);
	}

}