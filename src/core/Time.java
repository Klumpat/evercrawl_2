package core;

public class Time {

	static float timer = 0; // The Timer were adding delta Time to calculate the
						// gameTime

	public static float modifier = 100.0f; // determines how much faster the gameTime
									// is running
	public float delta = 0.0f;

	public static int startMinute = 0; // The Minute the game starts - in
										// GameTime
	public static int startHour = 12; // The Hour the game starts - in GameTime
	public static int startDay = 29; // The Day the game starts - in GameTime
	public static int startMonth = 12; // The Month the game starts - in
										// GameTime
	public static int startYear = 1337; // The Year the game starts - in
										// GameTime

	private static int maxMinute = 60;
	private static int maxHour = 24;
	private static int maxDay = 30;
	private static int maxMonth = 12;
	private static int maxYear = 9999;

	public static int currentMinute;
	public static int currentHour;
	public static int currentDay;
	public static int currentMonth;
	public static int currentYear;

	public static void start() {
		currentMinute = startMinute;
		currentHour = startHour;
		currentDay = startDay;
		currentMonth = startMonth;
		currentYear = startYear;
	}

	static void update (float delta) {
		timer += delta * modifier;
		calcTime();
	}

	public static String getCurrentGameTimeAndDate() {
		return "Time: " + currentHour + ":" + currentMinute + " Date: " + currentDay + ". " + currentMonth + ". " + currentYear;
	}

	public static String getCurrentGameTime() {
		return currentHour + ":" + currentMinute;
	}

	public static String getCurrentGameDate() {
		return currentDay + ". " + currentMonth + ". " + currentYear;
	}

	private static void calcTime() {
		if (timer >= maxMinute) {
			currentMinute++;
			timer -= maxMinute;
		}
		if (currentMinute == maxMinute) {
			currentMinute = 0;
			currentHour++;
		}
		if (currentHour == maxHour) {
			currentHour = 0;
			currentDay++;
		}
		if (currentDay > maxDay) {
			currentDay = 1;
			currentMonth++;
		}
		if (currentMonth > maxMonth) {
			currentMonth = 1;
			currentYear++;
		}
		if (currentYear > maxYear) {
			currentYear = 0;
		}

	}
	
	public static int getCurrentHour() {
		return currentHour;
	}

	public static String getTimeMS() {
		// TODO Auto-generated method stub
		return ""+System.currentTimeMillis();
	}
}
