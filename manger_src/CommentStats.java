/**
 * 
 */

/**
 * @author yuki
 *
 */
public class CommentStats {

	private int id;

	/**
	 * @return id
	 */
	public final int getId() {
		return this.id;
	}

	/**
	 * @return string
	 */
	public final String getString() {
		return this.string;
	}

	/**
	 * @return level
	 */
	public final int getLevel() {
		return this.level;
	}

	private String string;
	private int level;

	/**
	 * @param valueOf
	 * @param valueOf2
	 * @param string
	 */
	public CommentStats(Integer id, Integer level, String string) {
		this.id = id;
		this.level = level;
		this.string = string;
	}

}
