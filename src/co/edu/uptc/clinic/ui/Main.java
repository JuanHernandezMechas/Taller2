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