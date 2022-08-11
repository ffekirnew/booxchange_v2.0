package datatypes;

import profiles.*;

public class Report {
	private int reporterID;
	private int reportedID;
	private String reason;

	public void report(Profile reporter, Profile reported, String reason){
		this.reporterID = reporter.getProfileID();
		this.reportedID = reported.getProfileID();
		this.reason = reason;
	}
}