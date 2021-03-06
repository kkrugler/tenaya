package com.scaleunlimited.tenaya.nio;

public class NIOSample {
	
	private NIOFastAParser parser;
	
	public NIOSample(NIOFastAParser parser) {
		this.parser = parser;
	}
	
	public String getIdentifier() {
		return parser.getReader().getCurrentIdentifier();
	}
	
	public byte readByte() {
		return parser.readByte();
	}

}
