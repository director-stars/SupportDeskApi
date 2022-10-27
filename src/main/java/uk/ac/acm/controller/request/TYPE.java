package uk.ac.acm.controller.request;

public enum TYPE{
	QUESTION("Question"),INCIDENT("Incident"), PROBLEM("Problem"),FEATUREREQUEST("Feature Request"),LEAD("Lead"),TASK("Task");

	private final String value;
	private TYPE(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}