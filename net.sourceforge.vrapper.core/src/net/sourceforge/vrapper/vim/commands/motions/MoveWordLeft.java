package net.sourceforge.vrapper.vim.commands.motions;

import static net.sourceforge.vrapper.vim.commands.Utils.characterType;
import net.sourceforge.vrapper.vim.commands.BorderPolicy;

public class MoveWordLeft extends MoveLeftWithBounds {

    protected MoveWordLeft(boolean bailOff) {
        super(bailOff);
    }

    public static final MoveWordLeft INSTANCE = new MoveWordLeft(false);
    public static final MoveWordLeft BAILS_OFF = new MoveWordLeft(true);

    @Override
    protected boolean atBoundary(char c1, char c2) {
        return !Character.isWhitespace(c2) && characterType(c1, keywords) != characterType(c2, keywords);
    }

    public BorderPolicy borderPolicy() {
        return BorderPolicy.EXCLUSIVE;
    }

    @Override
    protected boolean shouldStopAtLeftBoundingChar() {
        return false;
    }

    @Override
    protected boolean stopsAtNewlines() {
        return true;
    }

}
