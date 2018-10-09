package tools;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
/**
 * 
 * @Title EncryptPropertyPlaceholderConfigurer.java
 * @Desription 对连接数据库的密码进行加密
 * @author 罗长城
 * @date 2017年9月19日
 */
public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	private String[] encryptPropNames = { "db.username", "db.password" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) {
			String decryptValue = DESUtils.getDecryptString(propertyValue);
			return decryptValue;
		} else {
			return propertyValue;
		}
	}

	/**
	 * 判断是否是加密的属�?
	 * 
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encryptPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
