package com.sap.i336048;

public class FinalizeEscapeGC {

	public static FinalizeEscapeGC SAVE_HOOK = null;

	public void isAlive() {
		System.out.println("yes, I'm still alive");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method excuted!");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}
	
	public static void main(String[] args) throws Throwable {
		SAVE_HOOK = new FinalizeEscapeGC();
		SAVE_HOOK = null;
		System.gc();
		
		Thread.sleep(500);
		
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			 System.out.println("no, i'm dead:(");
		}
		
		SAVE_HOOK = null;
		System.gc();
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			 System.out.println("no, i'm dead:(");
		}
	}
}
