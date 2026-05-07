package co.edu.uptc.clinic.repository;

import co.edu.uptc.clinic.domain.MedicalAppointment;
import java.util.HashMap;

	/**
	 * <b>Descripción: </b> Clase repositorio que gestiona el almacenamiento
	 * y consulta de las citas médicas del sistema <br>
	 *
	 * @author JuanP_Mechas
	 */
	public class AppointmentRepository {

	/** Atributo que determina el mapa de citas médicas registradas en el sistema */
	private HashMap<Integer, MedicalAppointment> appointments;

	/**
     * <b>Descripción: </b> Constructor de la clase
     */
	public AppointmentRepository() {
		this.appointments = new HashMap<>();
	}

	/**
     * <b>Descripción: </b> Agrega una cita médica al sistema. La validación de
     * unicidad del identificador es responsabilidad de la capa de servicio <br>
     * @param appointment Parámetro que determina la cita médica a registrar
     * @return true cuando la cita es insertada en la estructura
     */
	public boolean addAppointment(MedicalAppointment appointment) {
		appointments.put(appointment.getIdMedicalAppointment(), appointment);
		return true;
	}

	/**
     * <b>Descripción: </b> Verifica si ya existe una cita médica registrada con el identificador dado <br>
     * @param idMedicalAppointment Parámetro que determina el identificador a verificar
     * @return true si el ID ya existe, false en caso contrario
     */
	public boolean existsById(Integer idMedicalAppointment) {
		return appointments.containsKey(idMedicalAppointment);
	}

	/**
     * <b>Descripción: </b> Retorna todas las citas médicas registradas en el sistema <br>
     * @return HashMap con todas las citas médicas
     */
	public HashMap<Integer, MedicalAppointment> findAll() {
		return appointments;
	}

	/**
     * <b>Descripción: </b> Busca y retorna una cita médica por su identificador <br>
     * @param idMedicalAppointment Parámetro que determina el identificador de la cita
     * @return La cita médica encontrada, o null si no existe
     */
	public MedicalAppointment findById(Integer idMedicalAppointment) {
		return appointments.get(idMedicalAppointment);
	}

}
