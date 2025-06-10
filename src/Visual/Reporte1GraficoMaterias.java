package Visual;

import org.knowm.xchart.*;
import org.knowm.xchart.style.PieStyler;
import org.knowm.xchart.style.Styler;

import Logica.Biblioteca;
import Logica.MateriaConCantidadSolicitudes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Reporte1GraficoMaterias extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private PieChart chart;
    private JButton btnSalir;

    /**
     * Launch the application.
     */

    /**
     * Create the dialog.
     */
    public Reporte1GraficoMaterias() {
    	getContentPane().setBackground(Color.WHITE);
        setTitle("Materias más solicitadas - Biblioteca");
		setBounds(480, 100, 860, 583);
		setModal(true);
		setUndecorated(true);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        inicializarGrafico();
    }

    private void inicializarGrafico() {
    	
        List<MateriaConCantidadSolicitudes> materiasSolicitadas = Biblioteca.getInstancia().guardarMateriasMasSolicitadas();
        for(MateriaConCantidadSolicitudes m : materiasSolicitadas){
        	System.out.println(m.getMateria() + " " + m.getCant());
        }
        
        chart = new PieChartBuilder()
                .width(900)
                .height(600)
                .title("Materias más solicitadas")
                .build();

        personalizarGrafico(chart);
        agregarDatos(chart);
        
        XChartPanel<PieChart> chartPanel = new XChartPanel<>(chart);
        chartPanel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setPreferredSize(new Dimension(750, 600));
        chartPanel.add(getBtnSalir());
        
        contentPanel.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setLayout(null);        
    }
    
    private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("");
			btnSalir.setBounds(740, 11, 50, 50);
			btnSalir.setBorder(null);
			btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSalir.setIcon(new ImageIcon("src/images/otroLogoBorrar50x50.png"));
			btnSalir.setBackground(Color.WHITE);
			btnSalir.setForeground(Color.WHITE);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnSalir;
	}

    private void agregarDatos(PieChart chart) {
        List<MateriaConCantidadSolicitudes> materiasSolicitadas = Biblioteca.getInstancia().guardarMateriasMasSolicitadas();
        for (MateriaConCantidadSolicitudes materia : materiasSolicitadas) {
            String nombre = materia.getMateria() != null ? materia.getMateria().toString() : "Sin nombre";
            chart.addSeries(nombre, materia.getCant());
        }
    }

    private void personalizarGrafico(PieChart chart) {
        PieStyler styler = chart.getStyler();
        
        Color[] coloresPastel = {
            new Color(173, 216, 230), // Azul pastel
            new Color(144, 238, 144), // Verde pastel
            new Color(255, 182, 193), // Rosa pastel
            new Color(221, 160, 221), // Lavanda
            new Color(255, 215, 0),   // Amarillo dorado
            new Color(152, 251, 152), // Verde menta
            new Color(175, 238, 238), // Turquesa pastel
            new Color(255, 218, 185), // Melocotón
            new Color(216, 191, 216), // Ciruela pastel
            new Color(240, 230, 140)  // Amarillo caqui
        };
        
        styler.setSeriesColors(coloresPastel);
        styler.setLabelsVisible(true);
        styler.setLabelType(PieStyler.LabelType.NameAndValue);;
        styler.setLabelsDistance(1.15);
        
        Font fuente = new Font("Segoe UI", Font.PLAIN, 12);
        Font tituloFuente = new Font("Segoe UI", Font.BOLD, 18);
        Font leyendaFuente = new Font("Segoe UI", Font.PLAIN, 12);
        
        styler.setBaseFont(fuente);
        styler.setChartTitleFont(tituloFuente);
        styler.setLegendFont(leyendaFuente);
        styler.setLabelsFont(fuente.deriveFont(Font.BOLD));
        styler.setLabelsFontColor(Color.BLACK);
        
        styler.setChartFontColor(Color.BLACK);
        styler.setPlotBackgroundColor(Color.WHITE);
        styler.setChartBackgroundColor(Color.WHITE);
        
        styler.setPlotBorderVisible(true);
        styler.setPlotBorderColor(new Color(220, 220, 220));
        styler.setPlotContentSize(0.7);
        styler.setCircular(true);
        
        styler.setLegendPosition(Styler.LegendPosition.OutsideE);
        styler.setLegendLayout(Styler.LegendLayout.Vertical);
        styler.setLegendBackgroundColor(Color.WHITE);
        styler.setLegendBorderColor(new Color(200, 200, 200));
        styler.setLegendPadding(10);
        
        styler.setToolTipsEnabled(true);
        styler.setToolTipFont(fuente.deriveFont(Font.ITALIC));
        
        styler.setChartTitlePadding(15);
        styler.setChartTitleBoxBackgroundColor(Color.WHITE);
        styler.setChartTitleBoxBorderColor(Color.GRAY);
        styler.setChartTitleBoxVisible(true);
        
        styler.setDecimalPattern("#0");
        styler.setChartPadding(15);
    }
}