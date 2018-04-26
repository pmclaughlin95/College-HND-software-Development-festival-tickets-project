package BoxOffice;


public class Events {	
		//variables
		private String ArtistName;
		private String venue;
		private String Concertdate;
		private double Ticketprice;
		private int AvailableTickets;
		
		// constructor
		public Events(){};
		
		//constructor override
		public Events(String Artist, String venue, String date, double price, int available)
		{
			this.ArtistName = Artist;
			this.Concertdate = date;
			this.Ticketprice = price;
			this.AvailableTickets = available;
			this.venue = venue;
			
			
		}
		
		// setter for Artist
		public void setArtist(String ArtistName)
		{
			this.ArtistName = ArtistName;
		}
		
		//setter for date
		public void setConcertdate(String ConcertDate)
		{
		  		this.Concertdate = ConcertDate;
		}
		//setter for venue
		public void setvenue(String Venue)
		{
			this.venue = Venue;
		}
		
		//setter for price
		public void setTicketPrice(double amount)
		{
			this.Ticketprice = amount;
		}
		
		//setter for availability
		public void setAvailableTickets(int AvailableTickets1)
		{
			this.AvailableTickets = AvailableTickets1;
		}
		
		//getter for Artist
		public String getArtist()
		{
			return this.ArtistName;
		}
		
				
		//getter for date
		public String getConcertdate()
		{
			return this.Concertdate;
		}
		
		//getter for venue
		public String getvenue()
		{
		 	return this.venue;
		}
				
			
		//getter for price
		public double getTicketPrice(double price1)
		{
			return Ticketprice;
		}
		
				
		//getter for availability
		public int getAvailabileTickets(int available1)
		{
			return AvailableTickets;
		}
				
	}