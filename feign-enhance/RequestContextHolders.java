package com.sunvalley.dop.finance.center.config;

public class RequestContextHolders {

    private final static ThreadLocal<CustRequestHeader> threadLocal = new ThreadLocal<>();

    public static  CustRequestHeader getCustRequestHeader(){
    	return threadLocal.get();
	}

	public static  void setCustRequestHeader(CustRequestHeader custRequestHeader){
		 threadLocal.set(custRequestHeader);
	}

	public static  void remove(){
		threadLocal.remove();
	}
}
