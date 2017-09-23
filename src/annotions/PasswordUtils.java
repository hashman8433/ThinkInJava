/**
 * 
 */
package annotions;

import java.util.List;

/**
 * ClassName:PasswordUtils.java
 * Reason:	 TODO ADD REASON
 *
 * @author   zhaozj
 * @since    Ver 1.1
 * @Date	 2017年9月23日
 */
public class PasswordUtils {
	@UseCase(id = 47, description = 
	"Passwords must contain at least one numeric")
	public boolean validatePassword(String password){
		return (password.matches("\\w*\\d\\w*"));
	}
	
	@UseCase(id = 48)
	public String encrypyPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id = 49, description = 
			"New passwords can't equal previonsly used ones")
	public boolean checkForNewPassword(
			List<String> prevPasswords, String password){
		return !prevPasswords.contains(password);
	}
}
