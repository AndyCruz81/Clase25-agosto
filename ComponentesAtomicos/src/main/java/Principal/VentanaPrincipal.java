/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Checkbox;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class VentanaPrincipal extends JFrame implements ActionListener, ChangeListener{
    
    private Container contenedor;
    private JLabel lblTitulo;
    private JLabel etiqueta;
    private JLabel etiquetaButton;
    private JLabel etiquetaToogleButton;
    private JLabel etiquetaCheckBox;
    private JLabel etiquetaRadioButton;
    private JLabel etiquetaCombo;
    private JLabel etiquetaSeparador;
    private JLabel etiquetaSpinner;
    private JLabel etiquetaDeslizador;
    private JLabel etiquetaBarra;
    private JButton boton;
    private JCheckBox checkbox1, checkbox2;
    private ButtonGroup grupoRadios;
    private JRadioButton radio1, radio2;
    private JToggleButton toggleButton;
    private JComboBox combo;
    private JSeparator separadorVertical, separadorHorizontal;
    private JSpinner spinner;
    private JSlider deslizador;
    private JProgressBar barra;
    
    
    public VentanaPrincipal(){
//        Iniciar las propiedades de los componenetes 
        iniciarComponentes(); 
//        Asignar un titulo
        setTitle("JFrame Componenetes Atomicos");
//        Definir tamaño de la ventana
        setSize(630, 250);
//        Dejarlo en el centro
        setLocationRelativeTo(null);
//        Para que el usuario no pueda jugar con el
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == boton){
            String salida = "";
            salida = validaEventos();
            JOptionPane.showMessageDialog(null, salida);
            
        }
        
    }

    @Override
    public void stateChanged(ChangeEvent evento) {
        int valor;
        if (evento.getSource() == deslizador){
            valor = deslizador.getValue();
            barra.setValue(valor);
            spinner.setValue(valor);
        }
        if(evento.getSource() == spinner){
            valor = (Integer) spinner.getValue();
            deslizador.setValue(valor);
            barra.setValue(valor);
        }
        
    }

    private void iniciarComponentes() {
        contenedor = new Container();
//      vamos a definir nosotros mismos los tamaños y posiciones de los componentes
        contenedor.setLayout(null);
        
        lblTitulo = new JLabel();
        lblTitulo.setText("Componentes Atomicos");
        lblTitulo.setFont(new Font ("Tahoma", 1, 20));
        lblTitulo.setBounds(180, 5, 380, 40);
        
        etiqueta = new JLabel ();
        etiqueta.setText("JLabel");
        etiqueta.setBounds(20, 50, 280, 23);
        
        etiquetaButton = new JLabel();
        etiquetaButton.setText("JButton");
        etiquetaButton.setBounds(20, 80, 80, 23);
        
        boton = new JButton();
        boton.setText("Boton");
        boton.setBounds(80, 80, 80, 23);
        boton.addActionListener(this);
        
        etiquetaCheckBox = new JLabel();
        etiquetaCheckBox.setText("JCheckBox");
        etiquetaCheckBox.setBounds(20, 110, 80, 23 );
        
        checkbox1 = new JCheckBox();
        checkbox1.setText("Check1");
        etiquetaCheckBox.setBounds(100, 110, 80, 23);
        
        checkbox2 = new JCheckBox();
        checkbox2.setText("Check2");
        etiquetaCheckBox.setBounds(100, 110, 80, 23);
        
        etiquetaRadioButton = new JLabel();
        etiquetaRadioButton.setText("radioButton");
        etiquetaRadioButton.setBounds(20, 140, 100, 23);
        
        grupoRadios = new ButtonGroup();
        radio1 = new JRadioButton();
        radio1.setText("Radio1");
        radio1.setBounds(110, 140, 80, 23);
        
        grupoRadios = new ButtonGroup();
        radio2 = new JRadioButton();
        radio2.setText("Radio1");
        radio2.setBounds(110, 140, 80, 23);
        
        grupoRadios.add(radio1);
        grupoRadios.add(radio2);
        
        etiquetaToogleButton = new JLabel();
        etiquetaToogleButton.setText("ToggleButton");
        etiquetaToogleButton.setBounds(20, 180, 100, 23);
        
        toggleButton = new JToggleButton();
        toggleButton.setText("Activar");
        toggleButton.setBounds(120, 180, 100, 23);
        
        combo = new JComboBox();
        combo.addItem("Opciones");
        combo.addItem("Opcion 1");
        combo.addItem("Opcion 2");
        combo.addItem("Opcion 3");
        combo.addItem("Opcion 4");
        combo.setBounds(430, 50, 100, 23);
        combo.setSelectedIndex(0);
        
       separadorVertical = new JSeparator();
       separadorVertical.setOrientation(SwingConstants.VERTICAL);
       separadorVertical.setBounds(300, 60, 10, 200);
       
       separadorHorizontal = new JSeparator();
       separadorHorizontal.setOrientation(SwingConstants.HORIZONTAL);
       separadorHorizontal.setBounds(300, 60, 10, 200);
       
       etiquetaSeparador = new JLabel();
       etiquetaSeparador.setText("JSpinner");
       etiquetaSeparador.setBounds(350, 110, 100, 23);
       
       spinner = new JSpinner();
       spinner.setBounds(430, 110, 50, 23);
       spinner.addChangeListener(this);
       
       etiquetaDeslizador = new JLabel();
       etiquetaDeslizador.setText("Deslizador");
       etiquetaDeslizador.setBounds(350, 140, 100, 23);
       
       deslizador = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
       deslizador.setBounds(430, 140, 100, 30);
       deslizador.setPaintTicks(true);
       deslizador.setMajorTickSpacing(50);
       deslizador.setMinorTickSpacing(5);
       deslizador.setBorder(new TitledBorder(" "));
       deslizador.setValue(0);
       deslizador.addChangeListener(this);
       
       etiquetaBarra = new JLabel();
       etiquetaBarra.setText("JProgressBar");
       etiquetaBarra.setBounds(350, 180, 100, 23);
       
       barra = new JProgressBar();
       barra.setBounds(350, 180, 100, 20);
       
       contenedor.add(lblTitulo);
       contenedor.add(boton);
       contenedor.add(etiquetaCheckBox);
       contenedor.add(checkbox1);
       contenedor.add(checkbox2);
       contenedor.add(etiquetaRadioButton);
       contenedor.add(combo);
       contenedor.add(separadorVertical);
       contenedor.add(separadorHorizontal);
       contenedor.add(etiquetaSeparador);
       contenedor.add(etiquetaSpinner);
       contenedor.add(spinner);
       contenedor.add(etiquetaDeslizador);
       contenedor.add(deslizador);
       contenedor.add(etiquetaBarra);
       contenedor.add(barra);
       add(contenedor);  
    }

    private String validaEventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
