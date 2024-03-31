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
package centralPacientes.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones para la inserci�n de un paciente
 */
public class PanelOpcionesInsertar extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private final static String ANTES = "Antes";

    private final static String DESPUES = "Despues";

    private final static String PRIMERO = "Primero";

    private final static String ULTIMO = "Ultimo";

    private final static String CONTINUAR = "Continuar";

    private final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia al di�logo en el que se encuentra el panel
     */
    private DialogoOpcionesInsertar dialogo;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Opci�n para agregar el paciente de primero
     */
    private JRadioButton botonPrimero;

    /**
     * Opci�n para agregar el paciente de ultimo
     */
    private JRadioButton botonUltimo;

    /**
     * Opci�n para agregar el paciente antes de otro paciente
     */
    private JRadioButton botonAntes;

    /**
     * Opci�n para agregar el paciente despu�s de otro paciente
     */
    private JRadioButton botonDespues;

    /**
     * Campo para insertar el c�digo del paciente antes del que se va a realizar la adici�n
     */
    private JTextField textoAntes;

    /**
     * Campo para insertar el c�digo del paciente despu�s del que se va a realizar la adici�n
     */
    private JTextField textoDespues;

    /**
     * Grupo para los botones del g�nero
     */
    private ButtonGroup grupo;

    /**
     * Bot�n para continuar con la adici�n
     */
    private JButton botonContinuar;

    /**
     * Bot�n para cancelar la adici�n
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     *
     * @param diag Dialogo Opciones a insertar
     */
    public PanelOpcionesInsertar(DialogoOpcionesInsertar diag) {
        dialogo = diag;
        setBorder(new TitledBorder("Opciones para agregar el Paciente"));

        setLayout(new GridBagLayout());

        // Bot�n para agregar de primero
        botonPrimero = new JRadioButton("Al comienzo");
        botonPrimero.addActionListener(this);
        botonPrimero.setActionCommand(PRIMERO);
        botonPrimero.setSelected(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(botonPrimero, gbc);

        // Bot�n para agregar de �ltimo
        botonUltimo = new JRadioButton("Al final");
        botonUltimo.addActionListener(this);
        botonUltimo.setActionCommand(PRIMERO);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(botonUltimo, gbc);

        // Bot�n para agregar antes de otro paciente
        botonAntes = new JRadioButton("Antes del paciente con código");
        botonAntes.addActionListener(this);
        botonAntes.setActionCommand(ANTES);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(botonAntes, gbc);

        textoAntes = new JTextField("");
        textoAntes.setEnabled(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.gridwidth = 2;
        add(textoAntes, gbc);

        // Bot�n para agregar despu�s de otro paciente
        botonDespues = new JRadioButton("Después del paciente con código");
        botonDespues.addActionListener(this);
        botonDespues.setActionCommand(DESPUES);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(botonDespues, gbc);

        textoDespues = new JTextField("");
        textoDespues.setEnabled(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 2;
        gbc.ipadx = 100;
        add(textoDespues, gbc);

        // Grupo para los botones
        grupo = new ButtonGroup();
        grupo.add(botonAntes);
        grupo.add(botonDespues);
        grupo.add(botonPrimero);
        grupo.add(botonUltimo);

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        add(panelBotones, gbc);

        // Bot�n para realizar la adici�n
        botonContinuar = new JButton();
        botonContinuar.addActionListener(this);
        botonContinuar.setActionCommand(CONTINUAR);
        botonContinuar.setIcon(new ImageIcon("data/continuar.gif"));
        botonContinuar.setToolTipText("Continuar");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        panelBotones.add(botonContinuar, gbc);

        // Bot�n para cancelar la adici�n
        botonCancelar = new JButton();
        botonCancelar.addActionListener(this);
        botonCancelar.setActionCommand(CANCELAR);
        botonCancelar.setIcon(new ImageIcon("data/cancelar.gif"));
        botonCancelar.setToolTipText("Cancelar");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panelBotones.add(botonCancelar, gbc);

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Deshabilita los campos del panel
     */
    private void deshabilitarTextos() {
        textoAntes.setEnabled(false);
        textoDespues.setEnabled(false);
    }

    /**
     * Limpia los campos del panel
     */
    private void limpiarTextos() {
        textoAntes.setText("");
        textoDespues.setText("");
    }

    /**
     * Retorna la forma de inserci�n seleccionada por el usuario
     *
     * @return La forma de inserci�n seleccionada
     */
    public int darFormaInsercion() {
        int forma = -1;
        if (botonAntes.isSelected()) {
            forma = InterfazCentralPacientes.ANTES;
        }
        else if (botonDespues.isSelected()) {
            forma = InterfazCentralPacientes.DESPUES;
        }
        else if (botonPrimero.isSelected()) {
            forma = InterfazCentralPacientes.COMIENZO;
        }
        else if (botonUltimo.isSelected()) {
            forma = InterfazCentralPacientes.FINAL;
        }

        return forma;
    }

    /**
     * Retorna el c�digo del paciente con relaci�n al cual se va a realizar la inserci�n
     *
     * @return El c�digo del paciente con relaci�n al cual se va a realizar la adici�n. Si la forma de adici�n es primero o �ltimo se retorna -1.
     */
    public int darCodigoPaciente() {
        int codigo = -1;
        if (botonAntes.isSelected()) {
            codigo = Integer.parseInt(textoAntes.getText());
        }
        else if (botonDespues.isSelected()) {
            codigo = Integer.parseInt(textoDespues.getText());
        }
        return codigo;
    }

    /**
     * Manejo de eventos de los botones
     *
     * @param e Evento que gener� la acci�n - e != null.
     */
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals(CONTINUAR)) {
            dialogo.continuarAdicionPaciente();
        }
        else if (comando.equals(CANCELAR)) {
            dialogo.cancelar();
        }
        else if (comando.equals(PRIMERO)) {
            deshabilitarTextos();
            limpiarTextos();
        }
        else if (comando.equals(ULTIMO)) {
            deshabilitarTextos();
            limpiarTextos();
        }
        else if (comando.equals(ANTES)) {
            deshabilitarTextos();
            limpiarTextos();
            textoAntes.setEnabled(true);
        }
        else if (comando.equals(DESPUES)) {
            deshabilitarTextos();
            limpiarTextos();
            textoDespues.setEnabled(true);
        }
    }

}
