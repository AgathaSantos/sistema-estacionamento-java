package view;

import controller.EstacionamentoController;

import javax.swing.*;
import java.awt.*;

public class TelaEstacionamento extends JFrame {

    private EstacionamentoController controller = new EstacionamentoController();

    private JTextField campoPlaca;
    private JTextArea areaTexto;

    public TelaEstacionamento() {

        setTitle("Sistema de Estacionamento");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        campoPlaca = new JTextField(15);
        JButton btnEntrada = new JButton("Entrada");
        JButton btnSaida = new JButton("Saída");
        JButton btnListar = new JButton("Listar");

        areaTexto = new JTextArea(15, 30);
        areaTexto.setEditable(false);

        add(new JLabel("Placa:"));
        add(campoPlaca);
        add(btnEntrada);
        add(btnSaida);
        add(btnListar);
        add(new JScrollPane(areaTexto));

        // AÇÕES
        btnEntrada.addActionListener(e -> {
            controller.registrarEntrada(campoPlaca.getText());
            areaTexto.setText("Entrada registrada!\n");
            campoPlaca.setText("");
        });

        btnSaida.addActionListener(e -> {
            String resultado = controller.registrarSaida(campoPlaca.getText());
            areaTexto.setText(resultado);
            campoPlaca.setText("");
        });

        btnListar.addActionListener(e -> {
            areaTexto.setText(controller.listarVeiculosTexto());
        });
    }
}