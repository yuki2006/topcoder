import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * The stats for a problem.
 */
public class ProblemStats implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int COLUMN_CLASS_NAME = 0;

	public static final int COLUMN_CONTEST_NAME = 1;

	public static final int COLUMN_DATE = 2;

	public static final int COLUMN_DIVISION = 3;

	public static final int COLUMN_LEVEL = 4;

	public static final int COLUMN_SUCCESS_RATE = 5;

	public static final int COLUMN_CATEGORIES = 6;

	static final String[] COLUMN_NAMES = { Messages.columnNameClassName,
			Messages.columnNameContestName, Messages.columnNameDate,
			Messages.columnNameDivision, Messages.columnNameLevel,
			Messages.columnNameSuccessRate, Messages.columnNameCategories };

	String categories;

	String className;

	String contestDate;

	String contestName;

	int div1Level;

	double div1Succ;

	int div2Level;

	double div2Succ;

	int problemId;

	int roundId;

	int submissions;

	public ProblemStats() {
		// to allow instantiation during deserialization
	}

	public ProblemStats(String className, int problemId, int roundId,
			String contestName, String contestDate, String categories,
			int div1Level, double div1Succ, int div2Level, double div2Succ) {
		this.className = className;
		this.roundId = roundId;
		this.problemId = problemId;
		this.contestName = contestName;
		this.contestDate = contestDate;
		this.categories = categories;
		this.div1Level = div1Level;
		this.div1Succ = div1Succ;
		this.div2Level = div2Level;
		this.div2Succ = div2Succ;
	}

	public int compareTo(ProblemStats other, int column) {
		switch (column) {
		case COLUMN_CLASS_NAME:
		case COLUMN_CONTEST_NAME:
		case COLUMN_DATE:
		case COLUMN_CATEGORIES:
			return getFieldString(column).compareTo(
					other.getFieldString(column));
		case COLUMN_DIVISION:
			return getDivisionString().compareTo(other.getDivisionString());
		case COLUMN_SUCCESS_RATE:
			return getSuccessRateString().compareTo(
					other.getSuccessRateString());
		case COLUMN_LEVEL:
			return getLevelString().compareTo(other.getLevelString());
		default:
			System.out.println("ERROR IN COMPARETO: " + column); //$NON-NLS-1$
			return 0;
		}
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof ProblemStats && ((ProblemStats) other)
				.getProblemId() == getProblemId());
	}

	public String getCategories() {
		return categories;
	}

	public String getClassName() {
		return className;
	}

	public String getContestDate() {
		return contestDate;
	}

	public String getContestName() {
		return contestName;
	}

	public int getDiv1Level() {
		return div1Level;
	}

	public double getDiv1Succ() {
		return div1Succ;
	}

	public int getDiv2Level() {
		return div2Level;
	}

	public double getDiv2Succ() {
		return div2Succ;
	}

	public String getFieldString(int which) {
		switch (which) {
		case COLUMN_CLASS_NAME:
			return className;
		case COLUMN_CONTEST_NAME:
			return contestName;
		case COLUMN_DATE:
			return contestDate;
		case COLUMN_DIVISION:
			return getDivisionString();
		case COLUMN_SUCCESS_RATE:
			return getSuccessRateString();
		case COLUMN_LEVEL:
			return getLevelString();
		case COLUMN_CATEGORIES:
			return categories;
		default:
			return "DEFAULT"; //$NON-NLS-1$
		}
	}

	private String getDivisionString() {
		if (div1Level < 0) {
			return "2"; //$NON-NLS-1$
		} else if (div2Level < 0) {
			return "1"; //$NON-NLS-1$
		} else {
			return "1 & 2"; //$NON-NLS-1$
		}
	}

	private String getSuccessRateString() {
		if (div1Level < 0) {
			return String.valueOf(div2Succ);
		} else if (div2Level < 0) {
			return String.valueOf(div1Succ);
		} else {
			return String.valueOf(div1Succ) + " & " + String.valueOf(div2Succ); //$NON-NLS-1$
		}
	}

	private String getLevelString() {
		if (div1Level < 0) {
			return String.valueOf(div2Level);
		} else if (div2Level < 0) {
			return String.valueOf(div1Level);
		} else {
			return String.valueOf(div1Level) + " & " //$NON-NLS-1$
					+ String.valueOf(div2Level);
		}
	}

	public String getHtmlProblemStatement() {
		return null;
	}

	public int getProblemId() {
		return problemId;
	}

	public int getRoundId() {
		return roundId;
	}

	public int getSubmissions() {
		return submissions;
	}

	@Override
	public int hashCode() {
		return problemId;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setContestDate(String contestDate) {
		this.contestDate = contestDate;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	public void setDiv1Level(int div1Level) {
		this.div1Level = div1Level;
	}

	public void setDiv1Succ(double div1Succ) {
		this.div1Succ = div1Succ;
	}

	public void setDiv2Level(int div2Level) {
		this.div2Level = div2Level;
	}

	public void setDiv2Succ(double div2Succ) {
		this.div2Succ = div2Succ;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}

	public void setSubmissions(int submissions) {
		this.submissions = submissions;
	}

	@Override
	public String toString() {
		return "Problem[className=" + className + ",problemId=" + problemId //$NON-NLS-1$ //$NON-NLS-2$
				+ getFieldString(COLUMN_CONTEST_NAME) + "," + getDiv2Level() + "]"; //$NON-NLS-1$
	}

	/**
	 * @param commentList
	 * @return
	 */
	public String toCSVString(List<CommentStats> commentList) {
		StringBuilder builder = new StringBuilder();
		builder.append(problemId + "," + className + "," + "2" + "," + div2Level + ",");

		for (CommentStats commnetStats : commentList) {
			if (commnetStats.getId() == problemId) {
				builder.append(commnetStats.getString() + "," + commnetStats.getLevel());
				return builder.toString();
			}
		}
		builder.append(",");
		return builder.toString();
	}

	/**
	 * @param commentList
	 * @param files
	 * @return
	 */
	public String toMDString(List<CommentStats> commentList, File[] files) {
		StringBuilder builder = new StringBuilder();
		builder.append(problemId+"|[" + className + "](http://community.topcoder.com/stat?c=problem_statement&pm=" + problemId
				+ ")" + "|" + getSRMNumber() + "|" + "2" + "|" + div2Level + "|");
		boolean hit = false;
		for (CommentStats commnetStats : commentList) {
			if (commnetStats.getId() == problemId) {
				builder.append(commnetStats.getString() + "|" + commnetStats.getLevel() + "|");
				hit = true;
			}
		}
		if (!hit) {
			builder.append("||");
		}
		for (File file : files) {
			if (file.getName().equals(className + ".java")) {
				builder.append("[ソース](https://github.com/yuki2006/topcoder/blob/master/src/" + className + ".java)");
			}
		}
		return builder.toString();
	}

	public String getSRMNumber() {
		return contestName.replace("Member ", "").replace("SRM ", "");
	}

}