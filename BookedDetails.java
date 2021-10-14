package pack;
import java.util.*;

public class BookedDetails {
	List<String> bookedname = new ArrayList<>();
	List<String> bookedtype = new ArrayList<>();
	List<Integer> bookedcount = new ArrayList<>();
public BookedDetails(List<String>  bookedname,List<Integer>  bookedcount,List<String>  bookedtype)
{
	this.bookedcount=bookedcount ;
	this.bookedname=bookedname;
	this.bookedtype=bookedtype;
}
public List<String> getbookedname()
{
	return bookedname;
}
public List<Integer> getbookedcount()
{
	return bookedcount;
}
public List<String> getbookedtype()
{
	return bookedtype;
}
}
