package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    @SuppressWarnings("checkstyle:InnerAssignment")
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        boolean isFinish = false;
        Random randomBotAnswer = new Random();
        List<String> conversation = new ArrayList<>();
        List<String> botAnswers = readPhrases();
        String request;
        String answer;

        while (!isFinish) {
            request = scanner.nextLine();
            answer = botAnswers.get(randomBotAnswer.nextInt(botAnswers.size()));
            conversation.add(request);
            switch (request) {
                case STOP:
                    isContinue = false;
                    break;
                case OUT:
                    isFinish = true;
                    break;
                case CONTINUE:
                    isContinue = true;
                    System.out.println(answer);
                    conversation.add(answer);
                    break;
                default:
                    if (isContinue) {
                        System.out.println(answer);
                        conversation.add(answer);
                    }
            }
        }
        saveLog(conversation);
    }

    public List<String> readPhrases() {
        List<String> listAnswers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().forEach(listAnswers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listAnswers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat("./data/chatLog.txt", "./data/botAnswers.txt");
        chat.run();
    }
}
