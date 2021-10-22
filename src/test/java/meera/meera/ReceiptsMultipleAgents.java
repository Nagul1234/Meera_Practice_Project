package meera.meera;

public class ReceiptsMultipleAgents extends RetailBaseOneway {

	public static void main(String[] args) throws InterruptedException, Exception {
		for(int i=1;i<2;i++) {
		    RetailBaseOneway.browserHistory();
		if(i==1) {
			RetailBaseOneway.retailIssue();
		    RetailBaseOneway.recordPnrReceiptMultiple(i);
		    RetailBaseOneway.bookingReports(0);
		    RetailBaseOneway.fullReceiptIssue();
		    RetailBaseOneway.bookingReports(1);
		    RetailBaseOneway.cancel();
		    RetailBaseOneway.bookingReports(2);
		    RetailBaseOneway.refundReceipt();
			}
		if(i==2) {
			RetailBaseOneway.retailIssue();
		    RetailBaseOneway.recordPnrReceiptMultiple(i);
			RetailBaseOneway.bookingReports(0);
			RetailBaseOneway.fullReceiptIssue();
			RetailBaseOneway.bookingReports(1);
			RetailBaseOneway.cancel();
			RetailBaseOneway.bookingReports(2);
			RetailBaseOneway.refundReceipt();	
		    }
		if(i==3) {
			RetailBaseOneway.retailIssue();
			RetailBaseOneway.recordPnrReceiptMultiple(i);
			RetailBaseOneway.bookingReports(0);
			RetailBaseOneway.partialReceipt1Issue();
			RetailBaseOneway.bookingReports(1);
		    RetailBaseOneway.cancel();
		    RetailBaseOneway.bookingReports(2);
		    RetailBaseOneway.refundReceipt();
		    }
		    }
		
	}

}
