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

public class Grafico extends JFrame {

	public Grafico(Device device) {
		super("Primeiro grafico");

		device.carregarHistograma();

		final XYSeries deviceSeries = new XYSeries("Acessos por hora. Total: "+ device.getAtividade().size());
		for (int i = 0; i < 23; i++) {
			deviceSeries.add(i, device.buscaPorIntervalo(i));
		}
		final XYSeriesCollection deviceDataset = new XYSeriesCollection(deviceSeries);

		JFreeChart deviceChart = ChartFactory.createHistogram("Historiograma de Device", "Horas", "Quantidade de Acessos",
				deviceDataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel deviceChartPanel = new ChartPanel(deviceChart);

		this.add(new ChartPanel(deviceChart));

		this.pack();
	}

	public Grafico(Http http) {
		// final XYSeries httpSeries = new XYSeries("Total de sites visitados
		// por hora");
	}

	public Grafico(Logon logon) {
		logon.carregarHistograma();
		
		final XYSeries logonSeries = new XYSeries("Logons por hora.  Total: "+ logon.getAtividade().size() );
		for (int i = 0; i < 23; i++) {
			logonSeries.add(i, logon.buscaPorIntervalo(i));
		}

		final XYSeriesCollection logonDataset = new XYSeriesCollection(logonSeries);
		JFreeChart logonchart = ChartFactory.createHistogram("Historiograma de Logon", "Horas", "Quantidade de Logon/logoff",
				logonDataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel logonChartPanel = new ChartPanel(logonchart);
		this.add(new ChartPanel(logonchart));
		this.pack();
	}

}
