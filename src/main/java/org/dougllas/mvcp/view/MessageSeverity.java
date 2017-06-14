package org.dougllas.mvcp.view;

/**
 * Criado por dougllas.sousa em 14/06/2017.
 */
public enum MessageSeverity {

    INFO("info"),
    WARN("warning"),
    SUCCESS("success"),
    DANGER("danger");

    private String level;

    MessageSeverity(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
