package com.scaleunlimited.tenaya;

import java.io.File;
import org.kohsuke.args4j.Option;

public class SignatureGenerationToolOptions {
	
	public enum GenerationMethod {
		SIMPLE,
		PARTITION
	}
	
	private File[] inputs;
	
	@Option(name="-o", usage="Output signature file", required=true, aliases="--output")
	private File output;
	
	@Option(name="-k", usage="Length of generated k-mers", required=false, aliases="--ksize")
	private int ksize = 20;
	
	@Option(name="-M", usage="Maximum memory in bytes for the Count-Min Sketch", required=false, aliases="--max-memory")
	private long maxMemory = 1000000000;
	
	@Option(name="-c", usage="Cutoff count for filtering k-mers", required=false, aliases="--cutoff")
	private int cutoff = 1;
	
	@Option(name="-s", usage="Size of the generated signature", required=false, aliases="--signature-size")
	private int signatureSize = 1000;
	
	@Option(name="-b", usage="Buffer size for the input file (in bytes)", required=false, aliases="--buffer-size")
	private int bufferSize = 10 * 1024 * 1024;
	
	@Option(name="-C", usage="Number of chunks for the Count-Min Sketch (simple only)", required=false, aliases="--chunks")
	private int chunks = 1000;
	
	@Option(name="-d", usage="Depth (i.e. rows or hashes) of the Count-Min Sketch", required=false, aliases="--depth")
	private int depth = 5;
	
	@Option(name="-f", usage="Regex that captures the unique part of the identifier which determines sample boundaries (use 'sra' for SRA-downloaded files)", required=false, aliases="--filter")
	private String filter = "sra";
	
	@Option(name="-t", usage="Number of threads to use", required=false, aliases="--threads")
	private int threads = 8;
	
	@Option(name="-m", usage="Method to use (simple or partition)", required=false, aliases="--method")
	private GenerationMethod method = GenerationMethod.SIMPLE;
	
	@Option(name="-q", usage="Queue size (default: 100 per thread)", required=false, aliases="--queue-size")
	private int queueSize = 0;
	
	@Option(name="--gzip", usage="Input file is gzipped", required=false)
	private boolean gzip = false;
	
	@Option(name="--pid", usage="Display process PIDS with output", required=false)
	private boolean pid = false;
	
	@Option(name="-i", usage="Input FASTA or FASTQ file(s) (separated by commas)", required=true, aliases="--input")
	public void setInputFiles(String nameList) {
		String[] names = nameList.split(",");
		inputs = new File[names.length];
		for (int i = 0; i < names.length; i++) {
			inputs[i] = new File(names[i]);
		}
	}
	
	public File[] getInputFiles() {
		return inputs;
	}
	
	public File getOutputFile() {
		return output;
	}
	
	public int getKsize() {
		return ksize;
	}
	
	public long getMaxMemory() {
		return maxMemory;
	}
	
	public int getCutoff() {
		return cutoff;
	}
	
	public int getSignatureSize() {
		return signatureSize;
	}
	
	public int getBufferSize() {
		return bufferSize;
	}
	
	public int getChunks() {
		return chunks;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public String getFilter() {
		return filter;
	}
	
	public boolean getGzip() {
		return gzip;
	}
	
	public int getThreadCount() {
		return threads;
	}
	
	public GenerationMethod getMethod() {
		return method;
	}
	
	public int getQueueSize() {
		return queueSize;
	}
	
	public boolean getPid() {
		return pid;
	}

}
