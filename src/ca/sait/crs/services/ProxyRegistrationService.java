package ca.sait.crs.services;

import java.util.ArrayList;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.Registration;
import ca.sait.crs.contracts.RegistrationService;
import ca.sait.crs.contracts.Student;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;
import ca.sait.crs.factories.RegistrationFactory;

public final class ProxyRegistrationService implements RegistrationService {

	private RealRegistrationService realRegistrationService = new RealRegistrationService();
	@Override
	public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
		// TODO Auto-generated method stub
		
		if (studentIsEligible(student, course)) {
			Registration register = realRegistrationService.register(student, course);
			return register;
		}
		else {
			throw new CannotCreateRegistrationException("Student doesn't meet gpa requirements");
		}
	}

	public ProxyRegistrationService(RealRegistrationService rrs){
		this.realRegistrationService = rrs;
	}
	@Override
	public ArrayList<Registration> getRegistrations() {
		// TODO Auto-generated method stub
		return realRegistrationService.getRegistrations();
	}
	
	private boolean studentIsEligible(Student student, Course course) {
		RegistrationFactory rf = new RegistrationFactory();
		try {
			rf.build(course, student);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
// TODO: Define the ProxyRegistrationService
// TODO: Implement the RegistrationService interface
// TODO: Check student can be registered before passing to RealRegistrationService
// TODO: Make this class immutable.
