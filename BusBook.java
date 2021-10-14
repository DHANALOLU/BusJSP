package pack;
import java.util.*;

public class BusBook {
 
  List<Bus> BusesValidated = new ArrayList<>();
	
  public List<Bus> validateBusBasedOnTicket(List<String> buses, List<Bus> busDetails, String ticketType,
			int ticketsCount) {
   if(!BusesValidated .isEmpty()) {
	   BusesValidated.clear();
   }
  
		for (Bus bus : busDetails) {
			for (String busavail : buses) {
				if ((bus.getbusName().equals(busavail)) && ticketType.equals("SL")) {
					if (bus.getsleeperTickets() >= ticketsCount)
						BusesValidated.add(bus);
				} else if ((bus.getbusName().equals(busavail)) && ticketType.equals("ST")) {
					if (bus.getseaterTickets() >= ticketsCount)
						BusesValidated.add(bus);
				}
			}
		}

		return BusesValidated;
	}
	
}
