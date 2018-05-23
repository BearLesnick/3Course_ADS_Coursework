package ua.com.khai.zaika.services.ServicesLoader.implementation;

import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import ua.com.khai.zaika.UI.StyleArray;
import ua.com.khai.zaika.services.ServicesLoader.interfaces.RegExpHandler;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpHandlerImpl implements RegExpHandler, StyleArray {
    @Override
    public List<Text> findTokens(String text, String regExpression) {
        boolean isAnyMatches = false;
        int regionStarted = 0;
        int regionEnded = 0;
        LinkedList<Text> tokens = new LinkedList<>();
        Pattern regexp = Pattern.compile(regExpression);
        Matcher matcher = regexp.matcher(text);
        while (matcher.find()) {
            isAnyMatches = true;
            String beforehand = text.substring(regionStarted, matcher.start());
            tokens.add(new Text(beforehand));
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            regionEnded = matcher.end();
            regionStarted = regionEnded;
            int count = matcher.groupCount();
            if (count == 0) {//if it is no groups splited
                Text token = new Text();
                token.setFill(Paint.valueOf(styles[0]));
                token.setText(matcher.group());
                tokens.add(token);
            } else {//if it is 1 or more splitted groups
                for (int i = 1; i < count + 1; i++) {
                    Text token = new Text();
                    token.setFill(Paint.valueOf(styles[(i - 1 % styles.length)]));
                    token.setText(matcher.group(i));
                    tokens.add(token);
                }
            }


        }
        if (isAnyMatches) {
            tokens.add(new Text(text.substring(regionEnded)));
        }
        if (!isAnyMatches) {
            tokens.add(new Text(text));
        }
        return tokens;
    }
}
