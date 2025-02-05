package testdata.pojoData.orangeHRM;

public class EmployeeInfo {
	
	private String employeeID;
	private String firstName;
	private String lastName;
	private String nickName;
	private String ssnNumber;
	private String sinNumber;
	private String dateOfBirth;
	private String genderStatus;
	private String smockerStatus;
	private String nationality;
	private String maritalStatus;
	private String driverLicenseNumber;
	private String licenseExpiryDate; 
	
	public static EmployeeInfo getImployee() {
		return new EmployeeInfo();
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSsnNumber() {
		return ssnNumber;
	}
	public void setSsnNumber(String ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	public String getSinNumber() {
		return sinNumber;
	}
	public void setSinNumber(String sinNumber) {
		this.sinNumber = sinNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGenderStatus() {
		return genderStatus;
	}
	public void setGenderStatus(String genderStatus) {
		this.genderStatus = genderStatus;
	}
	public String getSmockerStatus() {
		return smockerStatus;
	}
	public void setSmockerStatus(String smockerStatus) {
		this.smockerStatus = smockerStatus;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}
	public String getLicenseExpiryDate() {
		return licenseExpiryDate;
	}
	public void setLicenseExpiryDate(String licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	
}
