package gradeshistogram;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

/***
 * @author mariaspastefadourou The purpose of this class is to demonstrate a
 *         simple scenario of a JFreeChart XYLine chart.
 * @since April 2021
 */

public class HistogramGenerator {

	/***
	 * Receives an Integer ArrayList. From this ArrayList the array that will be
	 * used to generate the Grades' Frequency Histogram is generated
	 * 
	 * @param datainput Integer ArrayList
	 */
	public double[] getGrades(ArrayList<Integer> datainput) {

		double[] dataValues = new double[datainput.size()];

		int i = 0;
		for (final Integer values : datainput) {
			dataValues[i++] = values;
		}
		return dataValues;
	}

	/***
	 * Receives a single dimension Integer array. From this array the dataset that
	 * will be used for the visualization is generated. Finally, The chart is
	 * generated with the use of the aforementioned dataset and then presented in
	 * the screen.
	 * 
	 * @param dataValues Single dimension double array
	 * @throws FileNotFoundException
	 */
	public void generateChart(double[] dataValues) {
		/*
		 * The HistogramDataset object is a dataset that can be visualized in the same
		 * chart
		 */
		HistogramDataset dataset = new HistogramDataset();

		int bin = 1;

		/*
		 * Pick all elements one by one to find the size of the bin needed for the
		 * dataset A “bin” is another word for a division or group in a histogram
		 */
		for (int i = 1; i < dataValues.length; i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if (dataValues[i] == dataValues[j])
					break;
			}

			// If it was not found earlier,
			// then count it
			if (i == j) {
				bin++;
			}
		}

		// add the series to the dataset
		dataset.addSeries("Frequency", dataValues, bin);

		// Declare and initialize a createHistogram JFreeChart
		JFreeChart chart = ChartFactory.createHistogram("Grades Histogram", "Grade", "Frequency", dataset);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("This is the Histogram", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// Reads data from the file on the command line
		Scanner sc = new Scanner(new FileInputStream(args[0]));
		ArrayList<Integer> datainput = new ArrayList<Integer>();

		while (sc.hasNext()) {
			int value = sc.nextInt();
			datainput.add(value);
		}

		sc.close();

		HistogramGenerator demo = new HistogramGenerator();
		demo.generateChart(demo.getGrades(datainput));
	}
}