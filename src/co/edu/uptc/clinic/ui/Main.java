package co.edu.uptc.clinic.ui;

import co.edu.uptc.clinic.service.*;
import co.edu.uptc.clinic.domain.*;
import co.edu.uptc.clinic.enums.*;
import javax.swing.JOptionPane;
import java.time.LocalTime;
import java.util.TreeSet;

/**
 * <b>Descripción: </b> Clase principal de la interfaz de usuario que gestiona
 * la interacción con el sistema de la Clínica El Laguito mediante ventanas
 * emergentes. Permite registrar pacientes, médicos y citas médicas, agregar
 * medicamentos al historial de un paciente, y consultar reportes del sistema <br>
 *
 * @author JuanP_Mechas
 */

public class Main {
	
	/** Atributo que determina el servicio de pacientes */
	private PatientService patientService;
 
	/** Atributo que determina el servicio de médicos */
	private DoctorService doctorService;
 
	/** Atributo que determina el servicio de citas médicas */
	private AppointmentService appointmentService;
 
	/**
	 * <b>Descripción: </b> Constructor de la clase. Inicializa los servicios
	 * de pacientes, médicos y citas médicas del sistema <br>
	 */
	public Main() {
		super();
		this.patientService = new PatientService();
		this.doctorService = new DoctorService();
		this.appointmentService = new AppointmentService(patientService, doctorService);
	}
	
	/**
	 * <b>Descripción: </b> Método principal que inicia la ejecución del sistema <br>
	 * @param args Parámetro que determina los argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		new Main().iniciar();
	}
	
	/**
	 * <b>Descripción: </b> Muestra el menú principal del sistema en un bucle
	 * hasta que el usuario seleccione la opción de salir. Redirige cada opción
	 * al método correspondiente <br>
	 */
	public void iniciar() {
		int option = -1;
		while(option != 0) {
			option = Integer.parseInt(JOptionPane.showInputDialog(null, """
					===== Clínica el Laguito ====
					
					1). Registrar paciente
					2). Registrar médico
					3). Registrar cita médica
					4). Agregar medicamento a paciente
					5). Ver cola de antención
					6). Ver reporte de médicos por experiencia
					0). Salir
					
					Seleccione una opción:""",
					"Menu Principal", JOptionPane.PLAIN_MESSAGE)
					);
		switch(option) {
		case 1:
			registrarPaciente();
			break;
		case 2: registrarMedico();
			break;
		case 3:
			registrarCita();
			break;
		case 4:
			agregarMedicamento();
			break;
		case 5:
			verColaAtencion();
			break;
		case 6: 
			verReporteMedicos();
			break;
		case 0:
			JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema", "Salir", JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * <b>Descripción: </b> Solicita al usuario mediante ventanas emergentes los
	 * datos necesarios para registrar un nuevo paciente en el sistema. Muestra un
	 * mensaje de éxito o error según el resultado del registro <br>
	 */
	public void registrarPaciente() {
		String[] tipos = {"CC - Cédula de ciudadanía", "TI - Tarjeta de identidad", "CE - Cédula de extranjería", "PA - Pasaporte"};
		int tipoIndex = JOptionPane.showOptionDialog(null, "Seleccione el tipo de identificación:", "Registrar Paciente", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tipos, tipos[0]);
		if(tipoIndex == -1) {
			return;
		}
		IdentificationEnum identificationTypeEnums = IdentificationEnum.values()[tipoIndex];
		
		int idPatient = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de identificación:", "Registrar Paciente", JOptionPane.PLAIN_MESSAGE));
		String firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente:", "Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		String lastName = JOptionPane.showInputDialog(null, "Ingrese los apellidos del paciente:", "Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		String email = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico del paciente:", "Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		
		String[] prioridades = {
				"LOW - Baja", "MEDIUM - Media", "HIGH - Alta", "CRITICAL - Crítica"
		};
		int prioridadIndex = JOptionPane.showOptionDialog(null, "Seleccione la prioridad de atención:", "Registrar Paciente", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, prioridades, prioridades[0]);
		if(prioridadIndex == -1) {
			return;
		}
		PriorityEnum priority = PriorityEnum.values()[prioridadIndex];
		Patient patient = new Patient(priority, identificationTypeEnums, idPatient, firstName, lastName, email, null);
		if(patientService.addPatient(patient)) {
			JOptionPane.showMessageDialog(null, "Paciente registrado exitosamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se puedo registrar al paciente. El ID o el email ya existen dentro del sistema", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
 	* <b>Descripción: </b> Solicita al usuario mediante ventanas emergentes los
 	* datos necesarios para registrar un nuevo médico en el sistema. Muestra un
 	* mensaje de éxito o error según el resultado del registro <br>
 	*/
	public void registrarMedico() {
	String[] tipos = {"CC - Cédula de ciudadanía", "TI - Tarjeta de identidad", "CE - Cédula de extranjería", "PA - Pasaporte"};
	int tipoIndex = JOptionPane.showOptionDialog(null, "Seleccione el tipo de identificación:", "Registrar Médico", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tipos, tipos[0]);
	if(tipoIndex == -1) {
		return;
	}
	IdentificationEnum identificationType = IdentificationEnum.values()[tipoIndex];
	
	int medicalId = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del médico:", "Registrar Médico", JOptionPane.PLAIN_MESSAGE));
	String firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del médico:", "Registrar Médico", JOptionPane.PLAIN_MESSAGE);
	String lastName = JOptionPane.showInputDialog(null, "Ingrese los apellidos del médico:", "Registrar Médico", JOptionPane.PLAIN_MESSAGE);
	String speciality = JOptionPane.showInputDialog(null, "Ingrese la especialidad del médico:", "Registrar Médico", JOptionPane.PLAIN_MESSAGE);
	int yearsOfExperience = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los años de experiencia del médico:", "Registrar Médico", JOptionPane.PLAIN_MESSAGE));
	Doctor doctor = new Doctor(identificationType, medicalId, firstName, lastName, speciality, yearsOfExperience);
	if(doctorService.addDoctor(doctor)) {
		JOptionPane.showMessageDialog(null, "Médico registrado exitosamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	} else {
		JOptionPane.showMessageDialog(null, "No se puedo registrar al médico. El ID o los datos son inválidos para el sistema", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * <b>Descripción: </b> Solicita al usuario mediante ventanas emergentes los
	 * datos necesarios para registrar una nueva cita médica en el sistema.
	 * Verifica que el paciente y el médico existan antes de crear la cita.
	 * Muestra un mensaje de éxito o error según el resultado del registro 
	 */
	public void registrarCita() {
	int idCita = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la cita:", "Registrar cita", JOptionPane.PLAIN_MESSAGE));
	LocalTime hora = LocalTime.parse(JOptionPane.showInputDialog(null, "Ingrese la hora de la cita (formato HH:mm):", "Registrar Cita", JOptionPane.PLAIN_MESSAGE));
	
	int idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del paciente:", "Registrar Cita", JOptionPane.PLAIN_MESSAGE));
	Patient patient = patientService.findById(idPaciente);
	if (patient == null) {
        JOptionPane.showMessageDialog(null, "El paciente con el id " + idPaciente + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int idMedico = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del médico:", "Registrar Cita", JOptionPane.PLAIN_MESSAGE));
    Doctor doctor = doctorService.findById(idMedico);
    if (doctor == null) {
        JOptionPane.showMessageDialog(null, "El médico con el id " + idMedico + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    	}
    	MedicalAppointment appointment = new MedicalAppointment(idCita, hora, patient, doctor);
    		if (appointmentService.addAppointment(appointment)) {
        JOptionPane.showMessageDialog(null, "La cita ha sido registrada exitosamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    		} else {
        JOptionPane.showMessageDialog(null, "No se pudo registrar. El ID de la cita ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
	}
/**
 * <b>Descripción: </b> Solicita al usuario el identificador del paciente y el
 * nombre del medicamento a agregar en su historial. Muestra un mensaje de éxito
 * o error según el resultado de la operación <br>
 */

	public void agregarMedicamento() {
	int idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del paciente:", "Agregar Medicamento", JOptionPane.PLAIN_MESSAGE));
	String medicamento = JOptionPane.showInputDialog(null, "Ingrese el nombre del medicamento:", "Agregar Medicamento", JOptionPane.PLAIN_MESSAGE);
	
	if(patientService.addMedication(idPaciente, medicamento)) {
		JOptionPane.showMessageDialog(null, "El medicamento ha sido agregado exitosamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	} else {
		JOptionPane.showMessageDialog(null, "No se pudo agregar el medicamento. El paciente no existe o el medicamento ya estaba registrado.", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
/**
 * <b>Descripción: </b> Consulta y muestra la cola de atención con todas las
 * citas médicas ordenadas primero por hora y en caso de empate por mayor
 * prioridad del paciente. Si no hay citas registradas muestra un aviso al
 * usuario <br>
 */
	public void verColaAtencion(){
	TreeSet<MedicalAppointment> cola = appointmentService.findAllByTimeAndPriority();

    if (cola.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay citas registradas.", 
            "Cola de Atención", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    StringBuilder sb = new StringBuilder("===== Cola de Atención =====\n\n");
    int numero = 1;
    for (MedicalAppointment cita : cola) {
        sb.append(numero++).append(". ")
          .append("Hora: ").append(cita.getTimeAppointment()).append(" | ")
          .append("Paciente: ").append(cita.getPatient().getFirstName())
          .append(" ").append(cita.getPatient().getLastName()).append(" | ")
          .append("Prioridad: ").append(cita.getPatient().getPriorityEnums()).append(" | ")
          .append("Médico: ").append(cita.getDoctor().getFirstName())
          .append(" ").append(cita.getDoctor().getLastName()).append("\n");
    }

    JOptionPane.showMessageDialog(null, sb.toString(), 
        "Cola de Atención", JOptionPane.INFORMATION_MESSAGE);
}
/**
 * <b>Descripción: </b> Consulta y muestra el reporte de médicos ordenados por
 * años de experiencia de forma ascendente y en caso de empate por nombre
 * completo de forma ascendente. Si no hay médicos registrados muestra un aviso
 * al usuario <br>
 */
	public void verReporteMedicos() {
	TreeSet<Doctor> medicos = doctorService.findAllByExperience();

    if (medicos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay médicos registrados.", 
            "Reporte de Médicos", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    StringBuilder sb = new StringBuilder("===== Reporte de Médicos por Experiencia =====\n\n");
    int numero = 1;
    for (Doctor doctor : medicos) {
        sb.append(numero++).append(". ")
          .append(doctor.getFirstName()).append(" ").append(doctor.getLastName())
          .append(" | Especialidad: ").append(doctor.getSpecialty())
          .append(" | Experiencia: ").append(doctor.getYearsOfExperience())
          .append(" año(s)\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString(), 
        "Reporte de Médicos", JOptionPane.INFORMATION_MESSAGE);
	}
}
	