package org.dougllas.mvcp.view;

/**
 * Criado por dougllas.sousa em 14/06/2017.
 */
public class ViewMessage {

    private String message;
    private MessageSeverity severity;

    public ViewMessage() {
    }

    public ViewMessage(String message) {
        this.message = message;
    }

    public ViewMessage(MessageSeverity severity) {
        this.severity = severity;
    }

    public ViewMessage(String message, MessageSeverity severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(MessageSeverity severity) {
        this.severity = severity;
    }

    public static ViewMessage infoMessage(String message){
        return new ViewMessage(message, MessageSeverity.INFO);
    }

    public static ViewMessage warnMessage(String message){
        return new ViewMessage(message, MessageSeverity.WARN);
    }

    public static ViewMessage dangerMessage(String message){
        return new ViewMessage(message, MessageSeverity.DANGER);
    }

    public static ViewMessage sucessMessage(String message){
        return new ViewMessage(message, MessageSeverity.SUCCESS);
    }
}
