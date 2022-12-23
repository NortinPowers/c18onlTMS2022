package by.tms.service;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.tms.utils.Constants.*;

public class TextFormatter {
    public boolean isPalindrome(@NonNull String word) {
        return word.equalsIgnoreCase(StringUtils.reverse(word))
                && word.toLowerCase().matches("[a-zа-я]{2,}");
    }

    public int getNumberOfWordsInString(@NonNull String string) {
        return string.split(" ").length;
    }

    public boolean checkPalindromeWordInString(@NonNull String string) {
        for (String srt : string.split(REGEX_NOT_LETTERS)) {
            if (isPalindrome(srt)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getStringsListBasedOnText(@NonNull String text) {
        return new ArrayList<>(Arrays.asList(text.split("[.?!]")));
    }

    public boolean checkStringLength(String string) {
        int numberOfWordsInString = getNumberOfWordsInString(string);
        return numberOfWordsInString >= MIN_NUMBER_OF_WORDS_IN_STRING
                && numberOfWordsInString <= MAX_NUMBER_OF_WORDS_IN_STRING;
    }

    public boolean isCensorNotPass(String string, List<String> censorList) {
        for (String word : string.split(REGEX_NOT_LETTERS)) {
            for (String censorWord : censorList) {
                if (censorWord.equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void createOutputTxtFileFromList(BufferedWriter writer, List<String> textList) throws IOException {
        for (String string : textList) {
            writer.write(string.trim() + "\n");
            writer.flush();
        }
    }

    public StringBuilder getStringBuilderFromInputTxt(BufferedReader reader) throws IOException {
        StringBuilder text = new StringBuilder();
        char[] strBuf = new char[MAX_WORDS_LENGTH];
        int readCount;
        while ((readCount = reader.read(strBuf)) != -1) {
            String readData = String.valueOf(strBuf, 0, readCount);
            text.append(readData);
        }
        return text;
    }

    public String getStringFromFileTxt(String inputFile) {
        StringBuilder text;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            text = getStringBuilderFromInputTxt(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }

    public void createFileTxtFromString(String outputFile, List<String> text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            createOutputTxtFileFromList(writer, text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getListStrFromInputTxt(String inputFile) {
        String word;
        List<String> wordList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while ((word = reader.readLine()) != null) {
                wordList.add(word);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordList;
    }
}
