package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PAYEE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PAYER;

import seedu.address.model.transaction.Transaction;

/**
 * Adds a transaction to the address book.
 */
public class AddTransactionCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "addTransaction";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a new transaction to the address book. "
            + "Parameters: "
            + PREFIX_PAYER + "PAYER NAME "
            + PREFIX_AMOUNT + "AMOUNT "
            + PREFIX_DESCRIPTION + "DESCRIPTION "
            + PREFIX_PAYEE + "PAYEE NAME \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_PAYER + "John Doe "
            + PREFIX_AMOUNT + "3456.78 "
            + PREFIX_DESCRIPTION + "for dinner meal "
            + PREFIX_PAYEE + "Tom Riddle ";

    public static final String MESSAGE_SUCCESS = "New transaction added";

    private final Transaction toAdd;

    /**
     * Creates an AddTransactionCommand to add the specified {@code Transaction}
     */
    public AddTransactionCommand(Transaction transaction) {
        requireNonNull(transaction);
        toAdd = transaction;
    }

    @Override
    public CommandResult executeUndoableCommand() {
        requireNonNull(model);
        model.addTransaction(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddTransactionCommand// instanceof handles nulls
                && toAdd.equals(((AddTransactionCommand) other).toAdd));
    }
}