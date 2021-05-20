package me.internalizable.lab.utils;

import me.internalizable.lab.utils.cli.FormatMarkdown;

import java.util.List;

public class StaticUtils {

    public static String transformToFormattedString(List<String> list) {
        if(list == null || list.isEmpty())
            return "-";

        StringBuilder formattedString = new StringBuilder();

        for(String subString : list)
            formattedString.append("\n\t- ").append(subString);

        return formattedString.toString();
    }

    /**
     * A method that gets the formatted divider of our CLI.
     *
     * @return the formatted divider used in CLI.
     */
    public static String getDivider() {
        return getFormattedText("---------------------------------------------", FormatMarkdown.STRIKETHROUGH);
    }

    /**
     * Format our text in the command line given the markdown.
     *
     * @param text     - The text that will be converted.
     * @param markdown - The markdown type to apply.
     * @return formatted text.
     */
    public static String getFormattedText(String text, FormatMarkdown markdown) {
        return "\033[" + markdown.getCode() + "m" + text + "\033[0m";
    }
}
