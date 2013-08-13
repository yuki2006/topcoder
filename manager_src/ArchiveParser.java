import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author yuki
 * 
 */
public class ArchiveParser {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ArchiveParser archiveParser = new ArchiveParser();
		List<CommentStats> commentList = archiveParser.getCommentList();
		List<ProblemStats> problemStatsList = archiveParser.getProblemStatsList();

		Comparator<ProblemStats> s = new Comparator<ProblemStats>() {
			@Override
			public int compare(ProblemStats paramT1, ProblemStats paramT2) {
				int to = -paramT1.getSRMNumber().compareTo(paramT2.getSRMNumber());
				if (to == 0) {
					return paramT1.getDiv2Level() > paramT2.getDiv2Level() ? 1 : -1;
				}
				return to;
			}
		};
		Collections.sort(problemStatsList, s);

		File dir = new File("src");
		File[] files = dir.listFiles();

		PrintStream printStream = new PrintStream(new File("README.md"));
		printStream.println("ClassName|SRM|Div|Level| コメント | 自己評価|ソースコード|");
		printStream.println(":--|:--|:--|:--| :-- | :--|:--|");

		for (ProblemStats problemStats : problemStatsList) {
			if (problemStats.getContestName().contains("SRM")) {
				if (problemStats.getFieldString(ProblemStats.COLUMN_DIVISION).contains("2")) {
					printStream.println(problemStats.toMDString(commentList, files));
				}
			}
		}
		printStream.close();
	}

	public List<CommentStats> getCommentList() throws IOException
	{
		// FIXME: when to set this (breaks i.e. editorial fetching)?
		String data = readAll(new FileInputStream(new File("comment.txt")));
		ArrayList<CommentStats> list = new ArrayList<CommentStats>();
		for (String s : data.split("\n")) {
			String[] split = s.split(",");
			list.add(new CommentStats(Integer.valueOf(split[0]), Integer.valueOf(split[1]), split[2]));

		}
		return list;
	}

	// https://github.com/fornwall/eclipsecoder-archive/blob/master/src/net/fornwall/eclipsecoder/archive/ProblemScraper.java
	public List<ProblemStats> getProblemStatsList()
			throws Exception {
		String page = getPage("tc?module=ProblemArchive&sc=0&sd=asc&er=10000"); //$NON-NLS-1$

		page = page.substring(page.lastIndexOf("Success Rate") + 20, page //$NON-NLS-1$
				.lastIndexOf("&lt;&lt;")); //$NON-NLS-1$
		Matcher matcher = Pattern.compile("(?:statText|left|right)\">([^<>]*?)</").matcher(page); //$NON-NLS-1$
		List<ProblemStats> result = new ArrayList<ProblemStats>();

		Pattern roundIdPattern = Pattern.compile("rd=([0-9]*)"); //$NON-NLS-1$
		Pattern problemIdPattern = Pattern.compile("pm=([0-9]*)"); //$NON-NLS-1$

		while (matcher.find()) {
			String className = matcher.group(1).trim();

			Matcher idMatcher = roundIdPattern.matcher(page.substring(matcher
					.start()));
			idMatcher.find();
			int roundId = Integer.parseInt(idMatcher.group(1).trim());
			idMatcher = problemIdPattern.matcher(page.substring(
					matcher.start() - 50, matcher.start()));

			idMatcher.find();

			int problemId = Integer.parseInt(idMatcher.group(1).trim());
			matcher.find();
			String contestName = matcher.group(1).replace("&#039;", "'").trim(); //$NON-NLS-1$ //$NON-NLS-2$
			matcher.find();
			String contestDate = matcher.group(1).trim();
			// change from MM/DD/YYYY to YYYY.MM.DD
			String[] parts = contestDate.split("\\."); //$NON-NLS-1$
			contestDate = parts[2] + "." + parts[0] + "." + parts[1]; //$NON-NLS-1$ //$NON-NLS-2$
			matcher.find();
			if (matcher.group(1).trim().length() == 0) {
				// empty writer column - just skip. If it was non-empty there
				// would be no match and
				// we would move on to the categories column (which is never
				// empty)
				matcher.find();
			}

			String categories = matcher.group(1).trim();

			matcher.find();
			int div1Level = tryParseInt(matcher.group(1));

			matcher.find();
			double div1Succ = tryParsePercentage(matcher.group(1));

			matcher.find();
			int div2Level = tryParseInt(matcher.group(1));

			matcher.find();
			double div2Succ = tryParsePercentage(matcher.group(1));

			matcher.find();

			ProblemStats problem = new ProblemStats(className, problemId,
					roundId, contestName, contestDate, categories, div1Level,
					div1Succ, div2Level, div2Succ);
			result.add(problem);
		}

		return result;
	}

	private static String readAll(InputStream in) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
			builder.append('\n');
		}
		return builder.toString();
	}

	private String getPage(String path) throws Exception {
		URL url = new URL("http://community.topcoder.com/" + path); //$NON-NLS-1$
		// URL url = new URL("http://localhost/topcoder/ProblemArchive.htm");
		URLConnection connection = url.openConnection();
		// FIXME: when to set this (breaks i.e. editorial fetching)?
		return readAll(connection.getInputStream());
	}

	/**
	 * Parse a string containing a double followed by a percentage, optionally
	 * surrounded with whitespace.
	 * 
	 * @param percentageString
	 *            the string to parse a percentage from
	 * @return the percentage value as a double or -1 if the percentageString is
	 *         blank
	 */
	private static double tryParsePercentage(String percentageString) {
		percentageString = percentageString.trim();
		if (percentageString.length() > 0) {
			// remove trailing percentage character
			percentageString = percentageString.substring(0, percentageString
					.length() - 1);
			return Double.parseDouble(percentageString);
		}
		return -1;
	}

	/**
	 * Try to parse a string containing an integer, optionally surrounded with
	 * whitespace.
	 * 
	 * @param intString
	 *            the string to try to parse an int from
	 * @return the int value or -1 if the string is blank
	 */
	private static int tryParseInt(String intString) {
		intString = intString.trim();
		if (intString.length() > 0) {
			return Integer.parseInt(intString);
		}
		return -1;
	}
}
