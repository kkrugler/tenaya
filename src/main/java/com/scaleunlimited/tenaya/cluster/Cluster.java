package com.scaleunlimited.tenaya.cluster;

import java.util.List;

import com.scaleunlimited.tenaya.data.Signature;

public interface Cluster {
	
	public void add(Signature sig);
	public List<Signature> getSignatures();

}
