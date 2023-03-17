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
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
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
        if (primero == null)
        {
            primero = pac;
        }
        else

        {
            pac.cambiarSiguiente(primero);
            primero = pac;
        }
        Pacientes++;
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        if (primero == null)
        {
            primero = pac;
        }
        else {

            Paciente p = localizarUltimo();

            p.insertarDespues(pac);
        }
        Pacientes++;

    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        if (primero == null) {
            throw new NoExisteException(cod);
        }
        else if (cod == primero.darCodigo()) {
            pac.cambiarSiguiente(primero);
            primero = pac;
        }
        else {
            Paciente anterior = localizarAnterior(cod);
            if (anterior == null) {
                throw new NoExisteException(cod);
            }
            anterior.insertarDespues(pac);
        }
        Pacientes++;
    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        Paciente anterior = localizar(cod);

        if (anterior == null)
        {
            throw new NoExisteException(cod);
        }
        else

        {
            anterior.insertarDespues(pac);
        }
        Pacientes++;

    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        Paciente actual = primero;
        while (actual != null && actual.darCodigo() != codigo) {
            actual = actual.darSiguiente();
        }
        return null;
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        if (primero == null) {
            throw new NoExisteException(cod);
        }
        else if (cod == primero.darCodigo()) {
            // El paciente es el primero de la lista
            primero = primero.darSiguiente();
        }
        else {
            // El paciente es un elemento intermedio de la lista
            Paciente anterior = localizarAnterior(cod);
            if (anterior == null) {
                throw new NoExisteException(cod);
            }
            anterior.desconectarSiguiente();
        }
        Pacientes--;
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Paciente actual = primero;
        while (actual != null) {
            pacientes.add(actual);
            actual = actual.darSiguiente();
        }
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
        int cont = 0;
        Paciente p = primero;
        while(p != null) {
            if (p.darSexo() == 1)
                cont += 1;
            p = p.darSiguiente();
        }
        return cont;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int cont = 0;
        Paciente p = primero;
        while(p != null) {
            if (p.darSexo() == 2)
                cont += 1;
            p = p.darSiguiente();
        }
        return cont;
    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
        return "Respuesta 4";
    }


}
