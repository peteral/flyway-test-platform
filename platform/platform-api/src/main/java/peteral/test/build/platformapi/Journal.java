package peteral.test.build.platformapi;

public interface Journal {
	void log(String message, String... parameter);
	
	String LOOKUP = "java:global/platform-war/JournalBean!peteral.test.build.platformapi.Journal";
}
