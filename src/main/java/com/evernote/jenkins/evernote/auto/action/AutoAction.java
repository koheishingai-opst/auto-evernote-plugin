package com.evernote.jenkins.evernote.auto.action;

import java.io.PrintStream;

import com.evernote.edam.type.Note;
import com.evernote.jenkins.evernote.auto.Messages;
import com.evernote.jenkins.plugin.Autable;
import com.evernote.jenkins.plugin.Autable.NullAutable;
import com.evernote.jenkins.plugin.Guid;
import com.evernote.jenkins.plugin.NoteStoreWrapper;

public interface AutoAction {

    public String key();

    public void doProcess(Note note, String guid);

    public void printLog(PrintStream printStream);

    public String description();

    public Autable resolve(NoteStoreWrapper noteStore, Guid guid);

    public static class NullAction implements AutoAction {

        private final static NullAction INSTANCE = new NullAction();

        /**
         * インスタンス化を抑制。
         */
        private NullAction() {
            // NOP
        }

        public static NullAction getInstance() {
            return INSTANCE;
        }

        @Override
        public String key() {
            return null;
        }

        @Override
        public void doProcess(Note note, String guid) {
            // NOP
        }

        @Override
        public void printLog(PrintStream printStream) {
            printStream.println("No operation.");
        }

        @Override
        public String description() {
            return Messages.AutoEvernote_action_description_null();
        }

        @Override
        public Autable resolve(NoteStoreWrapper noteStore, Guid guid) {
            return NullAutable.getInstance();
        }
    }
}
