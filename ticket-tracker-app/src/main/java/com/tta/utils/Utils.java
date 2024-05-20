package com.tta.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	public static String formatdate(LocalDate date) {
		// Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

        // Format the date using the formatter
        return date.format(formatter);
	}

}
