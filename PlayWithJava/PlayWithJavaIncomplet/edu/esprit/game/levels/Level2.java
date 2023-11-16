package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Level2 {
	public static void main(String[] args) {
	List<Employee> employees = Data.employees();

	/* TO DO 1: Retourner le nombre des employ�s dont le nom commence avec n */
	long nbr = employees.stream().filter(e -> e.getName().startsWith("n")).count(); /*TO DO 1 */
				
	/* TO DO 2: Retourner la somme des salaires de tous les employ�s (hint: mapToInt) */	
	long sum = employees.stream().mapToLong(Employee::getSalary).sum();/* TO DO 2 */;
		
	/* TO DO 3: Retourner la moyenne des salaires des employ�s dont le nom commence avec s */	
	double average = employees.stream().filter(e -> e.getName().startsWith("s")).mapToDouble(Employee::getSalary).average().orElse(0.0);/* TO DO 3 */;
		
		
	/* TO DO 4: Retourner la liste de tous les employ�s  */	
	List<Employee> emps = employees.stream().toList();/* TO DO 4 */;
		
		/* TO DO 5: Retourner la liste des employ�s dont le nom commence par s */
		List<Employee> emps2 = employees.stream().filter(e -> e.getName().startsWith("s")).toList();/* TO DO 5 */;
		
		
	/* TO DO 6: Retourner true si il y a au min un employ�s dont le salaire > 1000, false si non
	*/
	boolean test = employees.stream().anyMatch(e -> e.getSalary() > 1000);/* TO DO 6 */
				
	/* TO DO 7: Afficher le premier employ� dont le nom commence avec s avec deux mani�res diff�rentes */
	/*First way*/
	employees.stream().filter(e -> e.getName().startsWith("s")).findFirst().ifPresent(System.out::println);/* TO DO 7 */
	/*Second way*/
	employees.stream().filter(e -> e.getName().startsWith("s")).limit(1).forEach(System.out::println);/* TO DO 7 */
		
	/* TO DO 8: Afficher le second employ� dont le nom commence avec s */
	employees.stream().filter(e -> e.getName().startsWith("s")).limit(1).forEach(System.out::println);/* TO DO 8 */
		

	}
}
