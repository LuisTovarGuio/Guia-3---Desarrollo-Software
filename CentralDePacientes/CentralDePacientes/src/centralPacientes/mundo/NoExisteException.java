/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package centralPacientes.mundo;

/**
 * Excepci�n generada cuando un paciente con un c�digo dado no existe
 */
public class NoExisteException extends Exception {
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la excepci�n con el c�digo del paciente
     *
     * @param codigo C�digo del paciente que no est� registrado en la central
     */
    public NoExisteException(int codigo) {
        super("El paciente con código " + codigo + " no esta registrado");
    }

	public NoExisteException(String string) {
		// TODO Auto-generated constructor stub
	}
}
