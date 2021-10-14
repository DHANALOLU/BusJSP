package pack;
import java.util.*;

public class BusHelper {

 List<String> buses = new ArrayList<String>();
public void findBus(String source, String destination, Map<String, List<String>> BusesAndRoutes) {
		
		for (Map.Entry<String, List<String>> entry : BusesAndRoutes.entrySet()) {
			List<String> routeList = entry.getValue();
			for (String b : routeList) {
				if (b.contains(source) & b.contains(destination)
						& (b.indexOf(source) < b.indexOf(destination))) {
					buses.add(entry.getKey());
				}
			}
		}

		

	}
public List<String> getBuses()
{
	return buses;
	
}
}
