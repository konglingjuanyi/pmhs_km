package cn.net.tongfang.framework.security;

public class ServiceAuthorization {
	private String methodPattern; // 方法的匹配模式定义
	private String[] authorities; // 模块id

	public ServiceAuthorization(String methodPattern, String[] authorities) {
		this.methodPattern = methodPattern;
		this.authorities = authorities;
	}

	public String getMethodPattern() {
		return methodPattern;
	}

	public void setMethodPattern(String methodPattern) {
		this.methodPattern = methodPattern;
	}

	public String[] getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String[] authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("methodPattern: " + methodPattern).append("\n")
		.append("authorities: \n");
		for(String au : authorities) {
			sb.append(au).append(" ");
		}		
		return sb.toString();
	}

}
