package fr.uparis.projet_genie_logiciel.presentation.command;

public interface Command {
    void execute();
    String getName();
    String getDescription();
}