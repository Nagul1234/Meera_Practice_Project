package Offlineflight;

public class Main extends RetailBase {

	public static void main(String[] args) throws Exception {
		for(int i=7;i<11;i++) {
		
			RetailBase.retailIssue();
		if (i==0) {
			//RetailBase.allReceipt();
			RetailBase.cancel();
			RetailBase.fullReceiptIssue();
		}
		if (i==1) {
			RetailBase.refund();
			RetailBase.fullReceiptIssue();
			}
		
		if(i==2) {
			RetailBase.partialReceipt2();
			RetailBase.cancel();
			RetailBase.fullReceiptReIssue();
		}
		if(i==3) {
			RetailBase.partialReceipt2();
			RetailBase.refund();
			RetailBase.fullReceiptReIssue();
			
		}
		if(i==4) {
			RetailBase.partialReceipt1Issue();
			RetailBase.cancel();
			RetailBase.refundReceipt();
			
		}
		if(i==5) {
			RetailBase.partialReceipt1Issue();
			RetailBase.refund();
			RetailBase.refundReceipt();
		}
		if(i==6) {
			RetailBase.fullReceiptIssue();
			RetailBase.cancel();
			RetailBase.refundReceipt();	
		}
		if(i==7) {
			RetailBase.fullReceiptIssue();
			RetailBase.refund();
			RetailBase.refundReceipt();		
			
		}
		if(i==8) {
			RetailBase.reissueAdd();	
			RetailBase.reissuecancel();
			RetailBase.fullReceiptReIssue();
		}
		if(i==9) {
			RetailBase.reissueAdd();	
			RetailBase.reissuerefund();
			RetailBase.fullReceiptIssue();
		}
		if(i==10) {
			RetailBase.fullReceiptIssue();
			RetailBase.reissueAdd();	
			RetailBase.fullReceiptReIssue();
			RetailBase. reissuecancel();
			
		}
		if(i==11) {
			RetailBase.fullReceiptIssue();
			RetailBase.reissueAdd();	
			RetailBase.fullReceiptReIssue();
			RetailBase.reissuerefund();
			
		}
		if(i==12) {
			RetailBase.reissueAdd();	
			RetailBase.partialReceipt1Issue();
			RetailBase.reissuecancel();
			RetailBase.fullReceiptIssue();
		}
		if(i==13) {
			
			RetailBase.reissueAdd();	
			RetailBase.partialReceipt1Issue();
			RetailBase.reissuerefund();
			RetailBase.fullReceiptReIssue();
		}
		if(i==14) {
			RetailBase.reissueAdd();	
			RetailBase.fullReceiptIssue();
			RetailBase.reissuecancel();
			RetailBase.refundReceipt();
			
		}
		if(i==15) {
			RetailBase.reissueAdd();	
			RetailBase.fullReceiptIssue();
			RetailBase.reissuerefund();
			RetailBase.refundReceipt();
			
		}
		}
for(int j=30;j<27;j++){
	
	
	if(j==16) {
		RetailBase.reissueRes();
		RetailBase.reissuecancel();
		RetailBase.fullReceiptIssue();
	}
	if(j==17){
		RetailBase.reissueRes();
		RetailBase.reissuerefund();
		RetailBase.fullReceiptIssue();
		
	}
	if(j==18) {
		RetailBase.partialReceipt1Issue();
		RetailBase.reissueRes();
		RetailBase.partialReceipt1ReIssue();
		RetailBase.reissuecancel();
		RetailBase.refundReceipt();
	}
	if(j==19) {
		
		RetailBase.partialReceipt1Issue();
		RetailBase.reissueRes();
		RetailBase.partialReceipt1ReIssue();
		RetailBase.reissuerefund();
		RetailBase.fullReceiptReIssue();
	}
	if(j==20) {
		RetailBase.fullReceiptIssue();
		RetailBase.reissueRes();
		RetailBase.fullReceiptReIssue();
		RetailBase.reissuecancel();
		RetailBase.refundReceipt();
	}
	if(j==21) {
		RetailBase.fullReceiptIssue();
		RetailBase.reissueRes();
		RetailBase.fullReceiptReIssue();
		RetailBase.reissuerefund();
		RetailBase.refundReceipt();	
	}
	if(j==22) {
		RetailBase.reissueRes();
		RetailBase.partialReceipt1Issue();
		RetailBase.reissuecancel();
		RetailBase.refundReceipt();
	}
	if(j==23) {
		
		RetailBase.reissueRes();
		RetailBase.partialReceipt1Issue();
		RetailBase.reissuerefund();
		RetailBase.fullReceiptReIssue();	
	}
	if(j==24) {
		RetailBase.reissueRes();
		RetailBase.fullReceiptIssue();
		RetailBase.reissuecancel();
		RetailBase.refundReceipt();
		
	}
	if(j==25) {
		RetailBase.reissueRes();
		RetailBase.fullReceiptIssue();
		RetailBase.reissuerefund();
		RetailBase.refundReceipt();
		
	}
	/*if(j==26) {
		RetailIssue2.reissueAdd();
		RetailIssue2.reissueAdd();
		RetailIssue2.reissuecancel();
		RetailIssue2.fullReceipt();
	}*/
	
}
	}

}
