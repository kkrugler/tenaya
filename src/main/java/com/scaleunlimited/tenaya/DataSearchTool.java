package com.scaleunlimited.tenaya;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.scaleunlimited.tenaya.metadata.ExperimentGroup;
import com.scaleunlimited.tenaya.metadata.ExperimentMetadata;

public class DataSearchTool {
	
	public static void main(String[] args) throws Exception {
		Logger.getLogger("org.apache.http").setLevel(Level.OFF);
		if (args.length < 2) {
			System.out.println("Usage: search [RETCOUNT] [QUERY]");
			System.exit(-1);
		}
		int retCount = Integer.parseInt(args[0]);
		String query = args[1];
		for (int i = 2; i < args.length; i++) {
			query += "+" + args[i];
		}
		ExperimentGroup group = ExperimentGroup.getExperimentsByOrganism(query);
		for (int i = 0; i < retCount; i++) {
			ExperimentMetadata meta = group.next();
			for (String run : meta.getRunAccessions()) {
				System.out.println(run);
			}
		}
	}

}