package co.edu.uptc.clinic.repository;

import java.util.HashMap;

import co.edu.uptc.clinic.domain.Doctor;

public class DoctorRepository {
	/**
	 * <b>Descripción: </b> Clase repositorio que gestiona el almacenamiento
	 * y consulta de los médicos del sistema <br>
	 *
	 *@author JuanP_Mechas
	 */

		/** Atributo que determina el mapa de médicos registrados en el sistema */
		private HashMap<Integer, Doctor> doctors;

		/**
	     * <b>Descripción: </b> Constructor de la clase
	     */
		public DoctorRepository() {
			super();
			this.doctors = new HashMap<>();
		}
		/**
	     * <b>Descripción: </b> Agrega un médico al sistema. La validación de
	     * unicidad del identificador es responsabilidad de la capa de servicio <br>
	     * @param doctor Parámetro que determina el médico a registrar
	     * @return true cuando el médico es insertado en la estructura
	     */
		public boolean addDoctor(Doctor doctor) {
			doctors.put(doctor.getMedicalId(), doctor);
			return true;
		}
		/**
	     * <b>Descripción: </b> Verifica si ya existe un médico registrado con
	     * el identificador dado <br>
	     * @param medicalId Parámetro que determina el identificador a verificar
	     * @return true si el ID ya existe, false en caso contrario
	     */
		public boolean existsById(Integer medicalId) {
			return doctors.containsKey(medicalId);
		}
		/**
	     * <b>Descripción: </b> Retorna todos los médicos registrados en el sistema <br>
	     * @return HashMap con todos los médicos registrados
	     */
		public HashMap<Integer, Doctor> findAll() {
			return doctors;
		}
		/**
	     * <b>Descripción: </b> Busca y retorna un médico por su número de identificación médica <br>
	     * @param medicalId Parámetro que determina el número de identificación médica
	     * @return El médico encontrado, o null si no existe
	     */
		public Doctor findById(Integer medicalId) {
			return doctors.get(medicalId);
		}
	}