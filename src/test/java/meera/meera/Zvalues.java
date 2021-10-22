package meera.meera;

public class Zvalues extends RetailBaseOneway {

	public static void main(String[] args) throws Exception {
		/*RetailBaseOneway.browserHistory();
		RetailBaseOneway.retailIssue();*/
		/*for(int i=0;i<3;i++) {
		RetailBaseOneway.browserHistory();
		RetailBaseOneway.retailIssue();
		//RetailBaseOneway.retailIssue();
		//RetailBaseOneway.bookingReports();
		
		//RetailBaseOneway.partialReceipt1IssueMulti();
		}*/
		//RetailBaseOneway.browserHistory();
		for(int i=0;i<1;i++) {
		RetailBaseOneway.retailIssue();	
		}
		for(int i=2;i<1;i++) {
			//int r=i+1;
			RetailBaseOneway.browserHistory();
			RetailBaseOneway.retailIssue();			
			//RetailBaseOneway.recordPnr(r);
			/*RetailBaseOneway.actualZvalue(r);
			RetailBaseOneway.expectedZvalue(r);
			RetailBaseOneway.status(r);*/
		if (i==0) {
			RetailBaseOneway.cancel();
			/*RetailBaseOneway.actualZvalue(r);
			RetailBaseOneway.expectedZvalue(r);
			RetailBaseOneway.status(r);*/
			RetailBaseOneway.fullReceiptIssue();
		          }		
		if (i==1) {
			RetailBaseOneway.refund();
			/*RetailBaseOneway.actualZvalue(r);
			RetailBaseOneway.expectedZvalue(r);
			RetailBaseOneway.status(r);*/
			RetailBaseOneway.fullReceiptIssue();
			}
		
		if(i==2) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.partialReceipt2();
			RetailBaseOneway.cancel();
			RetailBaseOneway.fullReceiptReIssue();
		}
		if(i==3) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.partialReceipt2();
			RetailBaseOneway.refund();
			//RetailBaseOneway.fullReceiptReIssue();
			
		}
		if(i==4) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.partialReceipt1Issue();
			RetailBaseOneway.cancel();
			//RetailBaseOneway.refundReceipt();
			
		}
		if(i==5) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.partialReceipt1Issue();
			RetailBaseOneway.refund();
			//RetailBaseOneway.refundReceipt();
		}
		if(i==6) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.fullReceiptIssue();
			RetailBaseOneway.cancel();
			/*RetailBaseOneway.actualZvalue(r);
			RetailBaseOneway.expectedZvalue(r);
			RetailBaseOneway.status(r);*/
			RetailBaseOneway.refundReceipt();	
		}
		if(i==7) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.fullReceiptIssue();
			RetailBaseOneway.refund();
			/*RetailBaseOneway.actualZvalue(r);
			RetailBaseOneway.expectedZvalue(r);
			RetailBaseOneway.status(r);*/
			RetailBaseOneway.refundReceipt();		
			
		}
		if(i==8) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.reissueAdd();	
			RetailBaseOneway.reissuecancel();
			RetailBaseOneway.fullReceiptIssue();
		}
		if(i==9) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.reissueAdd();	
			RetailBaseOneway.reissuerefund();
			RetailBaseOneway.fullReceiptIssue();
		}
		if(i==10) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.fullReceiptIssue();
			RetailBaseOneway.reissueAdd();	
			RetailBaseOneway.fullReceiptReIssue();
			RetailBaseOneway. reissuecancel();
			
		}
		if(i==11) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.fullReceiptIssue();
			RetailBaseOneway.reissueAdd();	
			RetailBaseOneway.fullReceiptReIssue();
			RetailBaseOneway.reissuerefund();
			
		}
		if(i==12) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.reissueAdd();	
			RetailBaseOneway.partialReceipt1Issue();
			RetailBaseOneway.reissuecancel();
			RetailBaseOneway.fullReceiptReIssue();
		}
		if(i==13) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.reissueAdd();	
			RetailBaseOneway.partialReceipt1Issue();
			RetailBaseOneway.reissuerefund();
			RetailBaseOneway.fullReceiptReIssue();
		}
		//BUG
		if(i==14) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.reissueAdd();	
			RetailBaseOneway.fullReceiptIssue();
			RetailBaseOneway.reissuecancel();
			RetailBaseOneway.refundReceipt();
			
		}
		if(i==15) {
			//RetailBaseOneway.retailIssue();
			RetailBaseOneway.reissueAdd();	
			RetailBaseOneway.fullReceiptIssue();
			RetailBaseOneway.reissuerefund();
			RetailBaseOneway.refundReceipt();
			
		}
		}
for(int j=27;j<26;j++){
	RetailBaseOneway.browserHistory();
	RetailBaseOneway.retailIssue();
	
	if(j==16) {
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.reissuecancel();
		RetailBaseOneway.fullReceiptIssue();
	}
	if(j==17){
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.reissuerefund();
		RetailBaseOneway.fullReceiptIssue();
		
	}
	if(j==18) {
		RetailBaseOneway.partialReceipt1Issue();
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.partialReceipt1ReIssue();
		RetailBaseOneway.reissuecancel();
		RetailBaseOneway.refundReceipt();
	}
	if(j==19) {
		
		RetailBaseOneway.partialReceipt1Issue();
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.partialReceipt1ReIssue();
		RetailBaseOneway.reissuerefund();
		RetailBaseOneway.refundReceipt();
	}
	if(j==20) {
		RetailBaseOneway.fullReceiptIssue();
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.fullReceiptReIssue();
		RetailBaseOneway.reissuecancel();
		RetailBaseOneway.refundReceipt();
	}
	if(j==21) {
		RetailBaseOneway.fullReceiptIssue();
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.fullReceiptReIssue();
		RetailBaseOneway.reissuerefund();
		RetailBaseOneway.refundReceipt();	
	}
	//BUG
	if(j==22) {
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.partialReceipt1Issue2();
		RetailBaseOneway.reissuecancel();
		RetailBaseOneway.refundReceipt();
	}
	if(j==23) {
		
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.partialReceipt1Issue();
		RetailBaseOneway.reissuerefund();
		RetailBaseOneway.fullReceiptReIssue();	
	}
	//BUG
	if(j==24) {
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.fullReceiptIssue();
		RetailBaseOneway.reissuecancel();
		RetailBaseOneway.refundReceipt();
		
	}
	if(j==25) {
		RetailBaseOneway.reissueRes();
		RetailBaseOneway.fullReceiptIssue();
		RetailBaseOneway.reissuerefund();
		RetailBaseOneway.refundReceipt();
		
	}
	if(j==26) {
		RetailIssue2.reissueAdd();
		RetailIssue2.reissueAdd();
		RetailIssue2.reissuecancel();
		RetailIssue2.fullReceiptReIssue();
	}
	
}
	}

}
