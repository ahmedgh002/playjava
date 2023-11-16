package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Retourner une chaîne de caractère qui contient tous les noms des employés */
		String names = employees.stream()
				.map(Employee::getName)
				.collect(Collectors.joining(", ")); // Concatenate names using a delimiter

		/* TO DO 2: Retourner une chaîne de caractère qui contient tous les noms des employés en majuscule séparés par # */
		String namesMajSplit = employees.stream()
				.map(Employee::getName)
				.map(String::toUpperCase)
				.collect(Collectors.joining(" # ")); // Uppercase names and join using #

		/* TO DO 3: Retourner un set d'employés */
		Set<Employee> emps = employees.stream().collect(Collectors.toSet());

		/* TO DO 4: Retourner un TreeSet d'employés (tri par nom) */
		TreeSet<Employee> emps2 = employees.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));

		/* TO DO 5: Retourner une Map qui regroupe les employés par salaire */
		Map<Integer, List<Employee>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary));

		/* TO DO 6: Retourner une Map qui regroupe les noms des employés par salaire */
		Map<Integer, String> mm = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary,
						Collectors.mapping(Employee::getName, Collectors.joining(", "))));

		/* TO DO 7: Retourner le min, max, average, sum, count des salaires */
		String s = employees.stream()
				.mapToDouble(Employee::getSalary)
				.summaryStatistics()
				.toString();
		System.out.println("noms: " + names);
		System.out.println("nom en maj: " + namesMajSplit);
		System.out.println("employees: " + emps);
		System.out.println("Tree employees: " + emps2);
		System.out.println("Employees salaire: " + map);
		System.out.println("noms salaire: " + mm);
		System.out.println("Salary statistics: " + s);
	}
}