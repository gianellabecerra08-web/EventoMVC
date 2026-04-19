package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.EventListController;


/**
 * Tab view for removing an event (Remove Event).
 */
@SuppressWarnings("serial")
public class RemoveEventView extends JPanel {

    private JTextField tf_index;
    private EventListController eventListController;

    public RemoveEventView(EventListController eventListController) {
        this.eventListController = eventListController;
        setLayout(null);
        make_field_index();
        make_btn_eliminar();
    }

    private void make_field_index() {
        JLabel lbl_titulo = new JLabel("Eliminar Evento");
        lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_titulo.setBounds(29, 30, 200, 20);
        add(lbl_titulo);

        JLabel lbl = new JLabel("Número de fila a eliminar:");
        lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl.setBounds(29, 80, 200, 14);
        add(lbl);

        tf_index = new JTextField();
        tf_index.setBounds(240, 77, 80, 20);
        tf_index.setColumns(10);
        add(tf_index);

        JLabel lbl_hint = new JLabel("(Ver la pestaña Events para ver el número de fila)");
        lbl_hint.setFont(new Font("Tahoma", Font.ITALIC, 10));
        lbl_hint.setBounds(29, 105, 350, 14);
        add(lbl_hint);
    }

    private void make_btn_eliminar() {
        JButton btn = new JButton("Eliminar");
        btn.setBounds(240, 135, 100, 23);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = tf_index.getText().trim();
                if (texto.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Ingrese el número de fila.",
                            "Campo vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    int fila = Integer.parseInt(texto) - 1; // base 0
                    eventListController.removeRow(fila);
                    JOptionPane.showMessageDialog(null,
                            "Evento eliminado correctamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    tf_index.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Ingrese un número válido.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "No se pudo eliminar. Verifique el número de fila.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}