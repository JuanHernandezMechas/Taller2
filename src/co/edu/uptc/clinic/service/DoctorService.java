package co.edu.uptc.clinic.service;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.repository.DoctorRepository;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * <b>Descripción: </b> Clase de servicio que gestiona la lógica de negocio
 * relacionada con los médicos del sistema <br>
 *
 * @author JuanP_Mechas
 */
public class DoctorService {

	/** Atributo que determina el repositorio de médicos */
	private DoctorRepository doctorRepository;

	/**
     * <b>Descripción: </b> Constructor de la clase
     */
	public DoctorService() {
		super();
		this.doctorRepository = new DoctorRepository();
	}
	/**
     * <b>Descripción: </b> Valida que los datos obligatorios del médico sean correctos
     * y que no exista ya un registro con el mismo identificador (regla de negocio) <br>
     * @param doctor Parámetro que determina el médico a validar
     * @return true si los datos son válidos, false en caso contrario
     */
	private boolean validate(Doctor doctor) {
		if (doctor.getFirstName() == null || doctor.getFirstName().isBlank()) {
			return false;
		}
		if (doctor.getLastName() == null || doctor.getLastName().isBlank()) {
			return false;
		}
		if (doctor.getSpecialty() == null || doctor.getSpecialty().isBlank()) {
			return false;
		}
		if (doctor.getMedicalId() == null || doctor.getMedicalId() <= 0) {
			return false;
		}
		if (doctor.getYearsOfExperience() == null || doctor.getYearsOfExperience() < 0) {
			return false;
		}
		if (doctorRepository.existsById(doctor.getMedicalId())) {
			return false;
		}
		return true;
	}

	/**
     * <b>Descripción: </b> Registra un médico en el sistema previa validación
     * de sus datos y de la unicidad de su identificador <br>
     * @param doctor Parámetro que determina el médico a registrar
     * @return true si el médico fue registrado, false si los datos no son válidos
     * o ya existe un registro con el mismo id
     */
	public boolean addDoctor(Doctor doctor) {
		if (!validate(doctor)) {
			return false;
		}
		return doctorRepository.addDoctor(doctor);
	}

	/**
     * <b>Descripción: </b> Retorna todos los médicos registrados en el sistema <br>
     * @return HashMap con todos los médicos registrados
     */
	public HashMap<Integer, Doctor> findAll() {
		return doctorRepository.findAll();
	}

	/**
     * <b>Descripción: </b> Busca y retorna un médico por su número de identificación médica <br>
     * @param medicalId Parámetro que determina el número de identificación médica
     * @return El médico encontrado, o null si no existe
     */
	public Doctor findById(Integer medicalId) {
		return doctorRepository.findById(medicalId);
	}

	/**
     * <b>Descripción: </b> Retorna todos los médicos ordenados por años de experiencia
     * de forma ascendente y en caso de empate por nombre completo de forma ascendente <br>
     * @return TreeSet con los médicos ordenados por experiencia y nombre
     */
	public TreeSet<Doctor> findAllByExperience() {
		TreeSet<Doctor> orden = new TreeSet<>();
		orden.addAll(doctorRepository.findAll().values());
		return orden;
	}

}