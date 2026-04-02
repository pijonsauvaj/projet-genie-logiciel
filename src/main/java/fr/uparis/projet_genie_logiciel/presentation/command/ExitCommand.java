package fr.uparis.projet_genie_logiciel.presentation.command;

public class ExitCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Goodbye!");
		System.exit(0);
	}

	@Override
	public String getName() {
		return "exit";
	}

	@Override
	public String getDescription() {
		return "Exit the program";
	}
}