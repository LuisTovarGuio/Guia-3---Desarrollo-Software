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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clinica del Country");
        listaClinicas.add("Clinica Palermo");
        listaClinicas.add("Clinica Reina Sofia");
        listaClinicas.add("Clinica El Bosque");
        listaClinicas.add("Clinica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
    	
    	pacientes.add(0, pac);
        // TODO: Realiar el m�todo que agrega al principio OKK
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
    	
    	pacientes.add(pac);
        // TODO: Agragar un paciente al final de la lista OKK
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
    	
    	for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).codigo == cod) {
                pacientes.add(i, pac);
                return;
            }
        }
        // TODO: Agrega un paciente despu�s del paciente con el c�digo dado OKK 
    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
    	for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).codigo == cod) {
                if (i == pacientes.size() - 1) { 
                    pacientes.add(pac); 
                } else {
                    pacientes.add(i + 1, pac); 
                }
                return;
            }
        }
    	
        throw new NoExisteException("El paciente con el código " + cod + " no existe.");
        
        // TODO: Agrega un paciente despu�s del paciente con el c�digo cod OKK
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
    	
    	for (Paciente pac : pacientes) {
            if (pac.codigo == codigo) {
                return pac;
            }
        }
        // TODO: Completar el m�todo OKK
        return null;
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
    	
    	boolean encontrado = false;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).codigo == cod) {
                pacientes.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new NoExisteException("El paciente con el código " + cod + " no existe.");
        }
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci   OKKK
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
    	
    	int count = 0;
        for (Paciente pac : pacientes) {
            if (pac.darSexo() == Paciente.HOMBRE) {
                count++;
            }
        }
        return count;   	
    	
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
    	int contador = 0; 
        for (Paciente pac : pacientes) {
            if (pac.darSexo() == Paciente.MUJER) {
                contador++; 
            }
        }
        return contador;
    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
    	Map<String, Integer> clinicas = new HashMap<>();
        for (Paciente pac : pacientes) {
            clinicas.put(pac.darClinica(), clinicas.getOrDefault(pac.darClinica(), 0) + 1);
        }
        String clinicaMasOcupada = null;
        int maxPacientes = 0;
        for (Map.Entry<String, Integer> entry : clinicas.entrySet()) {
            if (entry.getValue() > maxPacientes) {
                maxPacientes = entry.getValue();
                clinicaMasOcupada = entry.getKey();
            }
        }
        return clinicaMasOcupada;
    }
        

}
