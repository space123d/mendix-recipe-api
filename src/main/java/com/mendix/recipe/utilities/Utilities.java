package com.mendix.recipe.utilities;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utilities {

	private Utilities() {
	}

	public static UUID byteArrayToUUID(byte[] binaryUuid) {
		if (binaryUuid == null) {
			return null;
		}

		ByteBuffer bb = ByteBuffer.wrap(binaryUuid);
		long high = bb.getLong();
		long low = bb.getLong();
		return new UUID(high, low);
	}

	public static byte[] UUIDToByteArray(UUID uuid) {
		if (uuid == null) {
			return null;
		}

		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());

		return bb.array();
	}

	public static Instant toInstantStartOfDay(LocalDate date) {
		return date.atStartOfDay(ZoneOffset.UTC).toInstant();
	}

	public static Instant toInstant(LocalDateTime dateTime) {
		return dateTime.toInstant(ZoneOffset.UTC);
	}

	public static OffsetDateTime toOffsetDateTime(LocalDateTime dateTime) {
		return OffsetDateTime.of(dateTime, ZoneOffset.UTC);
	}

	public static LocalDate toLocalDate(Instant instant) {
		return LocalDate.ofInstant(instant, ZoneOffset.UTC);
	}

	public static LocalDate previousDayOfInstant(Instant instant) {
		Instant previousDay = instant.minus(1, ChronoUnit.DAYS);

		return LocalDate.ofInstant(previousDay, ZoneOffset.UTC);
	}

	public static LocalDateTime toLocalDateTime(Instant instant) {
		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
	}

	public static <T extends Object> List<T> toList(Set<T> input) {
		return new ArrayList<>(input);
	}

	public static <T extends Object> Set<T> toSet(List<T> input) {
		return new HashSet<>(input);
	}

}
