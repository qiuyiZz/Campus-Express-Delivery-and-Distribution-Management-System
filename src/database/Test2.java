package database;

import java.util.Timer;

import problem.Timer_CheckProblem;
import problem.Timer_CheckReceived;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer=new Timer();
		timer.schedule(new Timer_CheckReceived(),1000,30000);
		timer.schedule(new Timer_CheckProblem(),4000,30000);
	}

}
