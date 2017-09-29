package hidden.annotions.database;

/**
 * ClassName:Member.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月23日
 */
@DBTable(name = "member")
public class Member {
	@SQLString(value = 30) 
	String firstName;
	@SQLString(value = 50)
	String lastName;
	@SQLInteger
	Integer age;
	@SQLString(value = 30,
			constraints = @Constraints(primaryKey = true))
	String handle;
	static int memberCount;
	public String getHandle(){ return handle;}
	public String getFirstName(){ return firstName;}
	public String getLastName(){ return lastName;}
	public String toString(){ return handle;}
	public Integer getAge(){ return age;}
	
	
}
