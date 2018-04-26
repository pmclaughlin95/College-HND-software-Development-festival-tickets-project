package BoxOffice;

public class Booking {
	static String CreditCard;
//setter for payment method
	public static  void setPaymentMethod(int PaymentMethod){
	if (PaymentMethod == 1)
	{
		CreditCard = ("Visa");      
	} 
	
	if (PaymentMethod == 2)
	{
		CreditCard = ("Master Card");      
	} 
	if (PaymentMethod == 3)
	{
		CreditCard = ("American Express");      
	} 
	if (PaymentMethod == 4)
	{
		CreditCard = ("Debit Card");      
	} 
}
	// getter for payment method
	public static String getPaymentMethod(){
		return CreditCard;
	

	
}
}