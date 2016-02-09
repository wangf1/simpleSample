package com.wangf.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Random;
import java.util.Set;

public class NewTimeAPIConcepts {

	private void instantAndDuration() throws InterruptedException {
		Instant start = Instant.now();
		int sleepMilliseconds = new Random().nextInt(1000);
		System.out.println("To sleep " + sleepMilliseconds + " milliseconds.");
		Thread.sleep(sleepMilliseconds);
		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		long millis = duration.toMillis();
		System.out.println(millis);
	}

	private void localDateAndPeriod() {
		LocalDate now = LocalDate.now();
		LocalDate dateOfBirth = LocalDate.of(1980, Month.AUGUST, 31);
		Period period = dateOfBirth.until(now);
		System.out.println("Age: " + period.getYears());
		long inDays = dateOfBirth.until(now, ChronoUnit.DAYS);
		System.out.println("How many days: " + inDays);
	}

	private void dateAdjuster() {
		LocalDate now = LocalDate.now();
		LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("Now: " + now);
		System.out.println("Next Sunday: " + nextSunday);
	}

	private void localTimeConcept() {
		LocalTime now = LocalTime.now();
		LocalTime tenAndTwenty = LocalTime.of(10, 20);
		LocalTime fifteenAndTwenty = tenAndTwenty.plusHours(5);
		System.out.println(now);
		System.out.println(tenAndTwenty);
		System.out.println(fifteenAndTwenty);
	}

	private void zonedTimeConcept() {
		Set<String> allZonesIds = ZoneId.getAvailableZoneIds();
		System.out.println("IANA database has " + allZonesIds.size() + " time zones.");
		ZoneId londonTimeZone = ZoneId.of("Europe/London");
		System.out.println(londonTimeZone);
		ZonedDateTime londonNow = ZonedDateTime.now(londonTimeZone);
		System.out.println(londonNow);
		ZonedDateTime beijingNow = londonNow.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
		LocalDateTime beijingLocal = beijingNow.toLocalDateTime();
		System.out.println(beijingLocal);
	}

	private void formatDateTime() {
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("US/Central"));
		System.out.println(now);
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(now));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(now));
	}

	public static void main(String[] args) throws InterruptedException {
		NewTimeAPIConcepts concepts = new NewTimeAPIConcepts();
		concepts.instantAndDuration();
		concepts.localDateAndPeriod();
		concepts.dateAdjuster();
		concepts.localTimeConcept();
		concepts.zonedTimeConcept();
		concepts.formatDateTime();
	}
}
