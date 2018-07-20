package Ventana;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import luchadores.Batalla;
import luchadores.Luchador;

public class GUIDatos extends JFrame implements ActionListener {

    protected JScrollPane luchsScrollPane, equipoScrollPane, areaScrollPane, bossScrollPane;
    protected JLabel lista1, lista2, datosBoss;
    protected JList listaLuchs, listaEquipo;
    protected JPanel luchadores, equipo, datos, partida;
    protected JButton agregarAlEquipo, quitarDelEquipo, verDatos, iniciarPartida;
    protected JTextArea textDatos;
    protected JTextArea textBoss;

    private Batalla bat;
    private DefaultListModel listaL;
    private DefaultListModel listaLdeApoyo;//por detalles de los luchadores, listaL son solo String de Nombres
    private DefaultListModel listaE;
    private DefaultListModel listaEdeApoyo;//por detalles de los luchadores, listaE son solo String de Nombres

    public GUIDatos(String title) {
        super(title);
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        //Labels
        lista1 = new JLabel("Lista luchadores");
        lista2 = new JLabel("Lista Equipo");
        datosBoss = new JLabel("Boss");

        //Botones
        this.agregarAlEquipo = new JButton("Agregar Luchador al equipo");
        this.agregarAlEquipo.addActionListener(this);
        this.quitarDelEquipo = new JButton("Quitar Luchador del equipo");
        this.quitarDelEquipo.addActionListener(this);
        this.verDatos = new JButton("Ver Datos");
        this.verDatos.addActionListener(this);
        this.iniciarPartida = new JButton("Iniciar Partida");
         this.iniciarPartida.addActionListener(this);

        //Listas        
        this.bat = new Batalla();//Para elegir 6 de 25 luchadores para el equipo

        this.listaL = new DefaultListModel();
        this.listaLdeApoyo = new DefaultListModel();

        Luchador luchador;
        for (int x = 0; x < 25; x++) {
            luchador = bat.luchadoresVentana();
            listaL.addElement(luchador.getNombre());
            listaLdeApoyo.addElement(luchador);
        }
        this.listaLuchs = new JList(listaL);

        this.listaE = new DefaultListModel();
        this.listaEdeApoyo = new DefaultListModel();

        this.listaEquipo = new JList(listaE);

        //para el ScrollPane de las listas
        this.luchsScrollPane = new JScrollPane(listaLuchs);
        this.luchsScrollPane.setPreferredSize(new Dimension(100, 100));
        this.equipoScrollPane = new JScrollPane(listaEquipo);
        this.equipoScrollPane.setPreferredSize(new Dimension(100, 100));

        this.listaLuchs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaEquipo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //JTextArea para ver datos
        this.textDatos = new JTextArea();
        textDatos.setEditable(false);

        //Scroll Pane de textArea
        this.areaScrollPane = new JScrollPane(textDatos);
        this.areaScrollPane.setPreferredSize(new Dimension(200, 100));

        //area para datos del boss enemigo
        this.textBoss = new JTextArea();
        this.textBoss.setText(bat.getEnemigo().toString());
        textBoss.setEditable(false);
        //Scroll pane de los datos del boss enemigo
        this.bossScrollPane = new JScrollPane(textBoss);
        this.bossScrollPane.setPreferredSize(new Dimension(200, 100));

        //Paneles
        this.luchadores = new JPanel();
        this.equipo = new JPanel();
        this.datos = new JPanel();
        this.partida = new JPanel();

        this.luchadores.add(lista1);
        this.luchadores.add(luchsScrollPane);
        this.luchadores.add(agregarAlEquipo);
        this.equipo.add(lista2);
        this.equipo.add(equipoScrollPane);
        this.equipo.add(quitarDelEquipo);
        this.datos.add(verDatos);
        this.datos.add(areaScrollPane);
        this.datos.add(datosBoss);
        this.datos.add(bossScrollPane);
        this.partida.add(iniciarPartida);

        //se agregan los paneles
        this.add(luchadores);
        this.add(equipo);
        this.add(datos);
        this.add(partida);

        //
        this.setSize(550, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarAlEquipo) {
            agregarAlEquipo();
        }
        if (e.getSource() == quitarDelEquipo) {
            quitarDelEquipo();

        }
        if (e.getSource() == verDatos) {
            ver();
        }
        if (e.getSource() == iniciarPartida) {
            if (bat.getEquipo().size() == 0) {
                JOptionPane.showMessageDialog(null, "Su equipo debe tener al menos un luchador");
            } else {
                GUIResultado resultado = new GUIResultado("Resultado", bat);
                resultado.setVisible(true);
                this.setVisible(false);
            }

        }

    }

    /* 
        Condición: No haber seleccionado ningún luchador de los JList disponibles
        Medidas: Uso del método método JOptionPane.showMessageDialog() para dar a conocer al
                 usuario lo que debe hacer.
        Tipo de excepcion: Mátematica
        Justificación: Al no seleccionar nada, los métodos de los botones trataran de 
                       obtener los elmentos "-1" de los JList, lo cual es imposible
                       ya que la posición de los elementos en las listas comienzan desde el "0"
     */
    private void agregarAlEquipo() {
        if (listaE.size() == 6) {
            JOptionPane.showMessageDialog(null, "El equipo no puede tener más de 6 luchadores");
        } else {
            try {
                int indice = this.listaLuchs.getSelectedIndex();
                Luchador luchador = (Luchador) this.listaLdeApoyo.getElementAt(indice);

                this.listaL.remove(indice);
                this.listaLdeApoyo.remove(indice);

                this.listaE.addElement(luchador.getNombre());
                this.listaEdeApoyo.addElement(luchador);

                //
                this.bat.getEquipo().add(luchador);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Elija un luchador de la primera lista para agregar al equipo");
            }
        }
    }

    private void quitarDelEquipo() {
        try {
            int indice = this.listaEquipo.getSelectedIndex();
            Luchador luchador = (Luchador) this.listaEdeApoyo.getElementAt(indice);

            this.listaE.remove(indice);
            this.listaEdeApoyo.remove(indice);

            this.listaL.addElement(luchador.getNombre());
            this.listaLdeApoyo.addElement(luchador);

            //
            this.bat.getEquipo().remove(indice);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Elija un luchador  de la segunda lista para quitar del equipo");
        }

    }

    private void ver() {
        try {
            int indice = this.listaLuchs.getSelectedIndex();
            this.textDatos.setText((this.listaLdeApoyo.getElementAt(indice)).toString());
            //Aqui se mostraran datos de los luchadores en ambas listas

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un luchador de la lista");
            this.textDatos.setText("");
        }
    }
}
