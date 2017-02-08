package org.raescott.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public class App {

	public static void main(String[] args) {
		String aString = "https://localhost:8443/ccc-assess/placement-service/service/";
		Pattern pattern = Pattern.compile("http\\w??://.*?/"); // reluctant matching, once or not at all on .*?
		System.out.println(aString);
		Matcher matcher = pattern.matcher(aString);
		if (matcher.find()) { // Must be executed before a group is called.  Put it in an if block to avoid causing an exception from group.
			String results = matcher.group();
			if (results.endsWith("/")) {
				results = results.substring(0, results.length() - 1);
			}
			System.out.println("********************************************************************************");
			System.out.println(results);
		} else {
			System.out.println("No Matches");
		}
	}
}
