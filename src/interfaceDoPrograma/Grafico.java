package interfaceDoPrograma;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import models.Device;
import models.Http;
import models.Logon;
import models.Usuario;

public class Grafico extends JFrame {

	public Grafico(Usuario usuario, Device device) {
		super("Grafico Device");

		device.carregarHistograma();

		final XYSeries deviceSeries = new XYSeries("Acessos por hora | Total: " + device.getAtividade().size()
				+ "| Nome do usuario:" + usuario.getEmployee_name());

		for (int hora = 0; hora < 23; hora++) {
			deviceSeries.add(hora, device.buscaPorIntervalo(hora));
		}

		final XYSeriesCollection deviceDataset = new XYSeriesCollection(deviceSeries);

		JFreeChart deviceChart = ChartFactory.createHistogram("Histograma de Device", "Horas",
				"Quantidade de Acessos", deviceDataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel deviceChartPanel = new ChartPanel(deviceChart);

		this.add(new ChartPanel(deviceChart));

		this.pack();
	}

	public Grafico(Usuario usuario, Http http) {
		super("Grafico Http");
		http.carregarHistograma();

		final XYSeries httpSeries = new XYSeries("Url's visitadas por hora.  Total: " + http.getAtividade().size()
				+ "| Nome do usuario:" + usuario.getEmployee_name());

		for (int hora = 0; hora < 23; hora++) {
			httpSeries.add(hora, http.buscaPorIntervalo(hora));
		}

		final XYSeriesCollection httpDataset = new XYSeriesCollection(httpSeries);
		JFreeChart httpChart = ChartFactory.createHistogram("Histograma de Http", "Horas",
				"Quantidade de Logon/logoff", httpDataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel httpChartPanel = new ChartPanel(httpChart);
		this.add(new ChartPanel(httpChart));
		this.pack();
	}

	public Grafico(Usuario usuario, Logon logon) {
		super("Grafico Logon");

		logon.carregarHistograma();

		final XYSeries logonSeries = new XYSeries("Logons por hora.  Total: " + logon.getAtividade().size()
				+ "| Nome do usuario:" + usuario.getEmployee_name());

		for (int hora = 0; hora < 23; hora++) {
			logonSeries.add(hora, logon.buscaPorIntervalo(hora));
		}

		final XYSeriesCollection logonDataset = new XYSeriesCollection(logonSeries);
		JFreeChart logonchart = ChartFactory.createHistogram("Histograma de Logon", "Horas",
				"Quantidade de Logon/logoff", logonDataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel logonChartPanel = new ChartPanel(logonchart);
		this.add(new ChartPanel(logonchart));
		this.pack();
	}

}
