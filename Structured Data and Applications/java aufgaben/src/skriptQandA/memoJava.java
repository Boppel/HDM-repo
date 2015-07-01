package skriptQandA;

import java.util.Date;
import java.util.SortedSet;

public class memoJava {

	// attributes of the memo
	private Date date;
	private Priority prio;
	
	// elements of the memo
	private String from;
	private String subject;
	private String content;
	// SortedSet because no duplicates shall be allowed <-> not possible in xml schemes!
	private SortedSet<String> to;
	
}

enum Priority {
	low, med, high;
}
