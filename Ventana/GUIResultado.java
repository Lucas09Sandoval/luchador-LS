package Ventana;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import luchadores.Batalla;

public class GUIResultado extends JFrame{

    protected JTextArea resultadoBatalla;
    protected JScrollPane scrollPane;

    public GUIResultado(String title, Batalla bat) {
        super(title);
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);       
        
        resultadoBatalla = new JTextArea();
        resultadoBatalla.setEditable(false);
        scrollPane = new JScrollPane(resultadoBatalla);
        scrollPane.setPreferredSize(new Dimension(300,100));
        
         //Aqui estan los métodos relacionados con la pelea
        resultado(bat);

        this.add(scrollPane);

        this.setSize(550, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private void resultado(Batalla bat){
        String saltoLinea = System.getProperty("line.separator");        
        String resultadoFinal;
        
        int dados = bat.lanzarDados();
        bat.evaluarCaso(dados);
        bat.vectorLuchadores();//Se ordenan los luchadores segun velocidad
        bat.pelear();
        
        resultadoFinal= "Resultado de los dados: "+dados+saltoLinea+
                "La batalla empezo"+saltoLinea+"Luchadores muertos:"+bat.getMuertos()+saltoLinea+"Usted ha: "+bat.finalizarPartida();        
        
        resultadoBatalla.setText(resultadoFinal);
    }
}
