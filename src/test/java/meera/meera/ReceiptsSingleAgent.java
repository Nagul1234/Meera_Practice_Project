package meera.meera;

import java.awt.AWTException;

public class ReceiptsSingleAgent extends RetailBaseOneway {

	public static void main(String[] args) throws Exception {
		for(int i=1;i<5;i++) {
			RetailBaseOneway.browserHistory();
			RetailBaseOneway.retailIssue();
			RetailBaseOneway.recordPnrReceiptSingle(i);
			if(i==1) {
			RetailBaseOneway.fullReceiptIssue();
			RetailBaseOneway.cancel();
				}
			
			
			
			
			
			
			}

	}

}
