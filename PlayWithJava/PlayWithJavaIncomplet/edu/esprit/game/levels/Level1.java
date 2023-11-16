package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.Comparator;
import java.util.List;

public class Level1 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Afficher tous les employ�s */
		employees.stream().forEach(employee -> System.out.println(employee.toString()));

		/*
		 * TO DO 2: Afficher les employ�s dont le nom commence par la lettre n
		 */
		employees.stream().filter(e -> e.getName().startsWith("n")).forEach(employee -> System.out.println(employee.toString()));

		/*
		 * TO DO 3: Afficher les employ�s dont le nom commence par la lettre n
		 * et le salaire> 1000
		 */
		employees.stream().filter(e -> e.getName().startsWith("n") && e.getSalary() > 1000)
				.forEach(employee -> System.out.println(employee.toString()));

		/*
		 * TO DO 4: Afficher les employ�s dont le nom commence par la lettre s
		 * tri�s par salaire
		 */
		employees.stream().filter(e -> e.getName().startsWith("s")).sorted(Comparator.comparingDouble(Employee::getSalary))
				.forEach(System.out::println);

		/*
		 * TO DO 5: Afficher les noms des employ�s dont le salaire > 600 avec 2
		 * mani�res diff�rentes
		 */
		/* First Way */
		employees.stream().filter(e -> e.getSalary() > 600).forEach(e -> System.out.println(e.getName()));
		/* Second Way */
		employees.stream().filter(e -> e.getSalary() > 600).map(Employee::getName).
				forEach(System.out::println);

		/*
		 * TO DO 6: Ajouter 200 D pour les employ�s dont le nom commence avec m
		 * et les affich�s ensuite
		 */
		employees.stream().filter(e -> e.getName().startsWith("m")).forEach(e -> {
			e.setSalary(e.getSalary() + 200);
			System.out.println(e);
		});

	}
}
