package controller;

import command.LoginCommand;
import command.MemberService;
import command.UpdateCommand;

public class ServiceMapper {

	private static ServiceMapper instance=new ServiceMapper();
	private ServiceMapper() {}
	public static ServiceMapper getInstance() {
		if(instance==null) {
			instance=new ServiceMapper();
		}
		return instance;
	}
	
	
	public MemberService getCommand(String cmd) {
		MemberService command=null;
		switch (cmd) {
		case "login.do":
			command=new LoginCommand();
			break;
		case "update.do":
			command=new UpdateCommand();
			break;
		
		}
		
		return command;
	}
	
	
	
	
	
	
}
