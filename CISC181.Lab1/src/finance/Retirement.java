package finance;

import java.util.Scanner;

public class Retirement {
	public static void main(String args[]) {
		//Create a person to be filled with values
		User_data person = new User_data();
		//Ask for values and input them to person
		person = getValues(person);
		//Calculate the total savings needed to retire
		Double total_savings = calculate_savings(person);
		//calculate the savings needed each month to retire
		Double save_each_month = calculate_amount_to_save(person, total_savings);
		//Print these values
		System.out.print("Based on your current situation, you must save $");
		System.out.printf("%.2f", total_savings);
		System.out.print(" over then next " + person.getYears_to_work() + " year(s) in order "
				+ "to retire");
		System.out.print("\n");
		System.out.print("That equates to saving $");
		System.out.printf("%.2f", save_each_month);
		System.out.print(" every month"
				+ " at " + person.getAnnual_return_before() + "% annual interest.");		
		
	}
	
	public static User_data getValues (User_data person) {
		
		Scanner user_input = new Scanner(System.in);

		//Ask the user for every value necessary to compute
		//money needed
		System.out.print("Enter your years to work: ");
		Double years_to_work = user_input.nextDouble();
		person.setYears_to_work(years_to_work);
		
		System.out.print("Enter your annual return before retirement: ");
		Double annual_return_before = user_input.nextDouble();
		person.setAnnual_return_before(annual_return_before);
		
		System.out.print("Enter how many years you will be retired: ");
		Double years_retired = user_input.nextDouble();
		person.setYears_retired(years_retired);

		System.out.print("Enter your annual return after retirement: ");
		Double annual_return_after = user_input.nextDouble();
		person.setAnnual_return_after(annual_return_after);

		System.out.print("Enter your required income after retirment: ");		
		Double required_income = user_input.nextDouble();
		person.setRequired_income(required_income);
		
		System.out.print("Enter your Monthly SSI :");
		Double monthly_ssi = user_input.nextDouble();
		person.setMonthly_ssi(monthly_ssi);
		
		
		user_input.close();
		return(person);
		
	}
	public static Double calculate_savings(User_data new_person){
		   Double total_savings = (new_person.getRequired_income() - new_person.getMonthly_ssi())*((1-(1/
				   (Math.pow(1+(new_person.getAnnual_return_after()/100)/12,new_person.getYears_retired()*12 )))))
				   /((new_person.getAnnual_return_after()/100)/12);
		   return total_savings;
	}
	
	public static Double calculate_amount_to_save(User_data new_person, Double total_savings){
		Double save_each_month = total_savings *(((new_person.getAnnual_return_before()/100)/12)
				/((Math.pow(1+(new_person.getAnnual_return_before()/100)/12, new_person.getYears_to_work()*12))-1));
		return save_each_month;
	}//end main
}//end Retirement