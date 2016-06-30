package com.scaleunlimited.tenaya.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cluster {
	
	private Signature clusterSig;
	private List<Signature> signatures;
	
	public Cluster() {
		signatures = new ArrayList<Signature>();
	}
	
	public void add(Signature sig) {
		signatures.add(sig);
		if (clusterSig == null) {
			clusterSig = new Signature(sig.getSize());
		}
		clusterSig.addAll(sig);
	}
	
	public List<Signature> getSignatures() {
		return signatures;
	}
	
	public double similarity(Signature sig) {
		return sig.jaccard(clusterSig);
	}

}
