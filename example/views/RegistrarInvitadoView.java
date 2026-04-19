package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import models.Invitado;


/**
 * Tab view for registering a guest (Registrar invitado).
 */
@SuppressWarnings("serial")
public class RegistrarInvitadoView extends JPanel {

    private JTextField tf_nombre;
    private JTextField tf_celular;
    private JTextField tf_direccion;
    private JRadioButton rbtn_masculino;
    private JRadioButton rbtn_femenino;
    private JComboBox<String> cmb_dia;
    private JComboBox<String> cmb_mes;
    private JComboBox<String> cmb_anio;
    private JCheckBox cbx_terminos;

    public RegistrarInvitadoView() {
        setLayout(null);
        make_field_nombre();
        make_field_celular();
        make_field_genero();
        make_field_fechaNacimiento();
        make_field_direccion();
        make_field_terminos();
        make_btn_guardar();
        make_btn_limpiar();
    }

    private void make_field_nombre() {
        JLabel lbl = new JLabel("Ingrese Nombre:");
        lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl.setBounds(29, 30, 150, 14);
        add(lbl);

        tf_nombre = new JTextField();
        tf_nombre.setBounds(200, 27, 196, 20);
        tf_nombre.setColumns(10);
        add(tf_nombre);
    }

    private void make_field_celular() {
        JLabel lbl = new JLabel("Ingrese número celular:");
        lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl.setBounds(29, 70, 160, 14);
        add(lbl);

        tf_celular = new JTextField();
        tf_celular.setBounds(200, 67, 196, 20);
        tf_celular.setColumns(10);
        add(tf_celular);
    }

    private void make_field_genero() {
        JLabel lbl = new JLabel("Género:");
        lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl.setBounds(29, 110, 80, 14);
        add(lbl);

        ButtonGroup grupo = new ButtonGroup();

        rbtn_masculino = new JRadioButton("Masculino");
        rbtn_masculino.setSelected(true);
        rbtn_masculino.setBounds(200, 106, 90, 23);
        grupo.add(rbtn_masculino);
        add(rbtn_masculino);

        rbtn_femenino = new JRadioButton("Femenino");
        rbtn_femenino.setBounds(300, 106, 90, 23);
        grupo.add(rbtn_femenino);
        add(rbtn_femenino);
    }

    private void make_field_fechaNacimiento() {
        JLabel lbl = new JLabel("Fecha de Nacimiento:");
        lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl.setBounds(29, 150, 160, 14);
        add(lbl);

        // Día
        String[] dias = new String[31];
        for (int i = 0; i < 31; i++) dias[i] = String.valueOf(i + 1);
        cmb_dia = new JComboBox<>(dias);
        cmb_dia.setBounds(200, 147, 50, 20);
        add(cmb_dia);

        // Mes
        String[] meses = {"Jan","Feb","Mar","Apr","May","Jun",
                "Jul","Aug","Sep","Oct","Nov","Dec"};
        cmb_mes = new JComboBox<>(meses);
        cmb_mes.setBounds(258, 147, 60, 20);
        add(cmb_mes);

        // Año
        String[] anios = new String[80];
        for (int i = 0; i < 80; i++) anios[i] = String.valueOf(1950 + i);
        cmb_anio = new JComboBox<>(anios);
        // default a 1995
        cmb_anio.setSelectedItem("1995");
        cmb_anio.setBounds(326, 147, 70, 20);
        add(cmb_anio);
    }

    private void make_field_direccion() {
        JLabel lbl = new JLabel("Dirección:");
        lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl.setBounds(29, 190, 100, 14);
        add(lbl);

        tf_direccion = new JTextField();
        tf_direccion.setBounds(200, 187, 196, 20);
        tf_direccion.setColumns(10);
        add(tf_direccion);
    }

    private void make_field_terminos() {
        cbx_terminos = new JCheckBox("Acepta Términos y Condiciones");
        cbx_terminos.setBounds(29, 230, 250, 23);
        add(cbx_terminos);
    }

    private void make_btn_guardar() {
        JButton btn = new JButton("Guardar");
        btn.setBounds(200, 270, 89, 23);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre    = tf_nombre.getText().trim();
                String celular   = tf_celular.getText().trim();
                String direccion = tf_direccion.getText().trim();
                String genero    = rbtn_masculino.isSelected() ? "Masculino" : "Femenino";
                String fecha     = cmb_dia.getSelectedItem() + "/"
                        + cmb_mes.getSelectedItem() + "/"
                        + cmb_anio.getSelectedItem();
                boolean terminos = cbx_terminos.isSelected();

                if (nombre.isEmpty() || celular.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Nombre y celular son obligatorios.",
                            "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!terminos) {
                    JOptionPane.showMessageDialog(null,
                            "Debe aceptar los Términos y Condiciones.",
                            "Términos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                new Invitado(nombre, celular, genero, fecha, direccion, terminos);
                JOptionPane.showMessageDialog(null,
                        "Invitado registrado correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }
        });
    }

    private void make_btn_limpiar() {
        JButton btn = new JButton("Limpiar");
        btn.setBounds(300, 270, 89, 23);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void limpiarCampos() {
        tf_nombre.setText("");
        tf_celular.setText("");
        tf_direccion.setText("");
        rbtn_masculino.setSelected(true);
        cbx_terminos.setSelected(false);
        cmb_dia.setSelectedIndex(0);
        cmb_mes.setSelectedIndex(0);
        cmb_anio.setSelectedItem("1995");
    }
}