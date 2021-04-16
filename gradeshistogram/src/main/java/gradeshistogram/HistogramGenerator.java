package gradeshistogram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
	public int[] getGrades(ArrayList<Integer> datainput) {

		int[] dataValues = new int[datainput.size()];

		int i = 0;
		for (final int values : datainput) {
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
	 * @param dataValues Single dimension Integer array
	 * @throws FileNotFoundException
	 */
	public void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		int bin = 0;
		ArrayList<Integer> grades = new ArrayList<Integer>();
		
		/*
		 * Pick all elements one by one to find how many different grades there are in the given file
		 */
		for (int i = 0; i < dataValues.length; i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if (dataValues[i] == dataValues[j])
					break;
			}

			// If it was not found earlier,
			// then count it
			if (i == j) {
				grades.add(dataValues[i]);
				bin++;
			}
		}
		
		// Sort the ArrayList that contains the unique grades from the given file
		Collections.sort(grades);
		
		/*
		 * Find the Frequency of every grade that was in the given file
		 */	
		for (int i = 0; i < grades.size(); i++) {
			int freq = 0;
			for (int j = 0; j < dataValues.length; j++) {
				if (grades.get(i) == dataValues[j]) {
					freq++;
				}
			}
			int number = grades.get(i);
			data.add(number, freq);
		}
		
		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grade", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

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