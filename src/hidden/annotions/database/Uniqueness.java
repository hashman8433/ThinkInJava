package hidden.annotions.database;

/**
 * ClassName:Uniqueness.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月23日
 */
public @interface Uniqueness {
	Constraints constraints()
		default @Constraints(unique = true);
}
