package controller;

import view.InputView;

public class Controller {
    public void getParticipantNames() {
        String names = InputView.getParticipantInputMessage();
        System.out.println(names);
    }
}
